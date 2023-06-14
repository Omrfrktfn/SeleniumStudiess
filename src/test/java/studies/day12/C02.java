package studies.day12;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class C02 extends TestBase {
    /*
    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
-Çıkan alert'te iptal butonuna basınız
-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
-Çıkan mesajı konsola yazdırınız
-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
     */

    @Test
    public void test01() {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        wait(1);

        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
        wait(1);

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        wait(1);

        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        wait(1);

        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        wait(1);

        driver.switchTo().alert().dismiss();
        wait(1);

        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        wait(1);

        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        wait(1);

        driver.switchTo().alert().sendKeys("omer");
        wait(1);
        driver.switchTo().alert().accept();

        String sonuc =driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println(sonuc);
    }
}
