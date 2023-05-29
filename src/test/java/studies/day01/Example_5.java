package studies.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class Example_5 {
    public static void main(String[] args) throws InterruptedException {
        /*
        2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        4.https://www.walmart.com/ sayfasina gidin.
        5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        6. Tekrar “facebook” sayfasina donun
        7. Sayfayi yenileyin
        8.Sayfayi tam sayfa (maximize) yapin
        9.9.Browser’i kapatin
         */

        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.facebook.com/");
        String actualTitle = driver.getTitle();
        String expedtedTitle = "facebook";
        if (actualTitle.contains(expedtedTitle)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED: " + actualTitle);
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "facebook";
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED" + actualUrl);
        }
        Thread.sleep(3000);

        driver.get("https://www.walmart.com/");

        String actualTitle1=driver.getTitle();
        String expectedTitle1="Walmart.com";
        if (actualTitle1.contains(expectedTitle1)) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED" + actualTitle1);
        }
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.close();

    }
}
