package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US04_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US04_SeleniumEasyTest {

    US04_SeleniumEasyPage easyPage4 = new US04_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethod() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage4.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

    }

    @Test
    public void TC0401() throws InterruptedException {
        /*Kullanici, INTERMEDIATE basliginin altinda bulunan "Ajax Form Submit" linkine tiklar ve 'Ajax Form"
          bolumunde bulunan Name ve Comment input'larini doldurup Submit butonuna tikladiktan sonra
          "Form submited Successfully!" mesajini aldigini dogrular.                 */
        easyPage4.startPractisingButton.click();
        easyPage4.proceedNextButton.click();

        easyPage4.ajaxFormSubmitLink.click();
        easyPage4.ajaxFormNameBox.sendKeys("TryCatch");
        easyPage4.ajaxFormCommentBox.sendKeys("I hope everything will be fine!");
        easyPage4.ajaxSubmitButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(easyPage4.formSubmittedSuccessfulyMessage.getText(),"Form submited Successfully!");
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0402() throws InterruptedException {
      /*"Kullanici,INTERMEDIATE basliginin altinda bulunan "JQuery Select dropdown"linkine tiklar ve sirasiyla
            1)Select Country : dropDown kisminda 'United States of America',
            2)Select State : kisminda 'Michigan' eyaletini,
            3)Select US Outlying Territories : kisminda 'Virgin Islands' ve
            4)'Select a file' dropDown'da 'Java' yi secer.
            herbirinin gorundugunu dogrular"         */
        easyPage4.startPractisingButton.click();
        easyPage4.proceedNextButton.click();
        easyPage4.jQuerySelectDropdownLink.click();

        Select select = new Select(easyPage4.selectCountryDropDown);
        select.selectByVisibleText("United States of America");
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("United States of America"));

        Select selectState = new Select(easyPage4.stateSelectBox);
        selectState.selectByVisibleText("Michigan");
        Assert.assertEquals(selectState.getFirstSelectedOption().getText(),"Michigan");
        Thread.sleep(1000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select select1 = new Select(easyPage4.selectVirginIslands);
        select1.selectByIndex(5);
        Assert.assertEquals(select1.getFirstSelectedOption().getText(),"Virgin Islands");

        Select selectFile = new Select(easyPage4.selectFile);
        selectFile.selectByVisibleText("Java");
        Assert.assertEquals(selectFile.getFirstSelectedOption().getText(),"Java");
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0403() throws InterruptedException {
        /*"Kullanici, INTERMEDIATE basliginin altinda bulunan ""Bootstrap List Box"" linkine tiklar ve
            Dual List Box'inin sol bolumunde bulunan;
          - 'bootstrap-duallist'
            item'ini sag bolume, sag bolumde bulunan;
          - 'Cras justo odio' item'ini da sol bolume tasir ve sag ve sol bolumdeki yeni listeleri asert eder */
        easyPage4.startPractisingButton.click();
        easyPage4.proceedNextButton.click();

        easyPage4.bootstrapListBoxLink.click();

        easyPage4.leftItemsList.get(0).click();
        easyPage4.leftToRightButton.click();
        easyPage4.bootstrapDuallistItem.click();

        Thread.sleep(2000);

        easyPage4.rightItemsList.get(0).click();
        easyPage4.rightToLeftButton.click();
        easyPage4.crasJustoOdioItem.click();

        String expectedAllLeftItems = easyPage4.allLeftItems.getText();
        String [] actualLeftItemsList = {"Dapibus ac facilisis in","Morbi leo risus","Porta ac consectetur ac","Vestibulum at eros","Cras justo odio"};

        for(String left: actualLeftItemsList){
           Assert.assertTrue(expectedAllLeftItems.contains(left));
        }

        String expectedAllRightItems = easyPage4.allRightItems.getText();
        String [] actualRightItemsList ={"Dapibus ac facilisis in","Morbi leo risus","Porta ac consectetur ac","Vestibulum at eros","bootstrap-duallist"};
        for(String right: actualRightItemsList){
            Assert.assertTrue(expectedAllRightItems.contains(right));
        }

    }

}
