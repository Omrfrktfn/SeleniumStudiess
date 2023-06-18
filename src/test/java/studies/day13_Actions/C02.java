package studies.day13_Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02 extends TestBase {

    @Test
    public void test01() {

        // 2.https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        wait(1);

        // 3.video’yu gorecek kadar asagi inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        wait(1);

        // 4.videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[1]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        wait(3);
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();

        // 5.videoyu calistirdiginizi test edin
        WebElement simge = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(simge.isDisplayed());

    }
}
