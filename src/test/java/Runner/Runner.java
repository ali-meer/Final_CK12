package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/feature",
        glue={"StepDefinition"},
        tags="@LoginTest",
        monochrome=true,
        dryRun=false,
        plugin = {"pretty"
        })


public class Runner {

}
