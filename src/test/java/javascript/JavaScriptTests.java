package javascript;

import base.BaseTest;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTest {
    @Test
    public void  testToTable(){
        homePage.clickLargeAndDeepDome().scrollToTable();
    }
    @Test
    public void scrollToFifthParagraph(){
        homePage.clicInfinityScroll().scrollToParagraph(5);
    }
}
