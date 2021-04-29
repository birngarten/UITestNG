package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US09_SeleniumEasyPage {

   public US09_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(xpath = "//*[@id='advanced_example']/span/i")
    public WebElement advancedButton;

//    ================================

    @FindBy(xpath = "(//a[.='JQuery Download Progress bars'])[3]")
    public WebElement JQueryDownloadProgressbarsLink;

    @FindBy(id = "downloadButton")
    public WebElement downloadButton;

    @FindBy(xpath = "//div[@aria-valuenow='10']")
    public WebElement downloadStarted;

    @FindBy(xpath = "//div[@style='width: 102%; display: block;']")
    public WebElement styleCSS;
    @FindBy(xpath = "//div[@style='width: 25%; display: block;']]")
    public WebElement style25;

    @FindBy(xpath = "//div[.='Complete!']")
    public WebElement completeDownloadText;

    //=======================================================

   @FindBy(xpath = "//a[.='Bootstrap Download Progress bar']")
   public WebElement BootstrapDownloadProgressLink;

   @FindBy(id = "cricle-btn")
   public WebElement cricleButton;

    @FindBy(xpath = "//div[.='65%']")
    public WebElement percent65;

   @FindBy(xpath = "//div[.='100%']")
    public WebElement percent100;

}
