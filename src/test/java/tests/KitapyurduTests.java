package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KitapyurduPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;

public class KitapyurduTests {

    KitapyurduPage pages = new KitapyurduPage(Driver.getDriver());

    @Test
    public void TC01() {
        Driver.getDriver().get(ConfigReader.getProperty("google"));
        ReusableMethods.waitFor(5);
        Driver.getDriver().switchTo().frame(0);
        pages.ichStimmeZu.click();

//        1.	Arama box.ına “kitap yurdu" yazıp arama yapın.
        Driver.getDriver().get(ConfigReader.getProperty("google"));
        pages.searchBox.sendKeys("kitap yurdu" + Keys.ENTER);

    }
    @Test
    public void TC02() {
//        2.	Arama sonucunlarındaki ilk sonuca tıklayıp  https://www.kitapyurdu.com/ sitesine giriş yapın.
        Driver.getDriver().get(ConfigReader.getProperty("kitapYurduUrl"));
        ReusableMethods.waitFor(1);
        pages.kitapYurduLink.click();

    }
    @Test
    public void TC03() {
//      3.	https://www.kitapyurdu.com/ sitesinin title.ının “Kitapyurdu, Kitapla buluşmanın en kolay yolu”
//       olduğunu kontrol edin.
        ReusableMethods.waitFor(2);
        String expectedTitle = Driver.getDriver().getTitle();
        String actualTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        Assert.assertEquals(expectedTitle, actualTitle);
//        System.out.println("Basligi al : "+expectedTitle);
    }
    @Test
    public void TC04(){
//      4.	Sepetim linkine tıklayarak sepetin boş olduğunu kontrol edin.
        ReusableMethods.waitFor(2);
        pages.alisverisSepeti.click();
        String alisverisSepetTex= pages.alisverisSepetiBos.getText();
        Assert.assertEquals(alisverisSepetTex,"Alışveriş sepetiniz boş!");
//        System.out.println(alisverisSepetTex);

    }

    @Test
    public void TC05() {
//      5.	https://www.kitapyurdu.com/ sitesinde en çok satan 10 kitabı listeleyin.
        List<String> enCokSatanlarListesi = new ArrayList<>();
        for (WebElement w : pages.enCokSatanlarList) {
            enCokSatanlarListesi.add(w.getText());
        }
//        System.out.println(enCokSatanlarListesi);

    }
    @Test
    public void TC06(){
//        6.	En çok satan kitabın “Körlük” olduğunu kontrol edin.
        List<String> enCokSatanlarListesi = new ArrayList<>();
        for (WebElement w : pages.enCokSatanlarList) {
            enCokSatanlarListesi.add(w.getText());
        }
        String ilkKitap = enCokSatanlarListesi.get(0);
        Assert.assertTrue(ilkKitap.contains("Körlük"));
    }
    @Test
    public void TC07() {
//        7. Kitap, yazar, yayınevi arama box.ına “suç ve ceza” yazarak çıkan sonuçlardan “Suç ve Ceza 1”
//        ve “Suç ve Ceza 2” kitaplarının fiyatlarının “9,00” ve “7,49” olduğunu kontrol edin.
        pages.kitapYurduSearchBox.sendKeys("suç ve ceza" + Keys.ENTER);
        pages.sucVeCeza1.click();
        String expectedPrice =pages.priceItem.getText();
        Assert.assertEquals(expectedPrice,"9,00");

        Driver.getDriver().navigate().back();

        pages.sucVeCeza2.click();
        Assert.assertEquals(pages.priceItem.getText(),"7,49");
        pages.kitapYurduSearchBox.clear();

    }
    @Test
    public void TC08() {
//        8.	Her iki kitabı da sepete ekleyin ve sepetinizde bu ürünlerin yer aldığını kontrol edin.
        pages.kitapYurduSearchBox.sendKeys("suç ve ceza"+ Keys.ENTER);
        ReusableMethods.waitFor(1);
        pages.sucVeCeza1.click();
        ReusableMethods.waitFor(1);
        pages.sepeteEkle.click();
        ReusableMethods.waitFor(1);

        Driver.getDriver().navigate().back();

        ReusableMethods.waitFor(1);
        pages.sucVeCeza2.click();
        ReusableMethods.waitFor(1);
        pages.sepeteEkle.click();

        pages.alisverisSepeti.click();

        for (WebElement w: pages.sepettekiKitaplar){
//            System.out.println("Sepetteki Kitaplar :"+w.getText());
            Assert.assertTrue(w.isDisplayed());
        }
    }
}
// NOT : Her method'un tek basina calismasi icin:
// ==> Driver.getDriver().get(ConfigReader.getProperty("kitapYurduUrl")); code'unun eklenmesi gerkiyor
// Ancak class'tan yapilan run'a TC02() method'u haric diger method'lara bu code'u yazmaya gerek yok

