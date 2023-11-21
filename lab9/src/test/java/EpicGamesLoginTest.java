import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class EpicGamesLoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(options);
        driver.get("https://www.epicgames.com/id/login");
    }

    @Test
    public void testInvalidLogin() {
        // включаем ожидание, тк иногда страница не успевает прогрузится
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".MuiInputBase-input.MuiOutlinedInput-input")));
        emailInput.sendKeys("неверныйemail");

        //нжимаем tab чтобы оно перешло с нашего инпута на другое поле, только после выхода с поля инпут появляется сообщение об ошибке
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();

// ждем появления сообщения об ошибке
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiFormHelperText-root.Mui-error span.MuiTypography-root")));

// проееряем что это именно тот текст
        String errorMessage = errorElement.getText();
        Assert.assertTrue(errorMessage.contains("Неверный адрес электронной почты"), "Неверный текст ошибки");

// Проверка, что кнопка осталась неактивной
        WebElement loginButton = driver.findElement(By.cssSelector("button#send"));
        Assert.assertFalse(loginButton.isEnabled(), "Кнопка активна, хотя не должна быть");
        // задержка на 2 секунды
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
