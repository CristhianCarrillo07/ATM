package support;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.Teller;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;
    private EventFiringWebDriver webDriver;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }
        return myAccount;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }

    public Teller getTeller() {
        if (teller == null) {
            teller = new AtmUserInterface(getWebDriver());
        }
        return teller;
    }

    public EventFiringWebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium drivers\\chromedriver.exe");
        if(webDriver == null){
            webDriver = new EventFiringWebDriver(new ChromeDriver());
        }
        return webDriver;
    }
}