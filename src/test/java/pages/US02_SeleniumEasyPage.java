package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US02_SeleniumEasyPage {
    public US02_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(id = "btn_basic_example")
    public WebElement startPractisingButton;

    @FindBy(xpath = "(//a[.='Select Dropdown List'])[3]")
    public WebElement selectDropdownListLink;

    @FindBy(xpath = "//select[@id=\"select-demo\"]/option")
    public List<WebElement> dayList;

    @FindBy(xpath = "//p[.='Day selected :- Friday']")
    public WebElement daySelectedFriday;

    @FindBy(xpath = "//select[@size='10']/option")
    public List<WebElement> stateList;

    @FindBy(xpath = "//select[@size='10']")
    public WebElement selectState;

    @FindBy(xpath = "//button[@id='printMe']")
    public WebElement firstSelectedButton;

    @FindBy(xpath = "//button[@id='printAll']")
    public WebElement getAllSelectedButton;

    @FindBy(xpath = "//p[@class='getall-selected']")
    public WebElement firstClickedState;


}
