package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/talkToExperts.feature",
                 glue="stepDefintion",
                 dryRun = false
)
public class TestRunnerClass extends AbstractTestNGCucumberTests {

}
