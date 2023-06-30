package studies.day_15;

import Utilities.TestBase;
import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class C04 extends TestBase {

    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        wait(1);

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım

        for (int i = 0; i<2; i++){
            Random rnd= new Random();
            int random1 = rnd.nextInt();
            List<WebElement> sayilar = driver.findElements(By.xpath("//*[@class='btn btn-outline-primary']"));


        }


     //   List<WebElement> sayilar = driver.findElements(By.xpath("//*[@class='btn btn-outline-primary']"));


        //Sonucu konsola yazdırıp

        //Sonucun doğrulamasını yapalım
    }
}
