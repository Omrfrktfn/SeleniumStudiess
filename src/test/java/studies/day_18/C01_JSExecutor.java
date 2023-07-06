package studies.day_18;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C01_JSExecutor extends TestBase {

    @Test
    public void test01() {

        //amazon sayfasina gidiniz.
        driver.get("https://amazon.com");
        wait(2);


        WebElement sellLink = driver.findElement(By.xpath("//*[text()='Sell']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sellLink);
        wait(2);


        //Your business at scalee yazisina git
        WebElement business = driver.findElement(By.xpath("(//*[text()='Your business at scale'])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);",business);
        wait(2);


        WebElement benefits = driver.findElement(By.xpath("(//*[text()='Over $50K in potential benefits'])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);",benefits);
        wait(2);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        wait(2);

        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        wait(2);


        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        js.executeScript("arguments[0].value='iphone'",searchBox);
        searchBox.submit();

    }
}
