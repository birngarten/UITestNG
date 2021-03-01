package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US01_SeleniumEasyPage {

    public US01_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(id = "btn_basic_example")
    public WebElement startPractisingButton;

    @FindBy(xpath="(//a[.='Simple Form Demo'])[3]")
    public WebElement simpleFormDemoLink;

    @FindBy(xpath = "//input[@id='user-message']")
    public WebElement userMessageBox;
    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement showMessageButton;
    @FindBy(xpath = "//span[.='Hello']")
    public WebElement seeHelloMessage;

    @FindBy(id ="sum1")
    public WebElement enterA_Box;
    @FindBy(id ="sum2")
    public WebElement enterB_Box;
    @FindBy(xpath = "//button[.='Get Total']")
    public WebElement getTotalButton;
    @FindBy(xpath = "//span[.='NaN']")
    public WebElement getTotalNegativeMessage;//span[.='5']
    @FindBy(xpath = "//span[.='5']")
    public WebElement getTotalPositiveMessage;
}
