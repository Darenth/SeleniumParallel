package login;

import base.BaseTest;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecurePage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(groups = {"LoginTest","regressionTests"})
    public void testSucessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecurePage securePage = loginPage.clickLoginButton();
        System.out.println(securePage.getAlertStatus());
        assertTrue(securePage.getAlertStatus().contains("You logged into a secure area"),"Alert text is not correct");
    }
}
