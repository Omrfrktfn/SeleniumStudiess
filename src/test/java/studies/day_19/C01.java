package studies.day_19;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class C01 extends TestBase {

    //https://www.selenium.dev/downloads/ adresine gidelim
//Sayfanın resmini alalım
//Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
//Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
//Documentation webelementinin resmini alalım
//All versions available in Downloads altında Latest stable release olan linki tıklayalım
//Açılan pencerede chromedriver'i indirelim
//Driver'in indiğini doğrulayalım
//İndirmiş olduğumuz dosyayı silelim
//Silindiğini doğrulayalım
//Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)


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

        driver.get("https://www.selenium.dev/downloads/");
        wait(1);
        extentTest.info("Belirtilen sayfaya gidildi...");

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // tarihle ilgili yeni bir format
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/screenshot" + date + ".png"));
        wait(1);
        extentTest.info("Tam sayfa ekran goruntusu alindi...");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,
                Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        wait(1);
        extentTest.info("Belirtilen lokasyon uzerine gelindi ...");

        driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]")).click();
        wait(1);
        extentTest.info("Belirtilen lokasyona tiklanildi...");


        WebElement documantationLink = driver.findElement(By.xpath("(//*[text()='documentation'])[5]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", documantationLink);
        wait(1);
        extentTest.info("Belirtilen lokasyon icindeki elemente tiklanildi...");

        WebElement documentation = driver.findElement(By.xpath("//*[text()='ChromeDriver Documentation']"));
        String path = "src/test/java/studies/ScreenShot1" + date + ".png";
        FileUtils.copyFile(documentation.getScreenshotAs(OutputType.FILE), new File(path));
        wait(1);
        extentTest.info("Berlirli bir alanin ekran goruntusu alindi...");

        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[5]")).click();
        wait(1);
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("sayfa1Handel degeri " + sayfa1Handle);
        extentTest.info("sayfa 1 handle degeri alindi...");
        driver.findElement(By.xpath("(//*[@class='C9DxTc aw5Odc '])[5]")).click();
        wait(2);
        extentTest.info("indirme butonu kismina tiklandi...");

        Set<String> windows = driver.getWindowHandles();
        for (String w : windows) {
          //  System.out.println(w);
            if (!w.equals(sayfa1Handle)) {
                driver.switchTo().window(w);
            }
        }

        String sayfa2Handle = driver.getWindowHandle();
        System.out.println("sayfa2Handel degeri: " + sayfa2Handle);
        extentTest.info("sayfa 2 handle degeri alindi...");

        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
         wait(5);



        extentReports.flush(); // bu methodu kullanmazsak raporumuz olusmaz


    }
}

