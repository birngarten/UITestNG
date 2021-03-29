package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US05_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import java.nio.file.Files;
import java.nio.file.Paths;

public class US05_SeleniumEasyTest {

    US05_SeleniumEasyPage easyPage5 = new US05_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethod() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage5.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);
//        easyPage5.startPractisingButton.click();
//        easyPage5.proceedNextButton.click();

    }

    @Test
    public void TC0501(){
        /* Kullanici, INTERMEDIATE ==> "JQuery List Box" linkine tiklar ve 'Pick List' panelinde bulunan
          'Valentina', 'Giovanna', 'Helena', 'Lara' ve 'Julia' option'larini alarak, sag panele ekler ve sol panelde
           10 options, sag panelde de 5 options oldugunu dogrular.         */
        easyPage5.startPractisingButton.click();
        easyPage5.proceedNextButton.click();

        easyPage5.jQueryListBoxLink.click();
        Select select = new Select(easyPage5.selectOptionsFromPanel);
        select.selectByVisibleText("Valentina");
        select.selectByVisibleText("Giovanna");
        select.selectByVisibleText("Helena");
        select.selectByVisibleText("Lara");
        select.selectByVisibleText("Julia");
        easyPage5.addButton.click();
        Assert.assertTrue(easyPage5.leftPanelOptionsList.size()==10);
        Assert.assertTrue(easyPage5.rigthPanelOptionsList.size()==5);
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0502() throws InterruptedException {
        /*"Kullanici, INTERMEDIATE ==> ""Data List Filter"" linkine tikladiktan sonra  acilan sayfada herbir kisiye
            ait Email adresinin oldugunu ve 'Search Attendees...' search box'ina  ""Brian Hoyies"" yazdiginda
            sayfada sadece O'na ait bilgilerin kaldigini dogrular."        */
        Thread.sleep(1000);
        easyPage5.startPractisingButton.click();
        easyPage5.proceedNextButton.click();

        easyPage5.dataListFilterLink.click();

        for(WebElement w: easyPage5.namesInfoList){
            Assert.assertTrue(w.getText().contains("@company.com"));
        }

        String allContentInfo = easyPage5.contentAllInfo.getText();
//        System.out.println("allContentInfo = " + allContentInfo);

        easyPage5.searchAttendeesBox.sendKeys("Brian Hoyies");

        String briansContentInfo = easyPage5.contentInfo.getText();
//        System.out.println("briansContentInfo = " + briansContentInfo);

        Assert.assertNotEquals(allContentInfo,briansContentInfo);
        Assert.assertTrue(easyPage5.contentInfo.getText().equals("Company Name\n" +
                                                                 "Name: Brian Hoyies\n" +
                                                                 "Title: Manager\n" +
                                                                 "Phone: 564-234-4444, Email: test4@company.com"));
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0503() throws InterruptedException {
        /*"Kullanici, INTERMEDIATE ==> File Download linkine tiklar. 'Enter Data' textarea'ya
            ""Selenium practice yapiyorum!"" seklinde yazdiginda textarea'nin hemen altindaki satirda
            472 karekter daha kaldigini dogrular.
            'Generate File' butonuna tikladiktan sonra cikan 'Download' linkine tiklar.
            ""Selenium practice yapiyorum!"" cumlesinin download edildigini dogrular."         */
        Thread.sleep(1000);
        easyPage5.startPractisingButton.click();
        easyPage5.proceedNextButton.click();

        easyPage5.fileDownLink.click();
        easyPage5.textAreaBox.sendKeys("Selenium practice yapiyorum!");

        Assert.assertTrue(easyPage5.feedbackChracters.getText().contains("472"));

        easyPage5.generateFileButton.click();
        easyPage5.downloadButtonLink.click();
// 1.Yol :
        String fileDownloadPath = "C:/Users/Administrator/Downloads/easyinfo (1).txt";
        boolean dosyaDownloadEdildiMi = Files.exists(Paths.get(fileDownloadPath));
        Assert.assertTrue(dosyaDownloadEdildiMi);
//// 2.Yol  :
//        String url = "https://www.seleniumeasy.com/test/generate-file-to-download-demo.html";

    }
}
