package steps;

import context.TestContext;
import io.cucumber.java.en.Then;
import pages.HomePage;

import java.io.IOException;

public class HomePageSteps {

    HomePage homePage;
    public HomePageSteps(TestContext context) {
        homePage = new HomePage(context);
    }

    @Then("Validate User Navigates to Home Page successfully")
    public void validateUserNavigatesToHomePage() throws IOException {
        homePage.validateLogoutButtonAvailability();
    }
}
