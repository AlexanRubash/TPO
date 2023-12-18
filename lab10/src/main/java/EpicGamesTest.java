import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EpicGamesTest {

    private WebDriver driver;
    private EpicGamesPage epicGamesPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(options);
        epicGamesPage = new EpicGamesPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testEpicGamesNotFound() {
        epicGamesPage.navigateToPageAndAssert404("https://store.epicgames.com/ru/p/the-lord-of-the-rings-return-to-moria-f01343");
    }

    @Test
    public void testEpicGamesNotAvailibleEmail() {
        epicGamesPage.navigateToLoginPage("https://www.epicgames.com/id/login");
        epicGamesPage.enterInvalidEmail("mrfirefmail.ru");
        epicGamesPage.triggerTabKey();
        epicGamesPage.assertErrorMessage("Неверный адрес электронной почты");
        epicGamesPage.assertLoginButtonNotEnabled();
    }
}
