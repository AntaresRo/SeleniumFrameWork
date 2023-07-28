package com.herokuapp.theinternet.iframes;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.IFramePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class IFramesTests extends TestUtilities {

    @Test
    public void iFrameTests() {
        IFramePage iFramePage = new IFramePage(driver, log);
        iFramePage.openPage();

        String editorText = iFramePage.getEditorText();
        Assert.assertEquals(editorText, "Your content goes here.", "Editor default text is not expected. It is: " + editorText);


    }


}
