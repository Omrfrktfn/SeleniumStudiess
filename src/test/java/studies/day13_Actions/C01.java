package studies.day13_Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01 extends TestBase {

    @Test
    public void name() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        wait(1);

        // 2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverOver = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOver).perform();
        wait(1);

        // 3- Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        link1.sendKeys(Keys.ENTER);
        wait(1);

        // 4- Popup mesajini yazdirin
        System.out.println("pop mesaji :  " + driver.switchTo().alert().getText());
        wait(1);

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        wait(1);

        // 6- “Click and hold" kutusuna basili tutun
        WebElement clikAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));

        actions.clickAndHold(clikAndHold).perform();
        wait(1);

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String clikAndHold1 = driver.findElement(By.xpath("//*[@id='click-box']")).getText();
        System.out.println(clikAndHold1);
        wait(1);

        // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleButton = driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleButton).perform();

        WebElement yesil = driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        Assert.assertTrue(yesil.isDisplayed());
    }
}
