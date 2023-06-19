package studies.day14_Files;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01 extends TestBase {

    @Test
    public void test01() {

        // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        wait(1);

        // - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement sayfa = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);

        Point startPoint = sayfa.getLocation();
        int startX = startPoint.getX() + 50; // Kare çizimine başlangıç noktası
        int startY = startPoint.getY() + 50;

        actions.clickAndHold(sayfa)
                .moveByOffset(100, 0) // Kareyi sağa sürükle
                .moveByOffset(0, 100) // Kareyi aşağı sürükle
                .moveByOffset(-100, 0) // Kareyi sola sürükle
                .moveByOffset(0, -100) // Kareyi yukarı sürükle
                .release()
                .perform();

        wait(2);
        // - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[@class='button clear']")).click();


        // - Sayfayi kapatiniz
    }
}
