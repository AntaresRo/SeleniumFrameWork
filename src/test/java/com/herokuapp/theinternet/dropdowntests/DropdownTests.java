package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdwonPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Test
    @Parameters("index")
    public void DropdownTest(@Optional("1") int index) {
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        DropdwonPage dropdwonPage = welcomePage.clickDropdownPage();
        dropdwonPage.selectOption(index);
        sleep(3000);

        String selectedOption = dropdwonPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option " + index));

    }
}
