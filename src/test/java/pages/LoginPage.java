package pages;

import context.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;

public class LoginPage extends SeleniumHelper {

    WebDriver driver;

    public LoginPage(TestContext testContext){
        super(testContext);
        this.driver = testContext.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement text_Username;

    @FindBy(id = "password")
    public WebElement text_Password;

    @FindBy(className = "radius")
    public WebElement button_Submit;

    public void enterUserName(){
        sendKeys(text_Username, "tomsmith");
    }

    public void enterPassword(){
        sendKeys(text_Password, "SuperSecretPassword!");
    }

    public void clickOnSubmitButton(){
        click(button_Submit);
    }
}
