package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

public class CashSlotSteps {

    KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper){
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -", dollars,helper.getCashSlot().getContents());
    }
}
