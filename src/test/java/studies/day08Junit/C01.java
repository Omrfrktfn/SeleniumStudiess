package studies.day08Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
//Before methodunda http://www.google.com adresine gidin
//Üç farklı test methodu ile;
//arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//After method'u ile başlıkları yazdırınız
//AfterClass ile browser'ı kapatınız

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
        Thread.sleep(1000);

    }

    @Test
    public void test01() throws InterruptedException {

        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        WebElement searchBox1 = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchBox1.sendKeys("The God Father");
        searchBox1.submit();
        Thread.sleep(1000);

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonucSayisi[] = sonucYazisi.getText().split(" ");

        System.out.println("The God Fathe sonuc sayisi: " + sonucSayisi[1]);

    }

    @Test
    public void test02() throws InterruptedException {
        WebElement searchBox1 = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchBox1.sendKeys("Lord of the Rings");
        searchBox1.submit();
        driver.navigate().refresh();
        Thread.sleep(1000);

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonucSayisi[] = sonucYazisi.getText().split(" ");

        System.out.println("Lord of the Rings sonuc sayisi: " + sonucSayisi[1]);
    }

    @Test
    public void test03() throws InterruptedException {
        WebElement searchBox1 = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchBox1.sendKeys("Kill Bill");
        searchBox1.submit();
        driver.navigate().refresh();
        Thread.sleep(1000);

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonucSayisi[] = sonucYazisi.getText().split(" ");

        System.out.println("Kill Bill sonuc sayisi: " + sonucSayisi[1]);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public static void afterClass() throws Exception {
         Thread.sleep(1000);
         driver.close();
    }
}
