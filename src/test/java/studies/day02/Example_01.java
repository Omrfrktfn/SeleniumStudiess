package studies.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example_01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1.Bir class oluşturun: LoginTest
        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
            a. http://a.testaddressbook.com adresine gidiniz.
            b. Sign in butonuna basin
            c. email textbox,password textbox, and signin button elementlerini locate ediniz..
            d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
                i. Username : testtechproed@gmail.com
                ii. Password : Test1234!
            e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
            f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        3. Sayfada kac tane link oldugunu bulun.
         */

        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://testaddressbook.com");

        //ek bölüm --- çıkan ekranı geçme
        WebElement adminButon = driver.findElement(By.partialLinkText("Admin Panel"));
        adminButon.click();


        // mail gir
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("testtechproed@gmail.com");

        //şifre gir
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Test1234!");

        //     b. Sing in butonuna basin
        WebElement signInButton = driver.findElement(By.cssSelector(".login-button.Button.Button--primary.Button--block.m-bottom-2"));
        signInButton.click();



    }
}
