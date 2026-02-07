package by.mattioli.testUI;

import by.mattioli.driver.Driver;
import by.mattioli.pages.home.HomePage;
import by.mattioli.pages.search.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchTest {
    private HomePage homePage;
    private SearchPage searchPage;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void openHomePageAndAcceptCookie() {
        homePage = new HomePage();
        homePage.open();
        homePage.clickCookie();
        searchPage = new SearchPage();
        searchPage.SearchBarClick();
    }

    @Test
    public void testSearchTitle() {
        logger.info("Выполняется проверка заголовка строки поиска");
        Assertions.assertEquals("Поиск товара", searchPage.getSearchBarTitle());
    }

    @Test
    public void testSearchInvalidData() {
        logger.info("Выполняется тест строки поиска с неверно введенными данными");
        searchPage.inputSearchBar("сумка");
        searchPage.getMessageOfFoundProduct();
        Assertions.assertEquals("Найдено 0 товаров", searchPage.getMessageOfFoundProduct());
    }

    @Test
    public void testSearchValidDate() {
        logger.info("Выполняется тест строки поиска с валидными данными");
        searchPage.inputSearchBar("015");
        searchPage.getMessageOfFoundProduct();
        Assertions.assertEquals("Найдено 5 товаров", searchPage.getMessageOfFoundProduct());
    }

    @AfterEach
    public void quit() {
        Driver.quit();
    }
}
