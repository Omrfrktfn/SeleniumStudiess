package studies.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Example_03 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //iphone aratınız
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        Thread.sleep(2000);
        searchBox.submit();

        //çıkan sonuç yazısını konsola yazdırınız
        List<WebElement> sonucYazisi = driver.findElements(By.className("sg-col-inner"));
        WebElement sonuc = sonucYazisi.get(0);
        System.out.println(sonuc.getText());

        // sonuc sayısını yazdırın
        String sonucSayisi [] = sonuc.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi));//bu kisimda ayirma islemi yaptik kapali kalabilir
        System.out.println(sonucSayisi[2]);

        // ilk ürünün locatini alın
        List<WebElement> ilkUrun = driver.findElements(By.className("s-image"));
        WebElement ilkUrunSonuc = ilkUrun.get(0);

        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrunSonuc.isDisplayed());

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrunSonuc.isEnabled());

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrunSonuc.isSelected());

        // ilk urune tıklayın
        ilkUrunSonuc.click();
        System.out.println("ilk sayfa basligi: " +driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();

        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız

        //ikinci urun


        // Tarayıcıyı kapatın
      //  driver.quit();

    }
}
