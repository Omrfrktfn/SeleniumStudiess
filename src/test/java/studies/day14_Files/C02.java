package studies.day14_Files;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02 extends TestBase {

    @Test
    public void test01() {


        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        wait(1);

        // 3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());


        // 4. Click 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        wait(1);

        try {
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='aswift_5']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='dismiss-button']")));
        } catch (Exception e) {
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='aswift_5']")));
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ad_iframe']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[text()='Close']")));
        }
        wait(1);

        // 5. Hover over first product and click 'Add to cart'
        Actions action = new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        wait(1);

        // 6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        wait(1);

        // 7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]")).click();
        wait(1);

        // 8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        wait(1);

        // 9. Verify both products are added to Cart
        WebElement picture1 = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertTrue(picture1.isDisplayed());

        WebElement picture2 = driver.findElement(By.xpath("//*[text()='Men Tshirt']"));
        Assert.assertTrue(picture2.isDisplayed());


        // 10. Verify their prices, quantity and total price

    }
}