package studies.day_15;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03 extends TestBase {

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
        wait(2);
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        wait(1);

        //  5. Click 'Cart' button
        driver.findElement(By.xpath("(//*[@class='text-center'])[2]")).click();
        wait(1);

        //  6. Verify that cart page is displayed
        WebElement logo1 = driver.findElement(By.xpath("//*[@class='breadcrumbs']"));
        Assert.assertTrue(logo1.isDisplayed());
        wait(1);

        //  7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        wait(1);

        //  8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
        wait(1);

        //  9. Fill all details in Signup and create account
        Faker faker = new Faker();
        Actions action1 = new Actions(driver);
        WebElement email = driver.findElement(By.xpath("//*[@type='text']"));
        action1.click(email).
                sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.internet().emailAddress(), Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        wait(1);

        WebElement bosluk = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        Actions action2 = new Actions(driver);
        action2.click(bosluk).
                sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.internet().emailAddress(), Keys.TAB).
                sendKeys(faker.internet().password(), Keys.TAB).
                sendKeys("26", Keys.TAB).
                sendKeys("Mart", Keys.TAB).
                sendKeys("1997", Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB).
                sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.name().fullName(), Keys.TAB).
                sendKeys(faker.address().fullAddress(), Keys.TAB).
                sendKeys(faker.address().fullAddress(), Keys.TAB).
                sendKeys("Canada", Keys.TAB).
                sendKeys(faker.address().state(), Keys.TAB).
                sendKeys(faker.address().city(), Keys.TAB).
                sendKeys(faker.address().zipCode(), Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone(), Keys.TAB).
                sendKeys(Keys.SPACE).perform();
        wait(1);

        //  10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement logo2 = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(logo2.isDisplayed());
        wait(1);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        wait(2);

        //  11. Verify ' Logged in as username' at top
        WebElement logo3 = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(logo3.isDisplayed());
        wait(1);

        //  12.Click 'Cart' button
        driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();
        wait(1);

        //  13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        wait(1);

        //  14. Verify Address Details and Review Your Order

        //  15. Enter description in comment text area and click 'Place Order'
        WebElement x = driver.findElement(By.xpath("//*[@class='form-control']"));
        x.sendKeys("dsjfkdsjaf;kdjslkajsgkjaslk;fjdskl;fjsldk;jgskjkljgkljlksdfjkls;djf");
        wait(1);
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        wait(1);

        //  16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement odeme = driver.findElement(By.xpath("//*[@class='form-control']"));
        Actions action3 = new Actions(driver);
        action3.click(odeme).
                sendKeys(faker.name().fullName(), Keys.TAB).
                sendKeys(faker.number().digit(), Keys.TAB).
                sendKeys("333", Keys.TAB).
                sendKeys("02", Keys.TAB).
                sendKeys("2004", Keys.TAB).
                sendKeys(Keys.SPACE).perform();

        //  17. Click 'Pay and Confirm Order' button
        //  18. Verify success message 'Your order has been placed successfully!'
        //  19. Click 'Delete Account' button
        //  20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
