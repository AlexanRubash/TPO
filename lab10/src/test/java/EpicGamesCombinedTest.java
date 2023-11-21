import org.testng.annotations.Test;


public class EpicGamesCombinedTest {
    EpicGamesTest epicGamesTest = new EpicGamesTest();
    @Test
    public void testEpicGamesNotFound() {
        epicGamesTest.setUp();
        epicGamesTest.navigateToPageAndAssert404("https://store.epicgames.com/ru/p/the-lord-of-the-rings-return-to-moria-f01343");
        epicGamesTest.tearDown();
    }
    @Test
    public void testEpicGamesNotAvailibleEmail(){
        epicGamesTest.setUp();
        epicGamesTest.navigateToLoginPage("https://www.epicgames.com/id/login");
        epicGamesTest.enterInvalidEmail("mrfirefmail.ru");
        epicGamesTest.triggerTabKey();

        epicGamesTest.assertErrorMessage("Неверный адрес электронной почты");
        epicGamesTest.assertLoginButtonNotEnabled();

        epicGamesTest.tearDown();
    }


}
