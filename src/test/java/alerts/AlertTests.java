package alerts;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.Retry;

public class AlertTests extends BaseTest {


    @Test (groups = {"Alerts","regressionTests"}, retryAnalyzer = Retry.class)
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.clickToAccept();
        Assert.assertEquals(alertsPage.getTextFromMessage(), "You successfully clicked an alert");

    }

    @Test(groups = {"Alerts","regressionTests"})
    public void testGetTextFromAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.confirmGetText();
        alertsPage.dismissConfirm();
        Assert.assertEquals(text,"I am a JS Confirm");
    }

    @Test(groups = {"Alerts","regressionTests"})
    public void testSetInputInAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        alertsPage.alertSetInput("TAU rocks!");
        alertsPage.clickToAccept();
        String text = alertsPage.getTextFromMessage();
        Assert.assertEquals(text,"You entered: TAU rocks!");
    }
}
