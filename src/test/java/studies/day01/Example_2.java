package studies.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example_2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Yeni bir Class olusturalim.C05_NavigationMethods
        2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        3. Amazon soyfasina gidelim. https://www.amazon.com/
        4. Tekrar YouTube’sayfasina donelim
        5. Yeniden Amazon sayfasina gidelim
        6. Sayfayi Refresh(yenile) yapalim
        7. Sayfayi kapatalim / Tum sayfalari kapatalim
         */
        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.youtube.com/");
        Thread.sleep(3000);

        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();

        driver.close();

    }
}
