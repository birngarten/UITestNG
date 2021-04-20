package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US09_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US09_SeleniumEasyTest {

    US09_SeleniumEasyPage easyPage09 = new US09_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethode(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage09.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
    }

    @Test
    public void TC0901(){
        /*Kullanici, Advanced ==> "JQuery Download Progress bars" linkine tiklar. Acilan sayfada
        'Start Download' butonuna tikladiktan sonra acilan 'File Download' span'inda verinin inmeye
        baslandigini ve islem bittikten sonrada "Complete!" textinin gorundugunu dogrular    */

    }

    @Test
    public void TC0902(){
        /*  Kullanici, Advanced ==> "Bootstrap Download Progress bar" linkine tikladiktan sonra acilan
        sayfada 'Download' butonuna tiklar ve '65%' yuzdelik textinin gorundugunu ve bittikten sonra
        100% textinin oldugunu dogrular  */

    }

}
