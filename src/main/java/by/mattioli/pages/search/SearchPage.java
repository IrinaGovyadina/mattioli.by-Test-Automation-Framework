package by.mattioli.pages.search;

import by.mattioli.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private static final Logger logger = LogManager.getLogger();
    private WebDriver driver;
    private static final int DEFAULT_DURATION_OF_SECONDS = 10;

    public SearchPage() {
        this.driver = Driver.getDriver();
    }

    public String getSearchBarTitle() {
        String titleSearchBar = driver.findElement(SearchLocator.SEARCH_BAR_TITLE).getAttribute("placeholder");
        logger.info("Получаем заголовок строки поиска: " + titleSearchBar);
        return titleSearchBar;
    }

    public void SearchBarClick() {
        driver.findElement(SearchLocator.BUTTON_CLICK_SEARCH_BAR).click();
    }

    public void inputSearchBar(String search) {
        logger.info("Ввводим данные в строку поиска");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_DURATION_OF_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(SearchLocator.SEARCH_BAR_FOUND_TEXT)).click();
        driver.findElement(SearchLocator.SEARCH_BAR_FOUND_TEXT).sendKeys(search);
    }

    public String getMessageOfFoundProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_DURATION_OF_SECONDS));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SearchLocator.SEARCH_BAR_RESULT_TEXT));
        String messageOfFoundProduct = element.getText();
        logger.info("Выводится сообщение о найденном товаре: " + messageOfFoundProduct);
        return messageOfFoundProduct;
    }
}
