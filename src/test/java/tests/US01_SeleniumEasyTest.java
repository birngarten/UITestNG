package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US01_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US01_SeleniumEasyTest {

    US01_SeleniumEasyPage easyPage1 = new US01_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void beforeMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
//        easyPage.entryMessage.click();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        ReusableMethods.waitFor(1);
//        The user clicks on "Start Practicing"
//        easyPage.startPractisingButton.click();

    }

    @Test
    public void TC0101(){
//        The user clicks on "Start Practicing"
        easyPage1.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        easyPage1.startPractisingButton.click();

    }
    @Test
    public void TC0102(){
//        The user clicks on "Simple Form Demo"
        easyPage1.startPractisingButton.click();
        easyPage1.simpleFormDemoLink.click();

    }

    @Test
    public void TC0103(){
//        "Kullanici, Single Input Field basligi altindaki ""Enter message"" box'ina mesaj yazdidinda ve
//          ""Show Message"" butonuna tikladiginda ""Your Message:"" kisminda mesaj box'ina yazmis
//          oldugu mesaji gormeli ve dogrulamalidir"
        easyPage1.startPractisingButton.click();
        easyPage1.simpleFormDemoLink.click();
        easyPage1.userMessageBox.sendKeys("Hello");
        easyPage1.showMessageButton.click();
        Assert.assertTrue(easyPage1.seeHelloMessage.isDisplayed());

    }

    @Test
    public void TC0104(){
//        "Kullanici, Two Input Fields basligi altindaki ""Enter a"" ve ""Enter b"" box'larina sayisal degerler
//          disinda karakter girdiginde ve ""Get Total"" butonuna tiladiginda ""Total a + b = NaN"" mesajini
//          almali ve bunu dogrulamalidir. Sayisal degerler girdiginde ""Total a + b = ..."" girdigi rakamlarin
//          toplamini almali ve bunu dogrulayabilmelidir."
        easyPage1.startPractisingButton.click();
        easyPage1.simpleFormDemoLink.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        easyPage1.enterA_Box.sendKeys("a");
        easyPage1.enterB_Box.sendKeys("b");
        easyPage1.getTotalButton.click();
        Assert.assertTrue(easyPage1.getTotalNegativeMessage.isDisplayed());

        Driver.getDriver().navigate().refresh();
        easyPage1.enterA_Box.sendKeys("2");
        easyPage1.enterB_Box.sendKeys("3");
        easyPage1.getTotalButton.click();
        Assert.assertEquals(easyPage1.getTotalPositiveMessage.getText(),"5");

    }
}
