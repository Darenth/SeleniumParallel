package horizontalslider;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderPageTests extends BaseTest {

    @Test(groups = {"HorizontalSliderPageTests","regressionTests"})
    public void testHorizontalSlider(){
        String range="3";
        var slider =homePage.clickHorizontalSlider();
        for (int i = 0; i < 6; i++) {
            slider.setValueToSlider("A"+ Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(slider.getValueFromSlider(),range, "Range is not equal");


    }
}
