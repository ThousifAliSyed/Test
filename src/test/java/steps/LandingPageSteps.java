package steps;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;

public class LandingPageSteps {

    LandingPage landingPage;

    public LandingPageSteps(TestContext testContext){
        landingPage = new LandingPage(testContext);
    }

    @Given("User navigates to the landing page")
    public void userNavigatesToLandingPage(){
        landingPage.launchApplication();
    }

    @When("User navigates to Login Page")
    public void userNavigateToLoginPage(){
        landingPage.clickOnFormAutomation();
    }
}
