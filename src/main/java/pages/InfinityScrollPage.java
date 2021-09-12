package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InfinityScrollPage {
    private WebDriver driver;
    private By textBlock = By.className("jscroll-added");


    public InfinityScrollPage(WebDriver driver) {
        this.driver = driver;
    }
    /*
    * @param index
    *
    * */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = ((JavascriptExecutor) driver);
        while (getNumberOfParagraphPresent()<1){
            jsExecutor.executeScript(script);

        }
    }
    private int getNumberOfParagraphPresent(){
        return driver.findElements(textBlock).size();
    }

}
