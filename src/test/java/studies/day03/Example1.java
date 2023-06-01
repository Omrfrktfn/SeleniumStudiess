package studies.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example1 {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Techproeducation sayfasına gidelim
        driver.get("http://techproeducation.com");

        //Çıkan reklamı locate edip kapatalım
        WebElement kapatmatusu= driver.findElement(By.xpath("//*[@class='eicon-close']"));
        kapatmatusu.click();

        //Arama bölümünde qa aratalım
        WebElement aramaMotoru = driver.findElement(By.id("elementor-search-form-9f26725"));
        aramaMotoru.sendKeys("qa");

        //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualName =driver.getTitle();
        String expectedName = "qa";
        if (actualName.equals(expectedName)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED : " + actualName);
        }

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım

        //Carrer Opportunities In QA linkine tıklayalım

        //Başlığın Opportunities içerdiğini test edelim

        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım


    }
}
