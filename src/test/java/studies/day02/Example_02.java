package studies.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Example_02 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Bir class oluşturun : AmazonSearchTest
        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
            a.web sayfasına gidin. https://www.amazon.com/
            b. Search(ara) “city bike”
            c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
            d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
         */
        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Amazon web sayfasına gitme
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        // Arama kutusunu bulma ve "city bike" terimini girme
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("city bike");
        searchBox.submit();

        // İlgili sonuçların sayısını bulma ve yazdırma
        List<WebElement> linkler = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayisi: " + linkler.size());

        // İlk sonucun resmine tıklama
        Thread.sleep(2000);
        driver.navigate().to("https://www.amazon.com/Schwinn-Loop-Folding-Bike-White/dp/B01H7F0RN0/ref=sr_1_1_" +
                "sspa?keywords=city+bike&qid=1685451036&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUExS09aTTkx" +
                "V1BMMkxWJmVuY3J5cHRlZElkPUEwMzM2MTcwM05MMENaNU1HUTA5WCZlbmNyeXB0ZWRBZElkPUExMDA2ODE2SFpHUkFCTFEwNVI2" +
                "JndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==");

        // Tarayıcıyı kapatma
        Thread.sleep(2000);
        driver.quit();
    }
}
