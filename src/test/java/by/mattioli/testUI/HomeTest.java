package by.mattioli.testUI;

import by.mattioli.driver.Driver;
import by.mattioli.pages.home.HomeLabel;
import by.mattioli.pages.home.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeTest {
    private HomePage homePage;

    @BeforeEach
    public void openHomePageAndAcceptCookie() {
        homePage = new HomePage();
        homePage.open();
        homePage.clickCookie();
    }

    @Test
    public void testNameCompanyFooter() {
        Assertions.assertTrue(homePage.getNameCompanyFooterText().contains(HomeLabel.NAME_COMPANY_FOOTER_TEXT), "There is no 'СООО «Маттиоли». Свидетельство о регистрации коммерческой регистрации: УНН(УНП)101 503 942. Регистрация 30.06.1998 г, № 106. Регистрирующий орган: Минский областной исполнительный комитет. Дата регистрации в торговом реестре Республики Беларусь 20.09.2019. 2026' text");
    }

    @AfterEach
    public void quit() {
        Driver.quit();
    }
}
