package by.mattioli.testUI;

import by.mattioli.driver.Driver;
import by.mattioli.pages.home.HomePage;
import by.mattioli.pages.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    public void openHomePageAndAcceptCookieAndClickEnter() {
        homePage = new HomePage();
        homePage.open();
        homePage.clickCookie();
        homePage.clickEnter();
    }

    @Test
    public void testLoginForm() {
        loginPage = new LoginPage();
        loginPage.clickOnLoginWithPassword();
        loginPage.inputEmail("test@test.com");
        loginPage.inputPassword("987456");
        loginPage.putButtonEnter();
        loginPage.getErrorMessage();
        Assertions.assertEquals("Неверно указан телефон, логин, email или пароль", loginPage.getErrorMessage());
    }

    @AfterEach
    public void quit() {
        Driver.quit();
    }
}
