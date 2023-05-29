package studies.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example_4 {
    public static void main(String[] args) throws InterruptedException {

        /*
        2. Amazon soyfasina gidelim. https://www.amazon.com/
        3. Sayfanin konumunu ve boyutlarini yazdirin
        4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        5. Sayfanin sizin istediginiz konum ve boyuta geldigini test  edin
        8. Sayfayi kapatin
         */


        System.setProperty("WebDriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com/");
        System.out.println("page position : "+driver.manage().window().getPosition());
        System.out.println("page size : "+driver.manage().window().getSize());

        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(900, 600));
        driver.manage().window().setPosition(new Point(50,50));



    }
}
