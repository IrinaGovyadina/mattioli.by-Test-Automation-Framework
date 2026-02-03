package by.mattioli.pages.search;

import org.openqa.selenium.By;

public class SearchLocator {
    public static final By SEARCH_BAR_TITLE = By.xpath("//input[@id='search_input_popup']");
    public static final By BUTTON_CLICK_SEARCH_BAR = By.xpath("//input[@id='search_input']");
    public static final By SEARCH_BAR_FOUND_TEXT = By.xpath("//input[@id='search_input_popup']");
    public static final By SEARCH_BAR_RESULT_TEXT = By.xpath("//div[@class='search-results__total']/span");
}

