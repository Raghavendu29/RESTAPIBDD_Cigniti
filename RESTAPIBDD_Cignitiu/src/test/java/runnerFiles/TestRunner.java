package runnerFiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/index.html"},
        features= "src/main/resources/featureFiles/restBDD.feature",
        glue = {"stepDefinitions"},
        tags = " @Test_GetLowestPrice")


public class TestRunner
{


}
