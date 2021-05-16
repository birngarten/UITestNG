package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US01_SeleniumEasyPage;
import pages.US10_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US10_SeleniumEasyTest {

    US01_SeleniumEasyPage easyPage1;
    US10_SeleniumEasyPage easyPage10 = new US10_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    @BeforeTest
    public void beforeMethode(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage10.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
//        easyPage10.advancedButton.click();
    }

    @Test
    public void TC_01() {
          /*
        Kullanici, Advanced ==> "Drag & Drop Sliders" linkine tiklar. Acilan sayfada 'Default value 10'
        slider'ini range 1'e kaydirir. Range'in 1 oldugunu dogrular
         */
        easyPage10.advancedButton.click();
        easyPage10.DragDropSlidersLink.click();
        easyPage10.setSlider(easyPage10.firstSlider10, easyPage10.firstOutput, 1);

        String actualResult = easyPage10.firstOutput.getText();
        String expectedResult = "1";
        Assert.assertEquals(actualResult,expectedResult);

        Driver.getDriver().navigate().back();
    }


    @Test
    public void TC_02() {
        /*
        Kullanici, Advanced ==> "Drag & Drop Sliders" linkine tiklar. Acilan sayfada 'Default value 30'
        slider'ini range 33'e kaydirir. Range'in 33 oldugunu dogrular
         */
        easyPage10.advancedButton.click();
        easyPage10.DragDropSlidersLink.click();
        easyPage10.setSlider(easyPage10.sliders.get(2), easyPage10.outputs.get(2),33);

        String actualResult = easyPage10.outputs.get(2).getText();
        String expectedResult = "33";
        Assert.assertEquals(actualResult,expectedResult);

        Driver.getDriver().navigate().back();
    }

    @Test
    public void TC_03() {
           /*
        Kullanici, Advanced ==> "Drag & Drop Sliders" linkine tiklar. Acilan sayfada kirmizi renkli
        'Default value 50' slider'ini range 100'e kaydirir. Range'in 100 oldugunu dogrular
         */
        easyPage10.advancedButton.click();
        easyPage10.DragDropSlidersLink.click();
        easyPage10.setSlider(easyPage10.sliders.get(5), easyPage10.outputs.get(5), 100);

        String actualResult = easyPage10.outputs.get(5).getText();
        String expectedResult = "100";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
