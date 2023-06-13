package studies.day11_IFrame;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02 extends TestBase {
    /*
    1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
    2) sayfadaki toplam iframe sayısını bulunuz.
    3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
    4) Paragrafdaki yaziyi silelim
    5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
    6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
     */
    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        wait(2);

        WebElement baslik = driver.findElement(By.xpath("//h3"));
        String expected = "Editor";
        Assert.assertTrue(baslik.getText().contains(expected));

        WebElement iFrame = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        wait(2);
        driver.findElement(By.xpath("//p")).clear();
        //  iFrame.clear();

        wait(2);
        driver.findElement(By.xpath("//p")).sendKeys("Iframe icindeyim");

        driver.switchTo().defaultContent();

        WebElement sonYazi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(sonYazi.isDisplayed());


    }
}
