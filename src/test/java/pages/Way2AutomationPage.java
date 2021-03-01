package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Way2AutomationPage {

    public Way2AutomationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='#login']")
    public WebElement signin;

    @FindBy(xpath = "(//input[@name='username'])[2]")
    public WebElement userName;

    @FindBy(xpath = "(//input[@name='password'])[2]")
    public WebElement password;

    @FindBy(xpath = "(//input[@value='Submit'])[2]")
    public WebElement submitButton;

    @FindBy(xpath = "//h2[.='Draggable']")
    public WebElement draggableLink;

    @FindBy(xpath = "(//html/body/div[@id='draggable'])[1]")   //"//p[.='Drag me around']")
    public WebElement dragMeArround;

    @FindBy(xpath = "//a[@href='#example-1-tab-3']")
    public WebElement courserStyle;

    @FindBy(xpath = "//p[text()='I will always stick to the center (relative to the mouse)']")
    public WebElement style1;

    @FindBy(xpath = "//p[.='My cursor is at left -5 and top -5']")
    public WebElement style2;

    @FindBy(xpath = "//p[.='My cursor position is only controlled for the 'bottom' value']")
    public WebElement style3;

    @FindBy(xpath = "//h2[.='Selectable']")
    public WebElement selectableLink;

    @FindBy(xpath = "(//a[@target='_self'])[1]")
    public WebElement defaultFunctionalityLink;

    @FindBy(xpath = "Item 1")
    public  WebElement item1;

    @FindBy(xpath = "//li[contains(text(),'Item ')]")
    public List<WebElement> itemsList;

    @FindBy(xpath ="//a[.='Display as grid']")
    public WebElement displayGridLink;

    @FindBy(xpath = "//ol[@id=\"selectable\"]/li")
    public List<WebElement> displayGridList;

    @FindBy(xpath = "//a[.='Serialize']")
    public WebElement serializeLink;

    @FindBy(xpath = "//li[contains(text(),'Item ')]")
    public List<WebElement> serializeList;

    @FindBy(xpath = "//p")
    public WebElement itemText;

    @FindBy(xpath = "//h2[.='Sortable']")
    public WebElement sortableLink;

    @FindBy(xpath ="//span[contains(text(),Item )]")
    public List<WebElement> fuctionalityList;

    @FindBy(xpath = "//li[.='Item 1']")
    public WebElement firstItem;

    @FindBy(xpath = "//li[.='Item 7']")
    public WebElement seventhItem;

    @FindBy(xpath = "//h2[.='Accordion']")
    public WebElement accordionButton;

    @FindBy(xpath ="//a[.='Customize icons']")
    public WebElement customizeIcon;

    @FindBy(xpath = "//h3")
    public  List<WebElement> sectionList;

    @FindBy(xpath = "//p")
    public  List<WebElement> sectionsTextList;

    @FindBy(xpath = "//a[.='Fill Space']")
    public WebElement fillSpaceButton;

    @FindBy(xpath = "(//div[@style='z-index: 90;'])[3]")
    public WebElement indexPull;

    @FindBy(xpath = "//h3")
    public  List<WebElement> fillSpaceSectionList;

    @FindBy(xpath ="//h2[.='Datepicker']")
    public WebElement datepickerButton;

    @FindBy(xpath = "//a[.='Animations']")
    public WebElement animationsButton;

    @FindBy(xpath = "//input[@size='30']")
    public WebElement dateBox;

    @FindBy(xpath = "//option")
    public  List<WebElement> animationsList;

    @FindBy(xpath = "//a[.='Display month & year']")
    public WebElement displayMonthYearButton;

    @FindBy(xpath = "//input[@id='datepicker']")
    public WebElement monthYearSearchBox;

    @FindBy(xpath = "//select[@data-handler='selectMonth']")
    public WebElement selectMonth;//select[@data-handler='selectYear']

    @FindBy(xpath = "//select[@data-handler='selectYear']")
    public WebElement selectYear;//option[.='2024']

    @FindBy(xpath = "//a[.='1']")
    public WebElement january1;

    @FindBy(xpath = "//h2[.='Menu']")
    public WebElement menuLink;

    @FindBy(xpath = "//a[.='Menu With Sub Menu']")
    public WebElement menuWithSubMenu;

    @FindBy(xpath = "(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[2]")
    public WebElement subMenuDelphi;//li[.='Adamsville']

    @FindBy(xpath = "//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")
    public WebElement subMenuAdamsville;

    @FindBy(xpath = "//li[contains(text(),'Sub Menu')]")
    public List<WebElement> delphiMenuList;




}
