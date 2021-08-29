package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
    private WebDriver driver;
    private By statusAlert = By.xpath("//div[@data-alert]");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertStatus() {
        return driver.findElement(statusAlert).getText();
    }

}
