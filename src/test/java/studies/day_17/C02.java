package studies.day_17;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02 extends TestBase {
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;
    @Test
    public void test01() throws IOException {
        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("_hh_mm_ss").format(new Date());
        String dosyaYolu = "src/test/java/extentReports"+date+ ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//html formatinda raporlamayi gosterir

        //Raporda gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Emin");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("Extent Test", "Test Raporu");


//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("sayfaya gidildi");


//        3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("(//*[@class='col-sm-4'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        extentTest.info("home page visible oldugu test edildi");


        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("TamSayfaEkran/EkranGoruntu"+date+".png"));


//        4. Click on 'Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        extentTest.info("login butonuna tiklandi");

//        5. Verify 'Login to your account' is visible
        WebElement login = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(login.isDisplayed());
        FileUtils.copyFile(login.getScreenshotAs(OutputType.FILE), new File("WebElement/WEGoruntu"+date+ ".png"));

        extentTest.info("login gorunur oldugu test edildi");

//        6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("(//*[@type=\"email\"])[1]"));
        Actions actions = new Actions(driver);

        FileInputStream fis = new FileInputStream("src/test/java/excell/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        String email2 = workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();
        //String parola = workbook.getSheet("Sheet1").getRow(1).getCell(2).toString();

//        7. Click 'login' button
        actions.click(email).sendKeys(email2).sendKeys(Keys.TAB).
                sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //Excelden aldigimizda hata verdigi icin parolayi manuel olarak girdik

        extentTest.info("gerekli bilgiler girildi");




//        8. Verify that 'Logged in as username' is visible
        WebElement loggedInUsername = driver.findElement(By.xpath("(//li)[10]"));
        Assert.assertTrue(loggedInUsername.isDisplayed());
        extentTest.info("login yapildigi test edildi");
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();//bunu yazmazsak rapor olusmaz
    }
}
