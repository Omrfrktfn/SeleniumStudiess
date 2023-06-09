package studies.day09JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.crypto.spec.OAEPParameterSpec;
import java.time.Duration;
import java.util.List;

public class C02 {
    /*
    -Amazon sayfasına gidelim
-Arama Kutusundaki Dropdown menuyu yazdıralım
-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
Not: Select Class'ı kullanalım
     */

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
        driver.get("https://www.amazon.com/");

        WebElement ddm = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);
        select.getOptions().forEach(w -> System.out.println(w.getText()));
        Thread.sleep(1000);


//        System.out.println("***********************************************************");
//
//        option.selectByIndex(1);
//        Thread.sleep(1000);
//        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//        searchBox.sendKeys(" "+ Keys.ENTER);
//        System.out.println("Sayfa Başlığı 1 = " + driver.getTitle());
//        Thread.sleep(1000);
//
//        driver.navigate().back();
//        Thread.sleep(1000);

        System.out.println("***********************************************************");

        for (int i = 1; i < 6; i++) {
            ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
            select = new Select(ddm);
            select.selectByIndex(i);

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
            System.out.println(driver.getTitle());
            Thread.sleep(2000);

        }

    }
}
