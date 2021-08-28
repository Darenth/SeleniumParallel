import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;


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
        System.out.println(driver == null);
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

    public WebDriver getChromeDriver() {

        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        if (wait == null) {
            wait = new WebDriverWait(getChromeDriver(), 5);
        }
        return wait;
    }

}
