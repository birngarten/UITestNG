package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US05_SeleniumEasyPage {
    public US05_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(id = "btn_basic_example")
    public WebElement startPractisingButton;
    @FindBy(xpath = "//*[@id='inter_example']/span")
    public WebElement intermediateButton;


    @FindBy(id = "btn_inter_example")
    public WebElement proceedNextButton;

    @FindBy(xpath = "(//a[.='JQuery List Box'])[3]")
    public WebElement jQueryListBoxLink;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickData']")
    public WebElement selectOptionsFromPanel;
    @FindBy(xpath = "//button[.='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickData']/option")
    public List<WebElement> leftPanelOptionsList;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickListResult']/option")
    public List<WebElement> rigthPanelOptionsList;

    @FindBy(xpath = "(//a[.='Data List Filter'])[3]")
    public WebElement dataListFilterLink;

    @FindBy(xpath = "//span[contains(text(),'Email: test')]")
    public List<WebElement> namesInfoList;

    @FindBy(id = "input-search")
    public WebElement searchAttendeesBox;

    @FindBy(xpath = "//section[@class='content']")
    public WebElement contentAllInfo;
    @FindBy(xpath = "//section[@class='content']")
    public WebElement contentInfo;

    @FindBy(xpath = "(//a[.='File Download'])[3]")
    public WebElement fileDownLink;

    @FindBy(id = "textbox")
    public WebElement textAreaBox;

    @FindBy(id = "textarea_feedback")
    public WebElement feedbackChracters;

    @FindBy(xpath = "//button[@id='create']")
    public WebElement generateFileButton;

    @FindBy(id = "link-to-download")
    public WebElement downloadButtonLink;



}
