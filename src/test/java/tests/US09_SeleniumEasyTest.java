package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US09_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US09_SeleniumEasyTest {

    US09_SeleniumEasyPage easyPage09 = new US09_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void beforeMethode(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));

        try{
            easyPage09.entryMessage.click();
        }catch(Exception ignored){

        }

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        easyPage09.advancedButton.click();
    }

    @Test
    public void TC0901() throws InterruptedException {
        /*Kullanici, Advanced ==> "JQuery Download Progress bars" linkine tiklar. Acilan sayfada
        'Start Download' butonuna tikladiktan sonra acilan 'File Download' span'inda verinin inmeye
        baslandigini ve islem bittikten sonrada "Complete!" textinin gorundugunu dogrular    */
        easyPage09.JQueryDownloadProgressbarsLink.click();
        Thread.sleep(1000);
        easyPage09.downloadButton.click();
        Thread.sleep(1000);
//        String style = easyPage09.styleCSS.getAttribute("style");
//        System.out.println(style);
        Assert.assertTrue(easyPage09.completeDownloadText.isDisplayed());
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0902() throws InterruptedException {
        /*  Kullanici, Advanced ==> "Bootstrap Download Progress bar" linkine tikladiktan sonra acilan
        sayfada 'Download' butonuna tiklar ve '65%' yuzdelik textinin gorundugunu ve bittikten sonra
        100% textinin oldugunu dogrular  */
        easyPage09.advancedButton.click();
        easyPage09.BootstrapDownloadProgressLink.click();
        Thread.sleep(1000);
        easyPage09.cricleButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        WebElement percent65 = wait.until(ExpectedConditions.visibilityOf(easyPage09.percent65));
        String actualResult = percent65.getText();
        Assert.assertTrue(actualResult.equals("65%"));

        WebElement percent100 = wait.until(ExpectedConditions.visibilityOf(easyPage09.percent100));
        Assert.assertTrue(percent100.isDisplayed());

    }

}
