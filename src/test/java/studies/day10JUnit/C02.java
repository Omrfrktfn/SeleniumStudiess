package studies.day10JUnit;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    // https://www.google.com/ adresine gidin
    // sayfa baslıgının "Google" kelimesini icerdigini test edin
    // arama cubuguna "Nutella" yazıp aratın
    // bulunan sonuc sayısını yazdırın
    // sonuc sayısının 100000000  fazla oldugunu test edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        // driver.close();
    }

    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Google"));

        // arama cubuguna "Nutella" yazıp aratın
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();

        // bulunan sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));

        String sonucSayisi [] = sonucYazisi.getText().split(" ");
        System.out.println(sonucSayisi[1]);

        // sonuc sayısının 100000000  fazla oldugunu test edin


    }
}
