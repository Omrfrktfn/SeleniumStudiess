package studies.day11_IFrame;

import Utilities.TestBase;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01 extends TestBase {

/*
 Bir class olusturun: IframeTest
● https://the-internet.herokuapp.com/iframe adresine
gidin.
● Bir metod olusturun: iframeTest
○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
konsolda
yazdirin
.
○Text Box’a “Merhaba Dunya!” yazin.
○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
oldugunu dogrulayin ve konsolda yazdirin.
 */

    @Test
    public void IframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement tittle = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(tittle.isDisplayed());
        System.out.println(tittle);

        WebElement IFrame = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(IFrame);
        wait(2);
        WebElement yazi = driver.findElement(By.xpath("//*[@id='tinymce']"));
        yazi.sendKeys("Merhaba Dunya");

        driver.switchTo().parentFrame();

        WebElement sonYazi = driver.findElement(By.xpath("(//*[@target='_blank'])[2]"));
        Assert.assertTrue(sonYazi.isDisplayed());


    }
}
