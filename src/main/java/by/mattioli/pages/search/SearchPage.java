package by.mattioli.pages.search;

import by.mattioli.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private WebDriver driver;

    public SearchPage() {
        this.driver = Driver.getDriver();
    }

    public String getSearchBarTitle() {
        return driver.findElement(SearchLocator.SEARCH_BAR_TITLE).getAttribute("placeholder");
    }

    public void SearchBarClick() {
        driver.findElement(SearchLocator.BUTTON_CLICK_SEARCH_BAR).click();
    }

    public void inputSearchBar(String search) {
        driver.findElement(SearchLocator.SEARCH_BAR_FOUND_TEXT).sendKeys(search);
    }

    public String getMessageOfFoundProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SearchLocator.SEARCH_BAR_RESULT_TEXT));
        return element.getText();
    }
}
