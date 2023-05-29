package studies.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example_1 {
    public static void main(String[] args) {
        /*
        3. Amazon sayfasina gidelim. https://www.amazon.com/
        4. Sayfa basligini(title) yazdirin
        5. Sayfa basliginin “Amazon” icerdigini test edin
        6. Sayfa adresini(url) yazdirin
        7. Sayfa url’inin “amazon” icerdigini test edin.
        8. Sayfa handle degerini yazdirin
        9. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        10.Sayfayi kapatin.
         */

        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com/");

        System.out.println("amazon title: " +driver.getTitle());

        String actualTitle =driver.getTitle();
        String expectedTitle = "Amazon";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED" + actualTitle);
        }

        System.out.println("amazon url: "+driver.getCurrentUrl());

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="amazon";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED"+actualUrl);
        }

        System.out.println(driver.getWindowHandle());

       String sourceCode= driver.getPageSource();//sayfanin butun kaynak kodlarini alir.
       if (sourceCode.contains("Gateway")){
           System.out.println("Test PASSED");
          // System.out.println(sourceCode);
       }else
           System.out.println("Test FAILED"+sourceCode);

    }
}
