package studies.day_15;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01 extends TestBase {

    ExtentReports extentReports; // --> Raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter;// -->Raporu HTML formatinda duzenler
    ExtentTest extentTest;// --> Test adimlarina eklemek istedigimiz bilgileri bu class ile olustururuz.

    @Test
    public void test01() throws IOException {

        extentReports = new ExtentReports();
        String dosyaYolu1 = "testOutput/extentReports/extentReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu1);
        extentReports.attachReporter(extentHtmlReporter); // html formatinda raporlamayi baslaticak.

        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Omer");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        wait(1);
        extentTest.info("Istenilen sayfaya gidildi....");

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız ekran goruntusunu aliniz.

        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        extentTest.info("iframe islemi yapildi....");

        WebElement d1 = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        Actions action = new Actions(driver);
        action.clickAndHold(d1).
                moveByOffset(140, 0).release().perform();
        wait(1);

        WebElement yellowSliderBar = driver.findElement(By.xpath("//*[@id='green']"));
        action.clickAndHold(yellowSliderBar).
                moveByOffset(-140, 0).release().perform();
        wait(1);

        WebElement d3 = driver.findElement(By.xpath("//*[@id='blue']"));
        action.clickAndHold(d3).
                moveByOffset(-160, 0).release().perform();
        wait(2);

        extentTest.info("kirmizi kutu islemi yapildi");

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/screenshot" + date + ".png"));

        extentTest.info("kirmizi kutu ekran goruntusu alindi");


        //        -Sarı olduğunu test edelim
        WebElement yellowSliderBar1 = driver.findElement(By.xpath("//*[@id='green']"));
        action.clickAndHold(yellowSliderBar1).moveByOffset(250, 0).release().perform();

        extentTest.info("sari kutu islmei yapildi...");

        //src/test/java/studies/ScreenShot1
       // String dosyaYolu= "src/test/java/studies/ScreenShot1";
        String dosyaYolu = "src/test/java/studies/ScreenShot1/WEscreenShot" + date + ".jpeg";
        TakesScreenshot ts1 = (TakesScreenshot) driver;
        FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        extentTest.info("sari kutu ekran goruntusu alindi...");

        extentReports.flush(); //bu methodu kullanmazsak raporumuz olusmaz
    }
}
