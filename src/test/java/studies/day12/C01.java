package studies.day12;

import Utilities.TestBase;
import com.google.j2objc.annotations.Weak;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C01 extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// ikinci emojiye tıklayın
// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz


    @Test
    public void test01() {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        wait(1);

        WebElement iframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();


        String emoji = driver.findElement(By.xpath("//div[@class='mdl-tabs__panel is-active']")).getText();
        System.out.println(emoji);

        driver.switchTo().defaultContent();
        wait(1);

        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Merhaba", Keys.TAB, "omer", Keys.TAB, "faruk"
                , Keys.TAB, "Tufan", Keys.TAB, "Makarna");

        wait(1);
        driver.findElement(By.xpath("//*[@id='send']")).click();

    }
}
