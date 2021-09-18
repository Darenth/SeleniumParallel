package navigation;

import base.BaseTest;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test
    public void testNavigation(){
        homePage.clickDynamic().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refresh();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void  testSwitchTab(){
        homePage.clickMultipleWindowsPage().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}
