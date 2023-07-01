package studies.day_15;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class C05 extends TestBase {
    Random random;

    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        /////rastgele sayi urettik

        //div[@id='calculator']//span[contains(text(),'0')]
        for (int i = 0; i < 2; i++) {
            random = new Random();
            int randomSayi = random.nextInt(10);
            driver.findElement(By.xpath("//div[@id='calculator']//span[contains(text(),'" + randomSayi + "')]")).click();

        }


        List<WebElement> isaretler = driver.findElements(By.xpath("//*[@id='calculator']//span[contains(@class,'operator btn btn-outline-success')]"));

        int index = random.nextInt(isaretler.size());
        WebElement islemler = isaretler.get(index);
        islemler.click();
        wait(1);

        for (int i = 0; i < 2; i++) {
            random = new Random();
            int randomSayi = random.nextInt(10);
            driver.findElement(By.xpath("//div[@id='calculator']//span[contains(text(),'" + randomSayi + "')]")).click();

        }
        String kova2 = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        System.out.println("kova2 = " + kova2);
        String[] split = kova2.split("[-+x÷]");

        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));

        String rakam1 = split[0];
        double rakam11 = Double.parseDouble(rakam1);
        System.out.println("rakam11 = " + rakam11);

        wait(1);
        String rakam2 = split[1];

        double rakam22 = Double.parseDouble(rakam2);
        System.out.println("rakam22 = " + rakam22);
        wait(1);

        driver.findElement(By.xpath("//*[@class='btn btn-outline-warning']")).click();


        //Sonucun doğrulamasını yapalım
        double sonuc = 0;
        switch (islemler.getText()) {
            case "+":
                sonuc = rakam11 + rakam22;
                break;
            case "-":
                sonuc = rakam11 - rakam22;
                break;
            case "x":
                sonuc = rakam11 * rakam22;
                break;
            case "÷":
                sonuc = rakam11 / rakam22;
                break;
            default:
                System.out.println("Geçersiz işlem yönü");
                break;
        }

        System.out.println("sonuc = " + sonuc);
        wait(3);
        WebElement sonEkran = driver.findElement(By.xpath("//*[@class='screen']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String screen = wait.until(ExpectedConditions.visibilityOf(sonEkran)).getText().trim();
        double screenActual = Double.parseDouble(screen);
        System.out.println("screenActual = " + screenActual);
        System.out.println("screen = " + screenActual);

        Assert.assertEquals(sonuc, screenActual, 0.001);
    }

    @Test
    public void test02() {

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        wait(1);

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim
        List<WebElement> sayilar = driver.findElements(By.xpath("(//span[@class='btn btn-outline-primary'])[position()<11]"));
        System.out.println("sayi adet : " + sayilar.size());


        random = new Random();
        int randomNumber1 = random.nextInt(10) + 1;
        int randomNumber2 = random.nextInt(10) + 1;
        /*
        random.nextInt(10) ifadesi kullanılarak 0 ila 9 arasında rastgele bir sayı elde edilir.
        Bu ifade, random nesnesi üzerinden nextInt() metodunu kullanarak 0 ila 9 arasında bir
         rastgele sayı üretir ve sonrasında buna 1 ekleyerek 1 ila 10 arasında bir rastgele sayı oluşturur.
         */

        driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[position()<11][" + randomNumber1 + "]")).click();
        driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[position()<11][" + randomNumber2 + "]")).click();

        /*
        "[" + randomNumber1 + "]": Bu kısım, önceden belirlenmiş bir rastgele sayı olan randomNumber1 değişkenini ifadeye ekler.
         Bu, XPath ifadesinin konum bölümünde rastgele bir sayıya göre öğe seçmek için kullanılır.
         */

        wait(1);

        List<WebElement> islemler = driver.findElements(By.xpath("//span[@class='operator btn btn-outline-success']"));
        Random random2 = new Random();
        int islemindex = random2.nextInt(islemler.size());
        System.out.println(islemindex);
        WebElement islem = islemler.get(islemindex);
        islem.click();

        /*
        List<WebElement> islemler = ...: Bulunan tüm öğeler islemler adında bir List<WebElement> listesine atanır. Bu liste, WebElement nesnelerini içerir.

        int islemindex = random2.nextInt(islemler.size());: islemler listesinin boyutuna (size()) dayanarak 0 ila islemler.size() - 1 arasında bir
        rastgele sayı oluşturulur. Bu, listedeki öğelerin rastgele bir sırasını temsil eder.

        WebElement islem = islemler.get(islemindex);:
        islemler listesindeki islemindex indeksine sahip olan öğe seçilir ve islem adında bir WebElement nesnesine atanır.
        Bu, rastgele seçilen bir öğeyi temsil eder.
         */

        wait(1);

        random = new Random();
        int randomNumber3 = random.nextInt(10) + 1;
        int randomNumber4 = random.nextInt(10) + 1;

        driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[position()<11][" + randomNumber3 + "]")).click();
        driver.findElement(By.xpath("(//span[@class='btn btn-outline-primary'])[position()<11][" + randomNumber4 + "]")).click();

        wait(1);

        driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']")).click();//enter tuşuna bastık
    }
}
