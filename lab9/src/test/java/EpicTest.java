import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EpicTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(options);
    }

    @Test
    public void testNotFoundPage() {
        // переход на существующую страницу
        driver.get("https://store.epicgames.com/ru/p/the-lord-of-the-rings-return-to-moria-f01344");

        // переход на несуществующую страницу
        driver.get("https://store.epicgames.com/ru/p/the-lord-of-the-rings-return-to-moria-f01343");

        // Проверка, что мы находимся на странице 404
        WebElement notFoundDiv = driver.findElement(By.cssSelector(".css-bd6e9y span"));
        WebElement notFoundHeader = driver.findElement(By.cssSelector(".css-i16h77 h1"));

        Assert.assertEquals(notFoundDiv.getText(), "404");
        Assert.assertEquals(notFoundHeader.getText(), "Страница не найдена");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
