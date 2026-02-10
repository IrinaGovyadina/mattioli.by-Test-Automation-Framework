package by.mattioli.pages.home;

import by.mattioli.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class HomePage {
    private static final Logger logger = LogManager.getLogger();

    private final String HOME_URL = "https://mattioli.by/";
    private WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    public HomePage open() {
        driver.get(HOME_URL);
        logger.info("Открылась домашняя страница");
        return this;
    }

    public HomePage clickCookie() {
        driver.findElement(HomeLocator.ACCEPT_COOKIES).click();
        logger.info("Принимаем кукки");
        return this;
    }

    public String getNameCompanyFooterText() {
        logger.info("Текст компании равен: " + HomeLabel.NAME_COMPANY_FOOTER_TEXT);
        return driver.findElement(HomeLocator.NAME_COMPANY_FOOTER).getText();
    }

    public HomePage clickEnter() {
        driver.findElement(HomeLocator.BUTTON_ENTER).click();
        return this;
    }
}
