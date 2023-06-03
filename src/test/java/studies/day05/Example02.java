package studies.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Example02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //  1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);

        //2. Username kutusuna “standard_user” yazdirin
        WebElement userName = driver.findElement(By.xpath("//*[@id='user-name']"));
        userName.sendKeys("standard_user");
        Thread.sleep(2000);

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password = driver.findElement(By.xpath("    //*[@id='password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);

        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        Thread.sleep(2000);

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String firstNam = ilkUrun.getText();
        System.out.println("ilk urun ismi : " + firstNam);
        ilkUrun.click();
        Thread.sleep(2000);

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(2000);

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        Thread.sleep(2000);

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement urunName= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
       String newUrunName="Sauce Labs Backpack";
       if (urunName.getText().equals(newUrunName)){
           System.out.println("Urun basarili bir sekilde sepete eklenmistir.");
       }else{
           System.out.println("urun sepete eklenirken bir hata olusmustur yeniden kontrol ediniz." + urunName);
       }
        Thread.sleep(1000);

        //9. Sayfayi kapatin
        driver.close();
    }
}
