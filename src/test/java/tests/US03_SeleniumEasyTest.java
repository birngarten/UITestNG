package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US03_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US03_SeleniumEasyTest {

    US03_SeleniumEasyPage easyPage3 = new US03_SeleniumEasyPage();
    Actions action = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethod() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage3.entryMessage.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        easyPage3.startPractisingButton.click();
        easyPage3.javascriptAlertsLink.click();

    }


    @Test
    public void tc0302() throws InterruptedException {
        /*Kullanici, "Java Script Alert Box" panelinde bulunan 'Click me!' butonuna tiklar ve
        pops up'daki "I am alert box!" mesajini alip dogrular. Sonra mesaji kapatir.        */

        easyPage3.clickMeButton.click();
        Thread.sleep(1000);
        String alertMessage = Driver.getDriver().switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);
        Thread.sleep(1000);
        Assert.assertEquals(alertMessage,"I am an alert box!");
        Driver.getDriver().switchTo().alert().accept();

    }

    @Test
    public void tc0303() throws InterruptedException {
        /*"Kullanici, ""Java Script Confirm Box"" panelinde bulunan 'Click me!' butonuna tikladiktan sonra
            pops up'taki 'Cancel' butonuna tiklar ve panelin en alt satirinda cikan 'You pressed Cancel!'
            mesajini dogrular."      */

        Thread.sleep(1000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        easyPage3.confirmClickMeButton2.click();

        Driver.getDriver().switchTo().alert().dismiss();
        Thread.sleep(1000);

        String cancelMessage = easyPage3.cancelMessage.getText();
        System.out.println("cancelMessage = " + cancelMessage);
        Thread.sleep(1000);
        Assert.assertEquals(cancelMessage,"You pressed Cancel!");

    }

    @Test
    public void tc0304() throws InterruptedException {
        /*"Kullanici, ""Java Script Alert Box"" panelinde bulunan 'Click for Prompt Box' butonuna tikladiktan
            sonra pops up'taki 'Please enter your name'  box'ina ismini yazar ve 'OK' butonuna tiklar ve
            panelin en alt satirinda cikan ornegin 'You have entered 'Ali' !' mesajini dogrular."      */

        Thread.sleep(1000);
        easyPage3.clickforPromptBoxButton.click();

        Driver.getDriver().switchTo().alert().sendKeys("Resit");
        Driver.getDriver().switchTo().alert().accept();

        String nameAlertMessage = easyPage3.nameMessage.getText();
        Assert.assertEquals(nameAlertMessage,"You have entered 'Resit' !");

    }
}
