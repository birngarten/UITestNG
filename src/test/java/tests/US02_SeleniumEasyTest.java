package tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US02_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US02_SeleniumEasyTest {

    US02_SeleniumEasyPage easyPage02 = new US02_SeleniumEasyPage();
    Actions action = new Actions(Driver.getDriver());

    @BeforeMethod
    public void beforeMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage02.entryMessage.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void tc0201(){
        /*"The user clicks on "Start Practicing"
            The user clicks on "Select Dropdown List"        */
        easyPage02.startPractisingButton.click();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        easyPage02.selectDropdownListLink.click();

    }

    @Test
    public void tc0202(){
        /*Kullanici, Select List Demo basligi altindaki "Select a day (select one):" dropDown'dan tum
           gunleri secebildilgini dogrulamalidir. Son olarak 'Friday' secip  'Day selected :- Friday'
           yazisi goruldugu dogrulanmalidir.   */
        easyPage02.startPractisingButton.click();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        easyPage02.selectDropdownListLink.click();

        for (WebElement day: easyPage02.dayList){
            day.click();
            Assert.assertTrue(day.isSelected());
        }
        easyPage02.dayList.get(6).click();
        Assert.assertTrue(easyPage02.daySelectedFriday.isDisplayed());

    }

    @Test
    public void tc0203(){
        /*"Kullanici, Multi Select List Demo basligi altinda birden fazla eyalet sectiginde ve
        'First Selected' butonuna tikladiginda eyalet kutucugunun altinda bulunan "First selected option is :"
          yazisinin devaminda tikladigi ilk eyaletin isminin yazili oldugunu dogrulamalidir."   */

        easyPage02.startPractisingButton.click();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        easyPage02.selectDropdownListLink.click();
        for (int i=3; i<easyPage02.stateList.size()-2;i++){
            if(easyPage02.stateList.get(i).isDisplayed()){
                easyPage02.stateList.get(i).click();
                easyPage02.firstSelectedButton.click();
            }
        }
        Assert.assertEquals(easyPage02.firstClickedState.getText(),"First selected option is : Texas");
    }

    @Test
    public void tc0204() throws InterruptedException {
       /*"Kullanici, Multi Select List Demo basligi altinda tum eyaletleri sectikten sonra "Get All Selected"
          butonuna tikladiginda tum eyaletlerin 'Options selected are :' yazisinin devaminda secili oldugunu
          gormelidir."  */
        Thread.sleep(1000);
        easyPage02.startPractisingButton.click();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        easyPage02.selectDropdownListLink.click();
        Select select = new Select(easyPage02.selectState);


        for (WebElement allState: easyPage02.stateList){
            action.keyDown(Keys.CONTROL).click(allState).build().perform();
        }
        easyPage02.getAllSelectedButton.click();
    }
}
