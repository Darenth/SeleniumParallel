package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By result = By.id("result");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("[Step] trigger alert")
    public void triggerAlert() {
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirm() {
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPrompt() {
        driver.findElement(triggerPromptButton).click();
    }

    public void clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public String getTextFromMessage() {
        return driver.findElement(result).getText();
    }

    public void dismissConfirm() {
        driver.switchTo().alert().dismiss();
    }

    public String confirmGetText() {
        return driver.switchTo().alert().getText();
    }

    public void alertSetInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }




}
