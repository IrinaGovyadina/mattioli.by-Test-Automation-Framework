package by.mattioli.pages.login;

import by.mattioli.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = Driver.getDriver();
    }

    public void clickOnLoginWithPassword() {
        driver.findElement(LoginLocator.LOGIN_USING_PASSWORD).click();
    }

    public void inputEmail(String email) {
        driver.findElement(LoginLocator.EMAIL_PATH).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(LoginLocator.PASSWORD_PATH).sendKeys(password);
    }

    public void putButtonEnter() {
        driver.findElement(LoginLocator.BUTTON_ENTER_PATH).click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.ERROR_MESSAGE_PATH));
        return element.getText();
    }
}
