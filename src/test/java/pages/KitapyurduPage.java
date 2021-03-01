package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KitapyurduPage {
    public KitapyurduPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//span[@class='RveJvd snByac'])[3]")
    public WebElement ichStimmeZu;

    @FindBy(xpath="//input[@name='q']")
    public WebElement searchBox;

    @FindBy(xpath="//a[@href='https://www.kitapyurdu.com/']") // ==>  //a[@href='https://www.kitapyurdu.com/']
    public WebElement kitapYurduLink;

    @FindBy(xpath="//div[@class='heading']")
    public WebElement alisverisSepeti;

    @FindBy(xpath="//div[@class='empty']")
    public WebElement alisverisSepetiBos;

    @FindBy(xpath="//li[@class='bestseller-item']")
    public List<WebElement> enCokSatanlarList;

    @FindBy(id="search-input")
    public WebElement kitapYurduSearchBox;

    @FindBy(xpath="//span[text()='Suç ve Ceza 1']")
    public WebElement sucVeCeza1;

    @FindBy(xpath="//div[@class='price__item']")
    public WebElement priceItem;

    @FindBy(xpath="//span[text()='Suç ve Ceza 2']")
    public WebElement sucVeCeza2;

    @FindBy(xpath="//a[@id='button-cart']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//td[@class='name']")
    public List<WebElement> sepettekiKitaplar;

}
