package studies.day_18;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JSExecutor extends TestBase {

    @Test
    public void test01() {

        driver.get("https://www.priceline.com/");
        wait(2);

        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        wait(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String valueAttribute = (String) js.executeScript("return document.getElementById('hotelDates').value");
        System.out.println(valueAttribute);


    }
}
