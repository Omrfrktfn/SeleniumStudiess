package studies.day08Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02 {
    /*
    ● Bir class oluşturun: C3_DropDownAmazon
    ● https://www.amazon.com/ adresine gidin.
    - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori
    sayisinin 45
    oldugunu test edin
    -Test 2
    1.Kategori menusunden Books secenegini secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() throws Exception {
          driver.close();
    }

    @Test
    public void test01() {

        // WebElement categoryMenu = driver.findElement(By.xpath("//*[@class='nav-search-scope nav-sprite']"));
        //List<WebElement> categoryMenu = driver.findElements(By.tagName("option"));
        // categoryMenu.stream().forEach(t-> System.out.println(t.getText()));//category menusunun icerigi

        WebElement category = driver.findElement(By.xpath("//*[@class='nav-search-scope nav-sprite']"));
        int caregoryCount = category.findElements(By.tagName("option")).size();
        if (caregoryCount == 45) {
            System.out.println("Test 1: Kategori sayısı doğru.");
        } else {
            System.out.println("Test 1: Kategori sayısı yanlış.");
        }
        // Assert.assertFalse(45,caregoryCount);
    }

    @Test
    public void test02() throws InterruptedException {
        WebElement ddmCategory = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Thread.sleep(1000);
        Select option = new Select(ddmCategory);
        option.selectByVisibleText("Books");
        Thread.sleep(1000);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java");
        searchBox.submit();
        Thread.sleep(1000);

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
        String sonucSayisi[] = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi : " + sonucSayisi[3]);

        Assert.assertTrue(sonucYazisi.getText().contains("Java"));
    }
}
