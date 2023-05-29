package studies.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example_6 {
    public static void main(String[] args) throws InterruptedException {
        /*
        . Yeni bir class olusturun (TekrarTesti)
        2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        5. Youtube sayfasina geri donun
        6. Sayfayi yenileyin
        7. Amazon sayfasina donun
        8. Sayfayi tamsayfa yapin
        9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru
        başlığı(Actual Title) yazdırın.
        10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        URL'yi yazdırın
        11.Sayfayi kapatin

         */
        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.youtube.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED: " + actualTitle);
        }

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="youtube";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED"+actualUrl);
        }
        Thread.sleep(3000);

        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.manage().window().maximize();

        String actulTitle1=driver.getTitle();
        String expectedTitle1="Amazon";
        if (actulTitle1.contains(expectedTitle1)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED"+actulTitle1);
        }

        String actualUrl1 = driver.getCurrentUrl();
        String expectedUrl1= "https://www.amazon.com/";
        if (actualUrl1.contains(expectedUrl1)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED" + actualUrl1);
        }

        Thread.sleep(2000);

        driver.close();

    }
}
