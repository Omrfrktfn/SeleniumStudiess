package studies.day08Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03 {
    /*
    1.http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10.“US Dollars” in secilmedigini test edin
11.“Selected currency” butonunu secin
12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini
kontrol edin.
     */


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com/");
    }

    @After
    public void tearDown() throws Exception {
          driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        WebElement signt = driver.findElement(By.xpath("//*[@id='signin_button']"));
        Thread.sleep(1000);
        signt.click();

        WebElement userName = driver.findElement(By.xpath("//*[@id='user_login']"));
        Thread.sleep(1000);
        userName.sendKeys("username");

        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        Thread.sleep(1000);
        password.sendKeys("password");

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);
        driver.navigate().back();


        WebElement moreService = driver.findElement(By.xpath("//*[@id='online-banking']"));
        Thread.sleep(1000);
        moreService.click();


        WebElement payBilk = driver.findElement(By.xpath("//*[@id='pay_bills_link']"));
        Thread.sleep(1000);
        payBilk.click();


        WebElement purschase = driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']"));
        Thread.sleep(1000);
        purschase.click();

        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select option = new Select(ddm);
        Thread.sleep(1000);
        option.selectByIndex(6);


        WebElement amout = driver.findElement(By.xpath("//*[@id='pc_amount']"));
        Thread.sleep(1000);
        amout.sendKeys("100");

        WebElement dollar = driver.findElement(By.xpath("//*[@id='pc_inDollars_true']"));
        Thread.sleep(1000);
        //dollar.isSelected();
        Assert.assertFalse(dollar.isSelected());


        WebElement dollar1 = driver.findElement(By.xpath("//*[@id='pc_inDollars_false']"));
        Thread.sleep(1000);
        dollar1.click();

        WebElement calculate = driver.findElement(By.xpath("//*[@id='pc_calculate_costs']"));
        Thread.sleep(1000);
        calculate.click();

        WebElement purchase = driver.findElement(By.xpath("//*[@id='purchase_cash']"));
        Thread.sleep(1000);
        purchase.click();

        WebElement content = driver.findElement(By.xpath("//*[@id='alert_content']"));
        Thread.sleep(1000);
        //dollar.isSelected();
        Assert.assertTrue(content.isDisplayed());

    }
}
