package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US04_SeleniumEasyPage {
    public US04_SeleniumEasyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(id = "btn_basic_example")
    public WebElement startPractisingButton;

    @FindBy(id = "btn_inter_example")
    public WebElement proceedNextButton;

    @FindBy(xpath = "(//a[.='Ajax Form Submit'])[3]")
    public WebElement ajaxFormSubmitLink;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement ajaxFormNameBox;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement ajaxFormCommentBox;

    @FindBy(id = "btn-submit")
    public WebElement ajaxSubmitButton;
    @FindBy(xpath = "//div[.='Form submited Successfully!']")
    public WebElement formSubmittedSuccessfulyMessage;

    @FindBy(xpath = "(//a[.='JQuery Select dropdown'])[3]")
    public WebElement jQuerySelectDropdownLink;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement selectCountryDropDown;

    @FindBy(xpath = "(//select[@tabindex='-1'])[2]")
    public WebElement stateSelectBox;

    @FindBy(xpath = "(//select[@style='width:50%;'])[2]")
    public WebElement selectVirginIslands;

    @FindBy(xpath = "(//select[@style='width:50%;'])[3]")
    public WebElement selectFile;

    @FindBy(xpath = "(//a[.='Bootstrap List Box'])[3]")
    public WebElement bootstrapListBoxLink;

    @FindBy(xpath = "//div[@class='dual-list list-left col-md-5']//li")
    public List<WebElement> leftItemsList;

    @FindBy(xpath = "//div[@class='dual-list list-right col-md-5']//li")
    public List<WebElement> rightItemsList;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-right']")
    public WebElement leftToRightButton;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-left']")
    public WebElement rightToLeftButton;

    @FindBy(xpath = "//li[.='bootstrap-duallist ']")
    public WebElement bootstrapDuallistItem;
    @FindBy(xpath = "//li[.='Cras justo odio']")
    public WebElement crasJustoOdioItem;

    @FindBy(xpath = "(//ul[@class='list-group'])[1]")
    public WebElement allLeftItems;

    @FindBy(xpath = "(//ul[@class='list-group'])[2]")
    public WebElement allRightItems;
}