package by.mattioli.api;


import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginService {
    private String LOGIN_URL = "https://mattioli.by/";

    private Response response;
    private static final Logger logger = LogManager.getLogger();

    private String dynamicSessionId;
    private Map<String, String> cookies = new HashMap<>();

    public void initSession() {
        Response mainPage = given()
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                .when()
                .get(LOGIN_URL);

        this.cookies = mainPage.getCookies();
        String html = mainPage.asString();
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("bitrix_sessid['\"]?\\s*[:=]\\s*['\"](\\w+)['\"]").matcher(html);

        if (m.find()) {
            this.dynamicSessionId = m.group(1);
        }
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("bx-ajax", "true");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        logger.info("Request headers: {}", headers);
        return headers;
    }

    private Map<String, String> getBody(String email, String password) {
        Map<String, String> bodies = new HashMap<>();
        bodies.put("siteId", "s2");
        bodies.put("template", ".default.8167ef757323394b608007b19866c118793aa8db38cd423b325c5f9f4ba1dd50");
        bodies.put("parameters", "YToxOntzOjEwOiJDQUNIRV9UWVBFIjtzOjE6IkEiO30=.4dd79a9a154ad96a6660c8d778bb914834939bcef6d919567a81e5763fb5a5e4");
        bodies.put("rand", "uB8qD7");
        bodies.put("confirmType", "1");
        bodies.put("confirmValue", "");
        bodies.put("actionType", "AUTH");
        bodies.put("sessid", dynamicSessionId);
        bodies.put("method", "authByPassword");
        bodies.put("ple", email);
        bodies.put("password", password);
        logger.info("Request body prepared (user: {})", email);
        return bodies;
    }

    public void doRequest(String ple, String password) {
        logger.info("Выполнение post запроса");
        response = given()
                .cookies(this.cookies)
                .baseUri(LOGIN_URL)
                .headers(getHeaders())
                .formParams(getBody(ple, password))
                .log()
                .all()
                .when()
                .post("/bitrix/components/bxmaker/authuserphone.enter/ajax.php");
    }

    public int getStatusCode() {
        int statusCode = response.getStatusCode();
        logger.info("Статус-код сервера: {}", statusCode);
        return statusCode;
    }

    public String getResponseMessage() {
        String message = response.jsonPath().getString("error.msg");
        logger.info("Сообщение об ошибке: " + message);
        return message;
    }
}
