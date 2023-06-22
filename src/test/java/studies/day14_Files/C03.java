package studies.day14_Files;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03 extends TestBase {
    @Test
    public void test01() {

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        wait(1);

        // 3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        // 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
        wait(1);

        // 5. Verify 'GET IN TOUCH' is visible
        WebElement logo1 = driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
        Assert.assertTrue(logo1.isDisplayed());

        // 6. Enter name, email, subject and message
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("omer", Keys.TAB, "fadsfja@gmail.com", Keys.TAB, "" +
                "jflsakjfklasjf", Keys.TAB, "jfksladfjlska;djfs;");
        wait(1);

        // 7. Upload file
        //"C:\Users\Omer\OneDrive\Masaüstü\team.txt"
        WebElement dosyaSec = driver.findElement(By.xpath("(//*[@class='form-control'])[5]"));
        String ortakKisim = System.getProperty("user.home");
        System.out.println(ortakKisim);
        String farkliKisim = "\\OneDrive\\Masaüstü\\team.txt";
        String yol = ortakKisim + farkliKisim;
        System.out.println(yol);
        dosyaSec.sendKeys(yol);
        wait(1);

        // 8. Click 'Submit' button
        Actions action = new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement clikButton = driver.findElement(By.xpath("//*[@class='btn btn-primary pull-left submit_form']"));

        clikButton.click();
        wait(1);

        // 9. Click OK button
        alertAccept();
        wait(1);

        action.sendKeys(Keys.PAGE_UP).perform();

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement sonuc = driver.findElement(By.xpath("//div[@class= 'status alert alert-success']"));
        Assert.assertTrue(sonuc.isDisplayed());
        wait(1);


    }
}
