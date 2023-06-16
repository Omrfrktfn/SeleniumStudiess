package studies.day12;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04 extends TestBase {

    @Test
    public void test01() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.perform();

        //3. Verify that categories are visible on left side bar
        WebElement categories = driver.findElement(By.xpath("//*[@class='panel-group category-products']"));
        Assert.assertTrue(categories.isDisplayed());
        wait(2);
        //4. Click on 'Women' category
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();

        wait(2);

        //5. 'Kadınlar' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
        driver.findElement(By.xpath("(//*[text()='Dress '])[1]")).click();
        wait(2);


        //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'WOMEN - DRESS PRODUCTS' metnini onaylayın
        WebElement baslik = driver.findElement(By.xpath("//*[text()='Women - Dress Products']"));
        Assert.assertTrue(baslik.isDisplayed());
        wait(2);


        //7. Sol kenar çubuğunda, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();


        //8. Kullanıcının bu kategori sayfasına yönlendirildiğini doğrulayın
        WebElement baslikMen = driver.findElement(By.xpath("//*[text()='Men - Tshirts Products']"));
        Assert.assertTrue(baslikMen.isDisplayed());
    }
}
