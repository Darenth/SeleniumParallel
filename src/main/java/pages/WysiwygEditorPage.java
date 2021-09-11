package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea= By.id("tinymce");
    private By increaseIndentButton = By.xpath("//button[@title='Increase indent']");


    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
    public void sendToTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void increaseIndent(){
        driver.findElement(increaseIndentButton).click();
    }

    public String getTextFromField(){
        switchToEditArea();
        String text=driver.findElement(textArea).getText();
        switchToMainArea();
        return text;

    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
}
