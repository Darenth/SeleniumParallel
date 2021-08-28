import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.xpath("//input[@type='range']");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setValueToSlider(String value) {
        WebElement sliderBar = driver.findElement(slider);
        sliderBar.sendKeys(value);

    }

    public String getValueFromSlider() {
        return driver.findElement(range).getText();
    }

}
