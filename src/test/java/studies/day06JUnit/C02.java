package studies.day06JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

import java.time.Duration;

public class C02 {

    //- https://www.facebook.com adresine gidin
    // - Cookies’i kabul edin
    //- “Create an Account” button’una basin
    //- “radio buttons” elementlerini locate edin
    //- Secili degilse cinsiyet butonundan size uygun olani secin

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

        driver.get("https://www.facebook.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(1000);

        WebElement WomanRadio  = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement ManRadio  = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement NoneRadio  = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));
        Thread.sleep(1000);

        ManRadio.isSelected();
        Thread.sleep(2000);

    }
}
