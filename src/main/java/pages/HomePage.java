package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }
    public  DropdownPage clickDropdown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);

    }
    public  HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }
    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }
    public WysiwygEditorPage clickWysiwyg(){
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public DynamicLoadingPage clickDynamic(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
    public InfinityScrollPage clicInfinityScroll(){
        clickLink("Infinite Scroll");
        return new InfinityScrollPage(driver);
    }

    public LargeAndDeepDOMPage clickLargeAndDeepDome(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDOMPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindowsPage(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }


}
