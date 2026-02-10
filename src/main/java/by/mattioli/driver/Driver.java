package by.mattioli.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static final Logger logger = LogManager.getLogger();
    private static WebDriver driver;

    private Driver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
           // ChromeOptions options = new ChromeOptions();
           // options.addArguments("--headless=new"); // Без этого в Jenkins упадет
           // options.addArguments("--window-size=1920,1080");
          //  options.addArguments("--no-sandbox");
          //  options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            logger.info("Создали хром-драйвер");
        }
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
