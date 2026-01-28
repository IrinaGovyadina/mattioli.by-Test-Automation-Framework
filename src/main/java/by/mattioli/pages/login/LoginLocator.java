package by.mattioli.pages.login;

import org.openqa.selenium.By;

public class LoginLocator {

    public static final By LOGIN_USING_PASSWORD = By.xpath("//div[@class='bxmaker-authuserphone-enter-auth-form__by']/a[@href='#' and @class='bxmaker-authuserphone-link']");
    public static final By EMAIL_PATH = By.xpath("//div[@class='bxmaker-authuserphone-input__field']/ input[@type='text']");
    public static final By PASSWORD_PATH = By.xpath("//div[@class='bxmaker-authuserphone-input-password__field']/input[@type='password']");
    public static final By BUTTON_ENTER_PATH = By.xpath("//div[@class='bxmaker-authuserphone-button__title']");
    public static final By ERROR_MESSAGE_PATH = By.xpath("//div[@class='bxmaker-authuserphone-message bxmaker-authuserphone-message--error']");
}
