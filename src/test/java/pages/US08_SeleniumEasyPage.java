package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US08_SeleniumEasyPage {

    public US08_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(xpath = "//*[@id='advanced_example']/span/i")
    public WebElement advancedButton;

//    ================================

    @FindBy(xpath = "//div[@class='list-group']/a[.='Table Data Download']")
    public WebElement tableDataDownloadLink;

    @FindBy(xpath = "//label[.='Search:']/input")
    public WebElement inputSearchBox;

    @FindBy(xpath = "//tbody//tr/td[3]")
    public List<WebElement> citiesOfOffice;

//    ======================================
    @FindBy(xpath = "//span[.='PDF']")
    public WebElement pdfClick;


}
