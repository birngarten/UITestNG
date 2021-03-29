package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US06_SeleniumEasyPage {

    public US06_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(id = "btn_basic_example")
    public WebElement startPractisingButton;
    @FindBy(xpath = "//*[@id='advanced_example']/span/i")
    public WebElement advancedButton;

    @FindBy(xpath = "//div[@id='advanced']/div/a[1]")
    public WebElement tablePaginationLink;

    @FindBy(xpath = "//ul[@id='myPager']/li/a")
    public List<WebElement> pagesNumbersList;

    @FindBy(xpath = "//a[@style='display: block;']")
    public List<WebElement> disPlaylinkList;

    @FindBy(xpath = "//td[.='Table cell']")
    public List<WebElement> cellList;
//    =========================
    @FindBy(xpath = "(//a[.='Table Data Search'])[3]")
    public WebElement tableDataSearchLink;

    @FindBy(xpath = "//table[@id=\"task-table\"]/thead")
    public WebElement taskHeadersList;

    @FindBy(xpath = "//input[@placeholder='Filter by Task / Assignee / Status ']")
    public WebElement placeholderTextArea;

    @FindBy(xpath = "(//tbody)[1]")
    public List<WebElement> mikeBodyText;



//    =======================
    @FindBy(xpath = "//tr[@class='filters']//input[@type='text']")
    public List<WebElement> inactiveInputList;

    @FindBy(xpath = "(//button)[2]")
    public WebElement makeActiveButton;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement firstNameBox;

    @FindBy(xpath = "(//div/table/tbody)[2]")
    public WebElement secondInputWith_m;
}
