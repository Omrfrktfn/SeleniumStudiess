package studies.day12;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class C03 extends TestBase {

    @Test
    public void test01() {
        /*
        ● https://testcenter.techproeducation.com/index.php?page=multiple-windows
● Title in ‘Windows’ oldugunu test edin
● Click here a tiklayin
● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
         */

        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String first = driver.getWindowHandle();
        System.out.println(first);
        wait(1);

        String actulaTittle = driver.getTitle();
        System.out.println(actulaTittle);
        String expected = "Windows";
        Assert.assertTrue(actulaTittle.equals(expected));

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Set<String> handleslar = driver.getWindowHandles();
        System.out.println(handleslar);

        String second = "";

        for (String w : handleslar) {
            if (!w.equals(first)) {
                second = w;
            }
        }
        driver.switchTo().window(second);
        System.out.println(second);

        String actulaTittle1 = driver.getTitle();
        System.out.println(actulaTittle1);
        String expected1 = "New Window";
        Assert.assertTrue(actulaTittle1.equals(expected1));


    }
}
