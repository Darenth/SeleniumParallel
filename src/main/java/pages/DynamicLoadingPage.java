package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DynamicLoadingPage {
    private WebDriver driver;
    private By example1Link= By.xpath("//*[@id='content']/div/a[1]");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadExample1Page clickExample1(){
        driver.findElement(example1Link).click();
        return new DynamicLoadExample1Page(driver);
    }
}
