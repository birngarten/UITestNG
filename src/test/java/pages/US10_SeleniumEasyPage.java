package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US10_SeleniumEasyPage {

    public US10_SeleniumEasyPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(xpath = "//*[@id='advanced_example']/span/i")
    public WebElement advancedButton;

//    ================================
    @FindBy(xpath = "(//a[.='Drag & Drop Sliders'])[3]")
    public WebElement DragDropSlidersLink;

    @FindBy(xpath = "//input[@value='10']")
    public WebElement slider10;



}
