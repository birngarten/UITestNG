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
}
