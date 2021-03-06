package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US11_SeleniumEasyPage {

    public US11_SeleniumEasyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='No, thanks!']")
    public WebElement entryMessage;
    @FindBy(xpath = "//*[@id='advanced_example']/span/i")
    public WebElement advancedButton;

//    ================================

    @FindBy(xpath = "(//a[.='Drag and Drop'])[3]")
    public WebElement Drag_and_DropLink;

    @FindBy(xpath = "//span[@draggable='true']")
    public List<WebElement> draggableItemsList;

    @FindBy(id = "mydropzone")
    public WebElement dropZone;

}
