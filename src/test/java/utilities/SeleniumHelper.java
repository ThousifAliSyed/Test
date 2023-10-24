package utilities;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SeleniumHelper {

    WebDriver driver;
    TestContext testContext;

    @Before
    public void setUp(){
        System.out.println("set up method");
        testContext.setDriver(launchBrowser(Configuration.getProperty("browserName")));
    }

    public SeleniumHelper(TestContext testContext){
        this.testContext = testContext;
    }

    public WebDriver launchBrowser(String browserName){
        switch (browserName.toUpperCase()){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
                this.driver = new ChromeDriver();
                break;
            case "IE":
                System.setProperty("webdriver.ie.driver", "src\\test\\resources\\drivers\\internetexplorerdriver.exe");
                this.driver = new InternetExplorerDriver();
                break;
            default:
                this.driver = null;
                break;
        }
        return this.driver;
    }

    public WebDriver getDriver() {
        if(this.driver!=null){
            return this.driver;
        }
        else{
            return launchBrowser(Configuration.getProperty("browserName"));
        }
    }

    public void click(WebElement element){
        try{
            isEnabled(element);
            isDisplayed(element);
            element.click();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Unable to click on the element "+element);
        }
    }

    public boolean isEnabled(WebElement element) throws IOException {
        boolean result = false;
        try{
            result = element.isEnabled();
        }catch (Exception e){
            e.printStackTrace();
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("D:\\projects\\Test\\screenshot1.jpg");
            FileUtils.copyFile(src, destFile);
        }
        return result;
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void sendKeys(WebElement element, String value){
        try{
            isEnabled(element);
            isDisplayed(element);
            element.clear();
            element.sendKeys(value);
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("Unable to enter value in element "+element);
        }
    }

    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String mainHandle = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        Iterator<String> iterator = windows.iterator();

        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                driver.close();
            }
            driver.switchTo().window(mainHandle);
        }
    }

    @After
    public void tearDown(){
        getDriver().quit();
    }
}
