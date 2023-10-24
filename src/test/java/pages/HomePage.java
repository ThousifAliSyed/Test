package pages;

import context.TestContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;

import java.io.IOException;

public class HomePage extends SeleniumHelper {

    WebDriver driver;

    public HomePage(TestContext testContext){
        super(testContext);
        this.driver = testContext.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Logout")
    public WebElement button_Logout;

    public void clickOnLogoutButton(){
        click(button_Logout);
    }

    public void validateLogoutButtonAvailability() throws IOException {
        Assert.assertTrue(isEnabled(button_Logout));
    }
}
