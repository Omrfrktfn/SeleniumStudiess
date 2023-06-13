package studies.day11_IFrame;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class C03 extends TestBase {
    /*
    Yeni bir class olusturun: WindowHandle
    Amazon anasayfa adresine gidin.
    Sayfa’nin window handle degerini String bir degiskene atayin
    Sayfa title’nin “Amazon” icerdigini test edin
    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    Sayfa title’nin “Walmart” icerdigini test edin
    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */

    @Test
    public void test01() {

        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");


        //Sayfa'nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle);


        //Sayfa title'nin "Amazon" icerdigini test edin
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));

        // Assert.assertEquals("Amazon",amazonTitle);

        wait(1);
        //Yeni bir tab olusturup, acilan tab'da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");


        //Sayfa title'nin "TECHPROEDUCATION" icerdigini test edin
        String tecproTitle = driver.getTitle();
        Assert.assertFalse(tecproTitle.contains("TECHPROEDUCATION"));

        wait(1);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        String walwartTitle = driver.getTitle();
        Assert.assertFalse(tecproTitle.contains("Walmart"));

        wait(1);
        driver.switchTo().window(amazonHandle);
        wait(1);


    }
}
