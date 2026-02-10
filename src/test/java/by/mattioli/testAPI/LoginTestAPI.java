package by.mattioli.testAPI;

import by.mattioli.api.LoginService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTestAPI {


    @Test
    public void testLoginForm() {
        LoginService loginServise = new LoginService();
        String email = "test@test.com";
        String password = "123456+";
        loginServise.initSession();

        loginServise.doRequest(email, password);
        loginServise.getStatusCode();
        loginServise.getResponseMessage();

        assertAll("Login",
                () -> assertEquals(200, loginServise.getStatusCode()),
                () -> assertTrue(loginServise.getResponseMessage().contains("Неверно указан"), "Текст ошибки на странице логина не совпал с ожидаемым: " + loginServise.getResponseMessage())
        );

    }
}
