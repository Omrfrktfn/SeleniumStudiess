package studies.day07JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

//2) https://www.youtube.com adresine gidin
    //        3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
//=> Sayfa başlığının “YouTube” oldugunu test edin
//=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
// ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //     ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
          driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.youtube.com/");
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[@class='yt-spec-touch-feedback-shape__fill'])[13]")).click();

        String actualTittle = driver.getTitle();
        Assert.assertTrue(actualTittle.contains("YouTube"));
    }

}
