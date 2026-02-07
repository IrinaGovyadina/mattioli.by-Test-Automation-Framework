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
        headers.put("Cookie", "WW_BX_USER_ID=bx256d2ecfa939b0b76e302e9f28bc31fa; _fbp=fb.1.1769109088728.418169643657370932; _ym_uid=1769109089346508556; _ym_d=1769109089; _tt_enable_cookie=1; _ttp=01KFKHWTNN0M6MQ73MMAE6699N_.tt.1; BITRIX_SM_BXMAKER_AUP_GID2=1062728; _gid=GA1.2.686672710.1770402945; _ym_isad=2; isHeaderNotificationShowed=1; isCookieNotificationShowed=1; PHPSESSID=9sPMfrtc5BTyImsPW56D3nPptSHZTYzK; BITRIX_SM_SLAM_FAVORITE_USER_HASH=5f4b3e3c1dc30ce45a167ae3c796b649; _ym_visorc=w; youWatched=1; _gat_UA-158602549-1=1; _gat_%5Bobject%20Object%5D=1; _ga_55BPZB801L=GS2.1.s1770459947$o38$g1$t1770460837$j57$l0$h0; _ga=GA1.2.1514051046.1769109089; ttcsid_CROJD1JC77U5KN4TA510=1770459947953::HwQaiWENpB8PFJYLNfox.34.1770460853302.1; ttcsid=1770459947953::Hb0ig63cEMbRGEPT1Epi.34.1770460853303.0");
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
        bodies.put("sessid", "a8482d96025903059cb82cb34e218c05");
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
