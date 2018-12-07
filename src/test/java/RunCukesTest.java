import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:cash_withdrawal.feature",
        glue = {"classpath:steps"},
        plugin = {"pretty","html:out"},
        snippets = SnippetType.CAMELCASE)
public class RunCukesTest {
}