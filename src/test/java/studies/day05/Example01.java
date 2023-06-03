package studies.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Example01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        //  4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actual = driver.getTitle();
        String expected = "Googlee";
        if (actual.equals(expected)) {
            System.out.println("Test PASS");
        } else {
            System.out.println("Test FAIL : " + actual);
        }

        //    5. Arama cubuguna “Nutella” yazip aratin
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();

        //  6. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonucSayisi[] = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = " + sonucSayisi[1]);

        //7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String deger = "10.000.000";



        //8. Sayfayi kapatin
    }
}
