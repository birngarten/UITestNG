package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US03_SeleniumEasyPage {

    public US03_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(id = "btn_basic_example")
    public WebElement startPractisingButton;

    @FindBy(xpath="(//a[.='Javascript Alerts'])[3]")
    public WebElement javascriptAlertsLink;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    public WebElement clickMeButton;

    @FindBy(xpath = "(//button[.='Click me!'])[2]")
    public WebElement confirmClickMeButton2;

    @FindBy(xpath = "//p[@id='confirm-demo']")
    public WebElement cancelMessage;

    @FindBy(xpath = "//button[.='Click for Prompt Box']")
    public WebElement clickforPromptBoxButton;

    @FindBy(xpath = "//p[@id='prompt-demo']")
    public WebElement nameMessage;


}
