package dynamic;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class DynamicTests extends BaseTest {

    @Test
    public void testWaitUnilHidden(){
        var loadingPage= homePage.clickDynamic().clickExample1();
        loadingPage.clickStartButton();
        assertEquals(loadingPage.getLoadedText(),"Hello World!","Error message");

    }
}
