package runners;

import courgette.api.*;
import courgette.api.junit.Courgette;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        testOutput = CourgetteTestOutput.CONSOLE,
        reportTargetDir = "build",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "steps",
                tags = "@Regression",
                plugin = {
                        "pretty",
                        "json:build/cucumber-report/cucumber.json",
                        "html:build/cucumber-report/cucumber.html",
                        "junit:build/cucumber-report/cucumber.xml",
                        "message:build/cucumber-report/cucumber.ndjson"}
        )
)
public class ParallelRunner {
    @CourgetteBeforeAll
    public static void setUp(){
        System.out.println("I will run before any tests execute");
    }

    @CourgetteAfterAll
    public static void tearDown() {
        System.out.println("I will run after all of the tests execute");
    }
}
