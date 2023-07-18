
package Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/Featurefiles/AddPlace.feature",
        glue ={"stepDefinition"},
        plugin = {"json:target/cucumber.json"})

public class TestRunner {

    //  plugin = {"pretty", "html:target/cucumber-reports"}



}


