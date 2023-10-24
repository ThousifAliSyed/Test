package steps;

import context.TestContext;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginPageSteps {

    LoginPage loginPage;

    public LoginPageSteps(TestContext testContext) {
        loginPage = new LoginPage(testContext);
    }

    @And("User enters username")
    public void userEntersUserName(){
        loginPage.enterUserName();
    }

    @And("User enters password")
    public void userEntersPassword(){
        loginPage.enterPassword();
    }

    @And("User clicks on Submit Button")
    public void userClicksOnSubmitButton(){
        loginPage.clickOnSubmitButton();
    }
}
