package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //abstract class yaptik cunku obje olusturulmasini istemiyoruz , depo olarak kullanacagiz.
    //Bu class'a extend ettigimiz test class'larindan ulasabiliriz.
    //TestBase class'indan obje olusturulmasinin onune gecilmesi icin abstract class yapilabilir.

    protected WebDriver driver;
    //olusturudugumuz driver'i kullanabilmemiz icin protected yaptik.

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
          driver.quit();
    }

    public void wait(int seconds) {

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void alertPrompt( String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void alertText (){
        System.out.println(driver.switchTo().alert().getText());
    }
}
