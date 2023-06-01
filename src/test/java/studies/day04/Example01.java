package studies.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Example01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //  2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //  3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //4 Sayfayi "refresh" yapin
        driver.navigate().refresh();

        //5 Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String actual = driver.getTitle();
        String expected = "Spend less";
        if (actual.contains(expected)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED" + actual);
        }

        //6 Gift Cards sekmesine basin
        WebElement giftCards = driver.findElement(By.xpath("(//*[text()='Gift Cards'])[1]"));
        giftCards.click();

        //7  Birthday butonuna basin
        Thread.sleep(2000);
        WebElement birthday = driver.findElement(By.xpath("(//*[text()='Birthday'])[1]"));
        birthday.click();

        //8  Best Seller bolumunden ilk urunu tiklayin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Best Sellers']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='a-dynamic-image p13n-sc-dynamic-image p13n-product-image']")).click();

        // 9- Gift card details'den 25 $'i secin
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@name='selectAmount'])[2]")).click();


        //  10-Urun ucretinin 25$ oldugunu test edin
        WebElement sonuc= driver.findElement(By.xpath("(//*[@name='selectAmount'])[2]"));
        System.out.println("sonuc degeri: "+sonuc.getText());

        if (sonuc.getText().equals("$50")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        // 10-Sayfayi kapatin
        driver.close();

    }
}
