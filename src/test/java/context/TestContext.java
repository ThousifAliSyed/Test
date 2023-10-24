package context;

import org.openqa.selenium.WebDriver;

public class TestContext {
    WebDriver driver;

    public TestContext(){

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
