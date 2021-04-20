package tests;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US08_SeleniumEasyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.print.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

public class US08_SeleniumEasyTest {

    US08_SeleniumEasyPage easyPage08 = new US08_SeleniumEasyPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeMethode(){
        Driver.getDriver().get(ConfigReader.getProperty("seleniumEasyUrl"));
        easyPage08.entryMessage.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);

    }

    @Test
    public void TC0801(){
        /*   Kullanici, Advanced ==> "Table Data Download" linkine tiklar ve
             2012 yilinda 4 farkli sehirde goreve baslandigini dogrular
         */
        easyPage08.advancedButton.click();
        easyPage08.tableDataDownloadLink.click();

        easyPage08.inputSearchBox.sendKeys("2012");

        Set<String> citiesList = new LinkedHashSet<>();
        for (WebElement w: easyPage08.citiesOfOffice){
            citiesList.add(w.getText());
        }
        System.out.println(citiesList); // [London, New York, Edinburgh, San Francisco]
        Assert.assertTrue(citiesList.size() ==4 );
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC0802() throws IOException {
        /* Kullanici, Advanced ==> "Table Data Download" linkine tiklar ve 'London' da calisanlarin
           bilgilerini PDF olarak download ettigini dogrular. !!!Ayrica PDF'in ciktisini (print) alir!!!
         */
        easyPage08.advancedButton.click();
        easyPage08.tableDataDownloadLink.click();

        ReusableMethods.waitFor(1);
        easyPage08.inputSearchBox.sendKeys("London");
        easyPage08.pdfClick.click();

        String pdfURL = "C:/Users/Administrator/Downloads/Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
        boolean isPDFDownload = Files.exists(Paths.get(pdfURL));
        Assert.assertTrue(isPDFDownload);

    }
    // Print
    @Test
    public void filePrinter() throws FileNotFoundException {
        String filePath = "C:/Users/Administrator/Downloads/Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
        FileInputStream in = new FileInputStream(filePath);
        Doc doc = new SimpleDoc(in, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();

        try {
            service.createPrintJob().print(doc, null);
        } catch (PrintException e) {
            e.printStackTrace();
        }

    }

    // Text reader
    @Test
    public void pdfReader() {
        String filePath =  "C:/Users/Administrator/Downloads/Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf";
        String page = "";

        try {

            PdfReader reader = new PdfReader(filePath);
            System.out.println("This PDF has " + reader.getNumberOfPages() + " pages.");
            page = PdfTextExtractor.getTextFromPage(reader, 1);
            System.out.println("Page Content:\n\n" + page + "\n\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(page.contains("London"));

    }
}
