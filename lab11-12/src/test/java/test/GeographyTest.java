package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.HomePage;

import static org.junit.Assert.assertEquals;

public class GeographyTest {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testGeoError() {
        driver.get("https://www.21vek.by/order/");
        homePage.clickAcceptButton();
        homePage.waitSeconds(2);
        homePage.clickGeoButton();
        homePage.waitSeconds(2);
        homePage.inputGeo("Zalupa");
        homePage.waitSeconds(2);



        assertEquals("Выберите населенный пункт из списка", homePage.getGeoError());

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
