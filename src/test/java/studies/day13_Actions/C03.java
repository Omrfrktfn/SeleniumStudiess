package studies.day13_Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C03 extends TestBase {
    /*
    Test01 :
    1- amazon gidin
    2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    3. dropdown menude 40 eleman olduğunu doğrulayın
    Test02
    1. dropdown menuden elektronik bölümü seçin
    2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
    4. ikinci ürüne relative locater kullanarak tıklayin
    5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    Test03
    1. yeni bir sekme açarak amazon anasayfaya gidin
    2. dropdown’dan bebek bölümüne secin
    3. bebek puset aratıp bulundan sonuç sayısını yazdırın
    4. sonuç yazsının puset içerdiğini test edin
    5-üçüncü ürüne relative locater kullanarak tıklayin
    6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    Test 4
    1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */
    @Test
    public void test01() {
        // 1- amazon gidin
        driver.get("https://www.amazon.com");
        wait(2);

        // 2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select options = new Select(ddm);

        List<WebElement> categoryMenu = driver.findElements(By.tagName("option"));
        categoryMenu.stream().forEach(t -> System.out.println(t.getText()));

        int caregoryCount = ddm.findElements(By.tagName("option")).size();
        System.out.println("Drop Down Sayi : " + caregoryCount);

        // 3. dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertEquals(28, caregoryCount);
    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        wait(2);

        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select options = new Select(ddm);

        //1. dropdown menuden elektronik bölümü seçin
        options.selectByVisibleText("Electronics");
        wait(2);

        //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java");
        searchBox.submit();
        wait(1);

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
        String sonucSayisi[] = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi : " + sonucSayisi[2]);

        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertFalse(sonucYazisi.getText().contains("iphone"));

        //4. ikinci ürüne relative locater kullanarak tıklayin
        wait(1);
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).click();

        //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        wait(1);
        System.out.println("secilen urun basligi : " + driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText());

        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();

    }

    @Test
    public void test03() {
        driver.get("https://www.amazon.com");
        wait(2);

        //1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.getWindowHandle(); //bulunan safyfanin handle degerini alip gecis islemi yapmaliyiz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //2. dropdown’dan bebek bölümüne secin

        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select options = new Select(ddm);
        options.selectByVisibleText("Baby");
        wait(2);


        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("bebek puset");
        searchBox.submit();
        wait(1);

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
        String sonucSayisi[] = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi : " + sonucSayisi[2]);

        //4. sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin


        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

    }
}
