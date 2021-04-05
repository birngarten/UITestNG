package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US07_SeleniumEasyPage {

    public US07_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(xpath = "//*[@id='advanced_example']/span/i")
    public WebElement advancedButton;

    @FindBy(xpath = "(//a[.='Table Filter '])[3]")
    public WebElement tableFilterLink;

    @FindBy(xpath = "//table[@class='table table-filter']//tr")
    public List<WebElement> panelContainerList;

    @FindBy(xpath = "//button[.='Orange']")
    public WebElement orangeButton;

    @FindBy(xpath = "//span[@class='pull-right pendiente']")
    public List<WebElement> orangeElementList;

    @FindBy(xpath = "//div[@id=\"advanced\"]/div/a[4]")
    public WebElement tableSortSearchLink;
// ==================================================
    @FindBy(xpath = "//select[@name='example_length']")
    public WebElement selectDropdown;

    @FindBy(xpath = "//tr[@role='row']/td[1]")
    public List<WebElement> roleNumbersList;

    @FindBy(id = "example_info")
    public WebElement selectInfotext;
//  ======================================================

    @FindBy(xpath = "//th[.='Salary']")
    public WebElement salaryHeadButton;

    @FindBy(xpath = "//tbody/tr/td[6]")
    public List<WebElement> salariesList;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;//tbody/tr

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> employeeInTokyo;

    @FindBy(xpath = "//tbody//td[4]")
    public List<WebElement> ageList;
}
