import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class EpicGamesTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(options);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void navigateToPageAndAssert404(String url) {
        if (driver != null) {
            driver.get(url);
            WebElement notFoundDiv = driver.findElement(By.cssSelector(".css-bd6e9y span"));
            WebElement notFoundHeader = driver.findElement(By.cssSelector(".css-i16h77 h1"));

            Assert.assertEquals(notFoundDiv.getText(), "404");
            Assert.assertEquals(notFoundHeader.getText(), "Страница не найдена");
        }
    }

    public void navigateToLoginPage(String url) {
        if (driver != null) {
            driver.get(url);
        }
    }

    public void enterInvalidEmail(String email) {
        if (driver != null) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".MuiInputBase-input.MuiOutlinedInput-input")));
            emailInput.sendKeys(email);
        }
    }

    public void triggerTabKey() {
        if (driver != null) {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).perform();
        }
    }

    public void assertErrorMessage(String expectedErrorMessage) {
        if (driver != null) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiFormHelperText-root.Mui-error span.MuiTypography-root")));
            String errorMessage = errorElement.getText();
            Assert.assertTrue(errorMessage.contains(expectedErrorMessage), "Incorrect error message");
        }
    }

    public void assertLoginButtonNotEnabled() {
        if (driver != null) {
            WebElement loginButton = driver.findElement(By.cssSelector("button#send"));
            Assert.assertFalse(loginButton.isEnabled(), "Login button is enabled, but it shouldn't be");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
