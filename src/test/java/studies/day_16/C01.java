package studies.day_16;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01 extends TestBase {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart

1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' URL'sine gidin
3. Ana sayfanın başarıyla göründüğünü doğrulayın
4. Sepete ürün ekleyin
5. 'Sepet' düğmesine tıklayın
6. Sepet sayfasının görüntülendiğini doğrulayın
7. Belirli bir ürüne karşılık gelen 'X' düğmesine tıklayın
8. Ürünün sepetten çıkarıldığını doğrulayın
     */

    @Test
    public void test01() {
        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        wait(1);

        //  3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        wait(1);

        //  4. Add products to cart
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN);
        wait(1);
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        wait(1);

        //  5. Click 'Cart' button
        driver.findElement(By.xpath("(//*[@class='text-center'])[2]")).click();
        wait(1);

        //  6. Verify that cart page is displayed
        WebElement logo1 = driver.findElement(By.xpath("//*[@class='breadcrumbs']"));
        Assert.assertTrue(logo1.isDisplayed());
        wait(1);

        // 7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//*[@class='fa fa-times']")).click();
        wait(1);

        //8. Ürünün sepetten çıkarıldığını doğrulayın
        WebElement sonYazi = driver.findElement(By.xpath("(//*[@class='text-center'])[3]"));
        Assert.assertTrue(sonYazi.isDisplayed());

    }
}
