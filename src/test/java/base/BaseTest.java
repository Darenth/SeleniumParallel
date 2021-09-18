package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;
    WebDriverWait wait;
    protected HomePage homePage;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        // System.out.println("BeforeSuite");
        driver = getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = getWebDriverWait();
        goHome();
        homePage = new HomePage(driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void goHome() {
        if (driver == null) {
            driver = getChromeDriver();
        }
        driver.get("https://the-internet.herokuapp.com/");
        //System.out.println("BeforeMethod");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        //System.out.println("AfterSuite");
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Files.move(screenshot, new File("src/main/resources/screenshots/"+ result.getName()+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
    }

    public WebDriver getChromeDriver() {

        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions ChromeOptions = new ChromeOptions();
            //ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
            driver = new ChromeDriver(ChromeOptions);

        }
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        if (wait == null) {
            wait = new WebDriverWait(getChromeDriver(), 5);
        }
        return wait;
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

}
