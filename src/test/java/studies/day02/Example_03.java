package studies.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example_03 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //iphone aratınız
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        Thread.sleep(2000);
        searchBox.submit();

        //çıkan sonuç yazısını konsola yazdırınız


        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
        /*
        Thread.sleep(2000);
        for (int i = 1; i <= 5; i++) {
            String locator = String.format(".s-result-item:nth-child(%d) h2 a", i);
            WebElement result = driver.findElement(By.cssSelector(locator));
            result.click();

            // Sayfa başlığını alın ve yazdırın
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle);

            // Önceki sayfaya geri dönün
            driver.navigate().back();
        }

         */

        // Tarayıcıyı kapatın
      //  driver.quit();

    }
}
