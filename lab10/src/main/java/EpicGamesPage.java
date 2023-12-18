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

public class EpicGamesPage {

    private WebDriver driver;

    public EpicGamesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPageAndAssert404(String url) {
        driver.get(url);
        WebElement notFoundDiv = driver.findElement(By.cssSelector(".css-bd6e9y span"));
        WebElement notFoundHeader = driver.findElement(By.cssSelector(".css-i16h77 h1"));

        Assert.assertEquals(notFoundDiv.getText(), "404");
        Assert.assertEquals(notFoundHeader.getText(), "Страница не найдена");
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void enterInvalidEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".MuiInputBase-input.MuiOutlinedInput-input")));
        emailInput.sendKeys(email);
    }

    public void triggerTabKey() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    public void assertErrorMessage(String expectedErrorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiFormHelperText-root.Mui-error span.MuiTypography-root")));
        String errorMessage = errorElement.getText();
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage), "Incorrect error message");
    }

    public void assertLoginButtonNotEnabled() {
        WebElement loginButton = driver.findElement(By.cssSelector("button#send"));
        Assert.assertFalse(loginButton.isEnabled(), "Login button is enabled, but it shouldn't be");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
