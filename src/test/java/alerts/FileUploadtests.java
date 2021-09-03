package alerts;

import base.BaseTest;
import io.qameta.allure.*;
import listener.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

@Listeners({TestListener.class})
@Epic("Regression tests")
@Feature("Upload tests")
public class FileUploadtests extends BaseTest {
    @Link("https://example.org")
    @Severity(SeverityLevel.MINOR)
    @Description("Test for check file upload functionality")
    @Test(groups = {"FileUploadtests", "regressionTests"})
    @TmsLink("test-1")
    public void testFileUpload() {
        File file = new File("src/main/resources/Pic.jpg");

        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile(file.getAbsolutePath());
        Assert.assertEquals(uploadPage.getNameOfUploadedFile(), "Piac.jpg");
    }
}
