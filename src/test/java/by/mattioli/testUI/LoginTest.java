package by.mattioli.testUI;

import by.mattioli.driver.Driver;
import by.mattioli.pages.home.HomePage;
import by.mattioli.pages.login.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void openHomePageAndAcceptCookieAndClickEnter() {
        homePage = new HomePage();
        homePage.open();
        homePage.clickCookie();
        homePage.clickEnter();
        loginPage = new LoginPage();
    }

    @Test
    public void testLoginForm() {
        logger.info("Проверка входа в личный кабинет с неверными учетными данными");
        loginPage.clickOnLoginWithPassword();
        loginPage.inputEmail("test@test.com");
        loginPage.inputPassword("987456");
        loginPage.putButtonEnter();
        loginPage.getErrorMessage();
        Assertions.assertEquals("Неверно указан телефон, логин, email или пароль", loginPage.getErrorMessage());
    }

    @Test
    public void testLoginFormEmpty(){
        logger.info("Проверка входа в личный кабинет с пустыми полями логина и пароля");
        loginPage.clickOnLoginWithPassword();
        loginPage.inputEmail("");
        loginPage.inputPassword("");
        loginPage.putButtonEnter();
        loginPage.getErrorMessage();
        Assertions.assertEquals("Не указан телефон, логин или email", loginPage.getErrorMessage());
    }

    @AfterEach
    public void quit() {
        Driver.quit();
    }
}
