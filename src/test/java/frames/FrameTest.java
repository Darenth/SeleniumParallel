package frames;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;
import static org.testng.Assert.*;
public class FrameTest extends BaseTest {

    @Test(groups = {"FrameTest", "regressionTests"})
    public void textIntoTextArea() {
        String text = "Hello world";
        var editorPage = homePage.clickWysiwyg();
        editorPage.clearTextArea();
        editorPage.sendToTextArea(text);
        editorPage.increaseIndent();
        assertEquals(text,editorPage.getTextFromField());

    }
}
