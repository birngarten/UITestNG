package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US12_DynamicDataLoadingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US12_DynamicDataLoadingTest {

    US12_DynamicDataLoadingPage us12_Page = new US12_DynamicDataLoadingPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethode(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        us12_Page.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);

    }
    public void reusableMethod() throws InterruptedException {
        us12_Page.advancedButton.click();
        us12_Page.dynamicDataLoadingLink.click();
        us12_Page.newUserButton.click();
        Thread.sleep(1000);
    }

    @Test
    public void TC1201() throws InterruptedException {
        /*
        Kullanici Advanced ==> "Dynamic Data Loading" linkine tiklar. Acilan sayfada 'Get New User'
        butonuna tiklar ve yeni kullanici elde eder. Yeni kullanicinin fotografinin ekranda gorundugunu
        assert eder
         */
        reusableMethod();
        Thread.sleep(1000);
        Assert.assertTrue(us12_Page.newUserFoto.isDisplayed());

        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC1202() throws InterruptedException {
        /*
        Kullanici Advanced ==> "Dynamic Data Loading" linkine tiklar. Acilan sayfada 'Get New User'
        butonuna tiklar ve yeni kullanici elde eder. Yeni kullanicinin First Name ve Last Name'nin
        null olmadigini  assert eder
         */
        reusableMethod();
        Thread.sleep(2000);
        Assert.assertNotNull(us12_Page.firstNameText);

//        String str = "";
//        for (WebElement w: us12_Page.nameList) {
//            str= w.getText();
//
//        }
//        System.out.println(str);
        Driver.getDriver().navigate().back();
    }

    @Test
    public void TC1203() throws InterruptedException {
        /*
        Kullanici Advanced ==> "Dynamic Data Loading" linkine tiklar. Acilan sayfada 'Get New User'
        butonuna tiklar ve yeni kullanici elde eder. 3 defa yeni kullanici elde eder ve elde ettigi
        kullanicilarin farkli first name'lere sahip oldugunu assert eder.
         */
        reusableMethod();
        String firstName1 = us12_Page.firstNameText.getText();

        Driver.getDriver().navigate().refresh();
        us12_Page.newUserButton.click();
        String firstName2 = us12_Page.firstNameText.getText();


        Driver.getDriver().navigate().refresh();
        us12_Page.newUserButton.click();
        String firstName3 = us12_Page.firstNameText.getText();

        Assert.assertNotEquals(firstName1,firstName2);
        Assert.assertNotEquals(firstName2,firstName3);

    }
}
