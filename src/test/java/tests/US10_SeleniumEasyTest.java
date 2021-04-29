package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US10_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US10_SeleniumEasyTest {

    US10_SeleniumEasyPage easyPage10 = new US10_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethode(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage10.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        easyPage10.advancedButton.click();
    }

    @Test
    public void TC1001() {
        /*
        Kullanici, Advanced ==> "Drag & Drop Sliders" linkine tiklar. Acilan sayfada 'Default value 10'
        slider'ini range 1'e kaydirir. Range'in 1 oldugunu dogrular
         */
        easyPage10.DragDropSlidersLink.click();

    }

    @Test
    public void TC1002() {
        /*
        Kullanici, Advanced ==> "Drag & Drop Sliders" linkine tiklar. Acilan sayfada 'Default value 30'
        slider'ini range 33'e kaydirir. Range'in 33 oldugunu dogrular
         */

    }

    @Test
    public void TC1003() {
        /*
        Kullanici, Advanced ==> "Drag & Drop Sliders" linkine tiklar. Acilan sayfada kirmizi renkli
        'Default value 50' slider'ini range 100'e kaydirir. Range'in 100 oldugunu dogrular
         */

    }
}
