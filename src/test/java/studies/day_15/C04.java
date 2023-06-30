package studies.day_15;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class C04 extends TestBase {

    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        wait(1);

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        WebElement alanElement = driver.findElement(By.xpath("//*[@class='keys']"));
        Actions action = new Actions(driver);
        action.moveToElement(alanElement).click().perform();

        //Sonucu konsola yazdırıp

        //Sonucun doğrulamasını yapalım
    }
}
