package studies.day_15;

import Utilities.TestBase;
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

    @Test
    public void test01() throws IOException {

        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        wait(1);

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız ekran goruntusunu aliniz.

        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

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

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/screenshot" + date + ".png"));


        //        -Sarı olduğunu test edelim
        WebElement yellowSliderBar1 = driver.findElement(By.xpath("//*[@id='green']"));
        action.clickAndHold(yellowSliderBar1).moveByOffset(250, 0).release().perform();

        //src/test/java/studies/ScreenShot1
       // String dosyaYolu= "src/test/java/studies/ScreenShot1";
        String dosyaYolu = "src/test/java/studies/ScreenShot1/WEscreenShot" + date + ".jpeg";
        TakesScreenshot ts1 = (TakesScreenshot) driver;
        FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
