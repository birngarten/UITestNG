package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US07_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.ArrayList;
import java.util.List;

public class US07_SeleniumEasyTest {

    US07_SeleniumEasyPage easyPage07 = new US07_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethode() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage07.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
    }

    @Test
    public void TC0701() throws InterruptedException {
        /*Kullanici, Advanced ==> "Table Filter" linkine tiklar ve 'Filter Records' basligi altindaki conteynir'da
        toplam 5 tane element bulundugunu "Orange" butonuna tikladiktan sonra  2 element kaldigini assert eder.
         */
        easyPage07.advancedButton.click();
        easyPage07.tableFilterLink.click();

        Assert.assertTrue(easyPage07.panelContainerList.size()==5);
        Thread.sleep(1000);
        easyPage07.orangeButton.click();
//        ***** CALIS UYARLA
//        int count = 0;
//        for (WebElement w : tabloFilterPage.mediaElements) {
//            tabloFilterPage.orangeButton.click();
//            if (!w.getAttribute("style").equals("display: none;")) {
//                count++;
//
//            }
//        }
        Assert.assertTrue(easyPage07.orangeElementList.size()==2);
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0702(){
        /*"Kullanici, Advanced ==>  ""Table Sort & Search"" linkine tikladiktan sonra  acilan sayfada toplam 32
            kisiye ait bilgi oldugunu ve en altta ""Showing 1 to 32 of 32 entries"" yazisini dogrular. "
         */
        easyPage07.advancedButton.click();
        easyPage07.tableSortSearchLink.click();
        Select select = new Select(easyPage07.selectDropdown);
        select.selectByIndex(2);
        Assert.assertTrue(easyPage07.roleNumbersList.size() == 32);

        String actualInfoText = "Showing 1 to 32 of 32 entries";
        Assert.assertEquals(actualInfoText,easyPage07.selectInfotext.getText());
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0703() throws InterruptedException {
        /*"Kullanici, Advanced ==>  ""Table Sort & Search"" linkine tikladiktan sonra  acilan sayfada  en
            yuksek maasi(salary) 200,000 binden fazla olan 18 kisinin oldugu,  4 kisinin Tokyo'da
            calistigini dogrular. Ayrica calisanlarin yas ortalamasini bulur."             */
        easyPage07.advancedButton.click();
        easyPage07.tableSortSearchLink.click();

        Select select = new Select(easyPage07.selectDropdown);
        select.selectByIndex(2);
        actions.click(easyPage07.salaryHeadButton).click().build().perform();

        List<Integer> listOfSalaries = new ArrayList<>();
        for (WebElement w: easyPage07.salariesList){
          int a = Integer.parseInt(w.getText().substring(1,w.getText().length()-2).replace(",",""));
          if(a>200000){                         // 1200000
              listOfSalaries.add(a);
          }
        }
//        System.out.println("listOfSalaries :"+listOfSalaries.size());
        Assert.assertTrue(listOfSalaries.size() == 18);

//         4 kisinin Tokyo'da calistigini dogrular
        easyPage07.searchBox.sendKeys("Tokyo");
        Assert.assertTrue(easyPage07.employeeInTokyo.size()==4);
        Driver.getDriver().navigate().refresh();
        select.selectByIndex(2);

//        calisanlarin yas ortalamasi

        int sumOfAges = 0;
        int count = 0;
        for (WebElement w: easyPage07.ageList){
            sumOfAges += Integer.parseInt(w.getText());
          count++;
        }
        System.out.println("SumAge : " +sumOfAges);
        System.out.println("count = " + count);

        int avgAllAge = sumOfAges/count;
        Assert.assertTrue(avgAllAge == 41);

    }
}
