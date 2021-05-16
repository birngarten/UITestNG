package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US12_DynamicDataLoadingPage {
    public US12_DynamicDataLoadingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(xpath = "//*[@id='advanced_example']/span/i")
    public WebElement advancedButton;

//    ================================
    @FindBy(xpath ="(//a[.='Dynamic Data Loading'])[3]")
    public WebElement dynamicDataLoadingLink;

    @FindBy(xpath = "//button[@id='save']")
    public WebElement newUserButton;

    @FindBy(xpath = "(//img)[3]")
    public WebElement newUserFoto;

//    ===============================================
    @FindBy(xpath = "//*[contains(text(),'First Name')]")
    public WebElement firstNameText;

    @FindBy(xpath = "//div[@id='loading']/text()[2]")
    public WebElement lastNameText;

    @FindBy(xpath = "//*[@id='loading']")
    public List<WebElement> nameList;




}
