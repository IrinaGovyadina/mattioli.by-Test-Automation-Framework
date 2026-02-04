package by.mattioli.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class LoginServise {
    private String urlLoginService = "https://mattioli.by/bitrix/components/bxmaker/authuserphone.enter/ajax.php";

    private Response response;

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("bx-ajax", "true");
        headers.put("content-type", "application/x-www-form-urlencoded");
        headers.put("Cookie", "WW_BX_USER_ID=bx256d2ecfa939b0b76e302e9f28bc31fa; _fbp=fb.1.1769109088728.418169643657370932; _ym_uid=1769109089346508556; _ym_d=1769109089; _tt_enable_cookie=1; _ttp=01KFKHWTNN0M6MQ73MMAE6699N_.tt.1; youWatched=1; BITRIX_SM_BXMAKER_AUP_GID2=1022191; _gid=GA1.2.587155630.1770111875; isCookieNotificationShowed=1; PHPSESSID=cdEBx4sYUSqNYvGX1RBnuAsdAs4hd0OP; BITRIX_SM_SLAM_FAVORITE_USER_HASH=f31b5a9a67c47356c28aae3ff41cd01e; _ym_isad=2; _ym_visorc=w; _gat_UA-158602549-1=1; _gat_%5Bobject%20Object%5D=1; _ga_55BPZB801L=GS2.1.s1770190305$o31$g1$t1770190445$j55$l0$h0; _ga=GA1.2.1514051046.1769109089; ttcsid_CROJD1JC77U5KN4TA510=1770190306159::j4ynSX_cnyEJfVXJIACn.29.1770190474279.1; ttcsid=1770190306160::JCc6fQz9huH5IwBVsGsY.29.1770190474279.0::1.139177.139649::168098.12.804.329::0.0.0");
        return headers;
    }

    private Map<String, String> getBody(String ple, String password) {
        Map<String, String> bodies = new HashMap<>();
        bodies.put("siteId", "s2");
        bodies.put("template", ".default.8167ef757323394b608007b19866c118793aa8db38cd423b325c5f9f4ba1dd50");
        bodies.put("parameters", "YToxOntzOjEwOiJDQUNIRV9UWVBFIjtzOjE6IkEiO30=.4dd79a9a154ad96a6660c8d778bb914834939bcef6d919567a81e5763fb5a5e4");
        bodies.put("rand", "uB8qD7");
        bodies.put("confirmType", "1");
        bodies.put("confirmValue", "");
        bodies.put("actionType", "AUTH");
        bodies.put("sessid", "f5b998104bef50cf9b876b778f7b56a1");
        bodies.put("method", "authByPassword");
        bodies.put("ple", "test@test.com");
        bodies.put("password", "123456+");
        return bodies;
    }

    public void doRequest() {
        doRequest("test@test.com", "123456+");
    }

    public void doRequest(String ple, String password) {
        response = given()
                .baseUri("https://mattioli.by/")
                .headers(getHeaders())
                .formParams(getBody(ple, password))
                .when()
                .post(urlLoginService);
    }

    public void printResponse() {
        response.then()
                .log().all();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseMessage() {
        return response.body().jsonPath().getString("error.msg");
    }
}
