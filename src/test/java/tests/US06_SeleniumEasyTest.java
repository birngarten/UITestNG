package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US06_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US06_SeleniumEasyTest {

    US06_SeleniumEasyPage easyPage6 = new US06_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethode() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage6.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
    }

    @Test
    public void TC0601(){
        /*Kullanici, Advanced ==> "Table Pagination" linkine tiklar ve toplam 3(uc) sayfa link oldugunu ve
         ileri geri play linklerinin calistigini  dogrular. Toplam 78 tane cell oldugunu assert ediniz.    */
        easyPage6.advancedButton.click();
        easyPage6.tablePaginationLink.click();

        // toplam 3(uc) sayfa link oldugunu
        int pagesNum = 0;
        for (int i=0; i<easyPage6.pagesNumbersList.size(); i++){
            pagesNum++;
        }
        Assert.assertTrue(pagesNum==3);

        // ileri geri play linklerinin calistigini  dogrular
        for (WebElement w: easyPage6.disPlaylinkList){
            Assert.assertTrue(w.isDisplayed());
        }

        // Toplam 78 tane cell oldugunu assert ediniz.
        int allCellsNum = 0;
        for(int i=0; i<easyPage6.cellList.size();i++){
            allCellsNum++;
        }

        Assert.assertTrue(allCellsNum == 78);
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0602() throws InterruptedException {
        /*  Kullanici, Advanced ==>  ""Table Data Search"" linkine tikladiktan sonra  acilan sayfada
            'Tasks' panelinin altinda "#", "Task", "Assignee", "Status" basliklarinin oldugunu dogrular.
            Input'ta (filter box)  "Filter by Task / Assignee / Status" textinin  yer aldigini ve input'a "Mike"
            yazdiginda ekranda sadece Mike Trout'a ait satirin kaldigi assert eder.         */
        easyPage6.advancedButton.click();
        easyPage6.tableDataSearchLink.click();

        String expectedHeaderList = easyPage6.taskHeadersList.getText();

        String [] headersList = {"#", "Task", "Assignee", "Status"};
        for (String w: headersList){
            Assert.assertTrue(expectedHeaderList.contains(w));
        }

        String actualPlaceholder = "Filter by Task / Assignee / Status ";
//      Input'ta (filter box)  "Filter by Task / Assignee / Status" textinin  yer aldigini dogrular
        String expectedPlaceholder = easyPage6.placeholderTextArea.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder);

        Thread.sleep(1000);
        easyPage6.placeholderTextArea.sendKeys("Mike");
        Assert.assertTrue(easyPage6.mikeBodyText.size()==1);

        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0603() throws InterruptedException {
        /*"Kullanici, Advanced ==> ""Table Data Search"" linkine tikladiktan sonra acilan sayfada 'Listed Users'
            panelinin aldindaki dort(4) tane input'un aktif olmadigini, 'Filter' butonuna basildiktan sonra
            bu input box'larin aktiflestigini dogrular.
            'FirstName' input box'ina ""B"" karakteri girildiginde panelde sadece ""Brigade"", ""Byron"" isimlerinin
            kaldigi assert edilmelidir."         */

        easyPage6.advancedButton.click();
        easyPage6.tableDataSearchLink.click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

//      'Listed Users' panelinin aldindaki dort(4) tane input'un aktif olmadigini
        for (WebElement w: easyPage6.inactiveInputList){
            Assert.assertFalse(w.isEnabled());
        }
//        'Filter' butonuna basildiktan sonra bu input box'larin aktiflestigini dogrular.
        easyPage6.makeActiveButton.click();

        for (WebElement w: easyPage6.inactiveInputList){
            Assert.assertTrue(w.isEnabled());
        }

        Thread.sleep(1000);
                easyPage6.searchBoxList.get(3).sendKeys("B");
        for (WebElement w: easyPage6.listB){
            System.out.println("w.getText() = " + w.getText());
        }
//        System.out.println(easyPage6.listB.get(0).getText());


    }
}
