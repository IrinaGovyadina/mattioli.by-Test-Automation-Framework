package by.mattioli.testAPI;

import by.mattioli.api.LoginServise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestAPI {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testLogin() {
        LoginServise loginServise = new LoginServise();
        loginServise.doRequest("test@test.com", "123456+");
        loginServise.printResponse();

        assertAll("Login",
                () -> assertEquals(200, loginServise.getStatusCode()),
                () -> assertEquals("Неверно указан телефон, логин, email или пароль", loginServise.getResponseMessage())
        );
    logger.info("Тест авторизации успешно завершен");
    }
}
