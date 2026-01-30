package by.mattioli.testUI;

import by.mattioli.driver.Driver;
import by.mattioli.pages.home.HomePage;
import by.mattioli.pages.search.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchTest {
    private HomePage homePage;
    private SearchPage searchPage;

    @BeforeEach
    public void openHomePageAndAcceptCookie() {
        homePage = new HomePage();
        homePage.open();
        homePage.clickCookie();
        searchPage = new SearchPage();
        searchPage.SearchBarClick();
    }

    @Test
    public void test3() {
        Assertions.assertEquals("Поиск товара", searchPage.getSearchBarTitle());
    }

    @Test
    public void test() {
        searchPage.inputSearchBar("сумка");
        searchPage.getMessageOfFoundProduct();
        Assertions.assertEquals("Найдено 0 товаров", searchPage.getMessageOfFoundProduct());
    }

    @Test
    public void test2() {
        searchPage.inputSearchBar("015");
        searchPage.getMessageOfFoundProduct();
        Assertions.assertEquals("Найдено 5 товаров", searchPage.getMessageOfFoundProduct());
    }

    @AfterEach
    public void quit() {
        Driver.quit();
    }
}
