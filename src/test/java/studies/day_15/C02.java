package studies.day_15;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02 extends TestBase {

    ExtentReports extentReports; // --> Raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter;// -->Raporu HTML formatinda duzenler
    ExtentTest extentTest;// --> Test adimlarina eklemek istedigimiz bilgileri bu class ile olustururuz.


    @Test
    public void test01() throws IOException {

        extentReports = new ExtentReports();
        String date1 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // tarihle ilgili yeni bir format
        String dosyaYolu1 = "testOutput/extentReports/extentReport" + date1 + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu1);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatinda raporlamayi baslatacak.

        //Rapor da gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Omer");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        wait(1);
        extentTest.info("sayfaya gidildi.");

        // 3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        extentTest.info("sayfaya gidildigi kontorl edildi.");

        // 4. Click on 'Products' button and a take a screenshot.
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        wait(3);

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // tarihle ilgili yeni bir format

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/screenShot" + date + ".png"));

        extentTest.info("ekran goruntusu alindi");

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement logo1 = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(logo1.isDisplayed());


        // 6. Enter product name in search input and click search button and take a screenshot
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='form-control input-lg']"));
        searchBox.sendKeys("Men Tshirt");
        wait(1);

        String dosyaYolu = "src/test/java/studies/ScreenShot1/WEscreenShot" + date + ".png";
        Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));

        WebElement searchBox1 = driver.findElement(By.xpath("//*[@class='btn btn-default btn-lg']"));
        searchBox1.click();
        wait(1);

        extentTest.info("ekran goruntusu alindi");

        // 7. Verify 'SEARCHED PRODUCTS' is visible


        // 8. Verify all the products related to search are visible

        extentReports.flush(); // bu methodu kullanmazsak raporumuz olusmaz
    }
}
