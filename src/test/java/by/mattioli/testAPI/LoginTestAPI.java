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

        assertAll("Login",
                () -> assertEquals(200, loginServise.getStatusCode()),
                () -> assertEquals("Неверно указан телефон, логин, email или пароль", loginServise.getResponseMessage())
        );

    }
}
