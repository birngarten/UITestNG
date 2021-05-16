package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US11_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US11_SeleniumEasyTest {

    US11_SeleniumEasyPage easyPage11 = new US11_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    @BeforeTest
    public void beforeMethode(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage11.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        easyPage11.advancedButton.click();
    }

    @Test
    public void TC1101() throws InterruptedException {
     /*
    Kullanici Advanced ==> "Drag and Drop" linkine tiklar. Acilan sayfada 'Items to Drag''ta bulunan 4 adet
     'Draggable item'i alip 'Dropped Items List'e drop eder. List icinde 4 adet item oldugunu Assert eder.
     */
        easyPage11.Drag_and_DropLink.click();

        JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();

        for (WebElement w: easyPage11.draggableItemsList){
            executor.executeScript("arguments[0].click();", w);
            actions.moveToElement(easyPage11.dropZone).perform();
            Thread.sleep(1000);
        }
    }
}
/*
 final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";

        for (WebElement w : dragablePage.dragableItems) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript(java_script, w, dragablePage.dropZone);
            Thread.sleep(2000);
        }
 */
