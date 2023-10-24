package pages;

import context.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumHelper;

public class LandingPage extends SeleniumHelper {

    WebDriver driver;

    public LandingPage(TestContext testContext){
        super(testContext);
        this.driver = testContext.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void launchApplication(){
        this.driver.get("https://the-internet.herokuapp.com/");
    }

    @FindBy(linkText = "Form Authentication")
    public WebElement link_FormAutomation;

    public void clickOnFormAutomation(){
        click(link_FormAutomation);
    }
}
