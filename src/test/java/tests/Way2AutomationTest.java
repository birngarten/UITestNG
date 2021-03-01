package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Way2AutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;
import java.util.*;

public class Way2AutomationTest {

    Way2AutomationPage way2Auto = new Way2AutomationPage();
    Actions action = new Actions(Driver.getDriver());

    @BeforeMethod
    public void beforeMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("wayAutomation2URL"));
        way2Auto.signin.click();
        way2Auto.userName.sendKeys(ConfigReader.getProperty("way2AutomationUsername"));
        way2Auto.password.sendKeys(ConfigReader.getProperty("way2AutomationPassword"));
        way2Auto.submitButton.click();
        ReusableMethods.waitFor(2);
        action.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void test01() {


        way2Auto.draggableLink.click();

        Driver.getDriver().switchTo().frame(0);

        String valueBefore = way2Auto.dragMeArround.getAttribute("style");
        System.out.println(valueBefore);

        ReusableMethods.waitFor(2);
        action.clickAndHold(way2Auto.dragMeArround).build().perform();
        action.moveByOffset(100, 150).build().perform();
        action.release().perform();

        String valueAfter = way2Auto.dragMeArround.getAttribute("style");
        System.out.println(valueAfter);
        Assert.assertNotEquals(valueBefore, valueAfter);


    }

    @Test
    public void test02() {
        way2Auto.draggableLink.click();
        way2Auto.courserStyle.click();
        Driver.getDriver().switchTo().frame(2);
        ReusableMethods.waitFor(2);
        action.clickAndHold(way2Auto.style1).build().perform();
        ReusableMethods.waitFor(1);
        action.moveByOffset(100, 100).perform();
        action.release().perform();

        action.clickAndHold(way2Auto.style2).perform();
        action.moveByOffset(200, 170);
        action.release().perform();
        ReusableMethods.waitFor(3);
        action.clickAndHold(way2Auto.style3).perform();
        action.moveByOffset(160, 190).perform();

    }

    @Test
    public void selectableMethod() {
        way2Auto.selectableLink.click();
        way2Auto.defaultFunctionalityLink.click();

        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);

        way2Auto.itemsList.get(0).click();

        for (WebElement w : way2Auto.itemsList) {
            w.click();
            String backgroundColor = w.getCssValue("background-color");
            Assert.assertEquals(backgroundColor, "rgba(243, 152, 20, 1)");
            Assert.assertTrue(w.isEnabled());
//            System.out.println(backgroundColor);
        }

    }

    @Test
    public void displayGrid() {

        way2Auto.selectableLink.click();
        way2Auto.displayGridLink.click();

        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(2);

        for (WebElement w : way2Auto.displayGridList) {
            w.click();
            Assert.assertTrue(w.isEnabled());
        }
    }
    @Test
    public void serialiMethod() {

        way2Auto.selectableLink.click();
        way2Auto.serializeLink.click();


        Driver.getDriver().switchTo().frame(2);
        ReusableMethods.waitFor(2);

        for (int i=0; i<way2Auto.serializeList.size(); i++){
            way2Auto.serializeList.get(i).click();
//            System.out.println(way2Auto.itemText.getText());
            Assert.assertNotEquals(way2Auto.itemText.getText(),"You've selected: #"+i+".");
        }

    }

    @Test
    public void sortableMethode(){
        way2Auto.sortableLink.click();

        Driver.getDriver().switchTo().frame(0);

        for (WebElement w: way2Auto.fuctionalityList){
            action.clickAndHold(w).moveToElement(way2Auto.fuctionalityList.get(0)).release().perform();
            System.out.println(w.getText());

        }
        Assert.assertTrue(way2Auto.seventhItem.getLocation().y < way2Auto.firstItem.getLocation().y);

//        System.out.println(way2Auto.firstItem.getLocation().y); //253
//        System.out.println(way2Auto.seventhItem.getLocation().y); //8

    }

    @Test
    public void widgetsAccordionCustomizeIcons(){
        way2Auto.accordionButton.click();
        way2Auto.customizeIcon.click();

        Driver.getDriver().switchTo().frame(1);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();

        for (WebElement w: way2Auto.sectionList){
            ReusableMethods.waitFor(1);
            action.click(w).perform();

            Assert.assertTrue(w.isEnabled());
        }

    }

    @Test
    public void accordionFillSpace(){
        way2Auto.accordionButton.click();
        way2Auto.fillSpaceButton.click();

        Driver.getDriver().switchTo().frame(2);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(2);
        action.clickAndHold(way2Auto.indexPull).moveByOffset(320,0).build().perform();
        ReusableMethods.waitFor(2);
        for (WebElement w: way2Auto.fillSpaceSectionList){
            action.click(w).perform();
        }
//            action.clickAndHold(way2Auto.indexPull).moveByOffset(0,220).release().build().perform();
    }
    @Test
    public void datePickerAnimations(){
        way2Auto.datepickerButton.click();
        way2Auto.animationsButton.click();

        Driver.getDriver().switchTo().frame(1);
        way2Auto.dateBox.click();
        way2Auto.dateBox.sendKeys("03/21/2021"+Keys.ENTER);
        Assert.assertTrue(way2Auto.dateBox.isEnabled());

        for (WebElement w: way2Auto.animationsList){
            ReusableMethods.waitFor(1);
            w.click();
        }
        way2Auto.animationsList.get(5).click();
    }

    @Test
    public void datePickerDisplayMonthYear(){
        way2Auto.datepickerButton.click();
        way2Auto.displayMonthYearButton.click();

        Driver.getDriver().switchTo().frame(2);

//        way2Auto.monthYearSearchBox.sendKeys("01/21/1801"+Keys.ENTER);

        Select dropboxMonth = new Select(way2Auto.selectMonth);
        dropboxMonth.selectByIndex(0);

        Select dropboxYear = new Select(way2Auto.selectYear);
        dropboxYear.selectByValue("2024");

        way2Auto.january1.click();
    }

    @Test
    public void menuLink(){
        way2Auto.menuLink.click();
        way2Auto.menuWithSubMenu.click();

        Driver.getDriver().switchTo().frame(1);

        way2Auto.subMenuDelphi.click();

        int i =1;
        for (WebElement w: way2Auto.delphiMenuList){
            System.out.println(w.getText());
            Assert.assertEquals(w.getText(),"Sub Menu "+i);
            i++;
        }
    }
}

