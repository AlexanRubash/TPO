package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.BasketPage;

import static org.junit.Assert.assertEquals;

public class ErrorTest {
    private WebDriver driver;

    private HomePage homePage;



    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void test404ErrorPage() {
        homePage.waitSeconds(2);
        driver.get("https://www.21vek.by/qwertys/");
        //homePage.clickAcceptButton();
        homePage.waitSeconds(2);
        assertEquals("404",  homePage.getErrorNumber());
        homePage.waitSeconds(2);
        driver.get("https://www.21vek.by/mobile/compe213/");
        homePage.waitSeconds(2);

        assertEquals("Страница не найдена", homePage.getErrorHeading());

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
