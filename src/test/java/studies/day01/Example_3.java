package studies.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Example_3 {
    public static void main(String[] args) throws InterruptedException {
        /*
        2. Amazon soyfasina gidelim. https://www.amazon.com/
        3. Sayfanin konumunu ve boyutlarini yazdirin
        4. Sayfayi simge durumuna getirin
        5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        7. Sayfayi fullscreen yapin
        8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        9. Sayfayi kapatin
         */
        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com/");

        System.out.println("page position : "+driver.manage().window().getPosition());
        System.out.println("page size : "+driver.manage().window().getSize());

        driver.manage().window().minimize();
        Thread.sleep(3000);

        driver.manage().window().maximize();

        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        System.out.println("page position2 : "+driver.manage().window().getPosition());
        System.out.println("page size2 : "+driver.manage().window().getSize());

        driver.close();




    }
}
