package by.mattioli.pages.home;

import by.mattioli.driver.Driver;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final String HOME_URL = "https://mattioli.by/";
    private WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    public HomePage open() {
        driver.get(HOME_URL);
        return this;
    }

    public HomePage clickCookie() {
        driver.findElement(HomeLocator.ACCEPT_COOKIES).click();
        return this;
    }

    public String getNameCompanyFooterText() {
        return driver.findElement(HomeLocator.NAME_COMPANY_FOOTER).getText();
    }

    public HomePage clickEnter() {
        driver.findElement(HomeLocator.BUTTON_ENTER).click();
        return this;
    }
}
