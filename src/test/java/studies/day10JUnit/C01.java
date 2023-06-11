package studies.day10JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify that Brands are visible on left side bar
5. Click on any brand name
6. Verify that user is navigated to brand page and brand products are displayed
7. On left side bar, click on any other brand link
8. Verify that user is navigated to that brand page and can see products

1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' URL'sine gidin
3. 'Ürünler' düğmesine tıklayın
4. Sol taraftaki çubukta Markaların göründüğünü doğrulayın
5. Herhangi bir marka adına tıklayın
6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın.
7. Sol taraftaki çubukta herhangi bir başka marka bağlantısına tıklayın
8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın
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
       // driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://automationexercise.com");
    }
}
