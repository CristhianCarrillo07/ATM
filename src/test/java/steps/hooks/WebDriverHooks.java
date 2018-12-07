package steps.hooks;

import cucumber.api.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import support.KnowsTheDomain;

public class WebDriverHooks {

    KnowsTheDomain helper;

    public WebDriverHooks(KnowsTheDomain helper){
        this.helper = helper;
    }

    @After
    public void finish(Scenario scenario){
        try{
            byte[] screenshot = helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        } catch (WebDriverException somePlatformDontSupportScreenshots){
            System.err.println(somePlatformDontSupportScreenshots.getMessage());
        } finally {

        }
    }

}
