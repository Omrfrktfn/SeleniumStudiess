package studies.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        for (int i = 0; i < 99; i++) {
            WebElement addElement = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
            addElement.click();
        }

        // 100 defa basıldığını test ediniz
        WebElement deleteButtonsContainer = driver.findElement(By.id("elements"));
        int deleteButtonCount = deleteButtonsContainer.findElements(By.tagName("button")).size();
        if (deleteButtonCount == 100) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED. Expected: 100, Actual: " + deleteButtonCount);
        }

        // 90 defa delete butonuna basınız
        for (int i = 0; i<91;i++) {
            WebElement addDelete = driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));
            addDelete.click();
        }
        // 90 defa basıldığını doğrulayınız
        WebElement delete = driver.findElement(By.id("elements"));
        int deleteButton = delete.findElements(By.tagName("button")).size();
        if (deleteButton == 8) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED.Actual: " + deleteButton);
        }

        // Sayfayı kapatınız
        Thread.sleep(2000);
        driver.close();

    }
}
