package by.mattioli.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static final Logger logger = LogManager.getLogger();
    private static WebDriver driver;

    private Driver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        logger.info("Создали хром-драйвер");
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Закрыли хром-драйвер");
        }
    }
}
