package support;

import steps.hooks.ServerHooks;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AtmUserInterface implements Teller {

    private final EventFiringWebDriver webDriver;

    public AtmUserInterface(EventFiringWebDriver webDriver){
        this.webDriver = webDriver;
    }

    @Override
    public void withdrawFrom(Account account, int dollars) {
        try{
            webDriver.get("http://localhost:" + ServerHooks.PORT);
            webDriver.findElement(By.id("amount")).sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("withdraw")).click();
        } finally {
            webDriver.close();
        }
    }
}
