package by.mattioli.api;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SearchService {
    private final String SEARCH_URL = "https://mattioli.by/bitrix/services/main/ajax.php";

    private static final Logger logger = LogManager.getLogger();

    private Response response;

    private Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("c", "slam:search.elastic");
        queryParams.put("action", "ajaxSearch");
        queryParams.put("mode", "class");
        logger.info("Подготовка параметров HTTP-запроса");
        return queryParams;
    }

    private Map<String, String> getParams(String query) {
        Map<String, String> params = new HashMap<>();
        params.put("query", query);
        params.put("signedParameters", "YToxNjp7czoxNToiU0VBUkNIX0lOREVYX0lEIjtpOjA7czoxODoiU0VBUkNIX01BWF9FTEVNRU5UIjtzOjQ6IjEwMDAiO3M6MTk6IkRJU1BMQVlfTUFYX0VMRU1FTlQiO3M6MjoiMTAiO3M6MjA6IkRJU1BMQVlfTUFYX1NFQ1RJT05TIjtzOjI6IjEwIjtzOjE1OiJESVNQTEFZX01BWF9UQUIiO3M6MjoiMTUiO3M6MTE6IkFDVElPTl9QQUdFIjtzOjE2OiIvY2F0YWxvZy9zZWFyY2gvIjtzOjE4OiJDT01QT05FTlRfVEVNUExBVEUiO3M6NjoiaGVhZGVyIjtzOjEyOiJTSE9XX1BPUFVMQVIiO3M6MToiTiI7czoxOToiUkVTSVpFX0lNQUdFU19XSURUSCI7czoyOiI3MCI7czoyMDoiUkVTSVpFX0lNQUdFU19IRUlHSFQiO3M6MjoiNzAiO3M6MTg6IlJFU0laRV9JTUFHRVNfVFlQRSI7czoyMToiQlhfUkVTSVpFX0lNQUdFX0VYQUNUIjtzOjE2OiJDT0xVTU5TX0xJU1RfRVhUIjthOjQ6e2k6MDtzOjE1OiJQUk9QRVJUWV9TVEFUVVMiO2k6MTtzOjE0OiJQUk9QRVJUWV9MQUJFTCI7aToyO3M6MTY6IlBST1BFUlRZX0NPTVBBTlkiO2k6MztzOjIwOiJQUk9QRVJUWV9NT1JFX1BIT1RPUyI7fXM6MTI6IkdFVF9RVUFOVElUWSI7czoxOiJZIjtzOjEwOiJHRVRfQU1PVU5UIjtzOjE6Ik4iO3M6MjA6IkFERElUSU9OQUxfUElDVF9QUk9QIjtzOjExOiJNT1JFX1BIT1RPUyI7czo5OiJJQkxPQ0tfSUQiO2k6MjA7fQ==.60f409dbcb7a4a0f4246d59862ea3dd6626af42d2a37c194e40be5f1e40253d3");
        logger.info("Подготовка данных для поиска артикула: {}", query);
        return params;
    }

    public void doRequest(String query) {
        logger.info("Отправка POST-запроса на поиск артикула: {}", query);
        response = given()
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36")
                .header("x-requested-with", "XMLHttpRequest")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .queryParams(getQueryParams())
                .formParams(getParams(query))
                .log()
                .all()
                .when()
                .post(SEARCH_URL);
    }

    public int getStatusCode() {
        int statusCode = response.then().extract().statusCode();
        logger.info("Статус-код сервера: {}", statusCode);
        return statusCode;
    }

    public int getFoundCount() {
        Object count = response.jsonPath().get("data.COUNT");
        logger.info("Насчитали в ответе: {}", count);
        return (count != null) ? Integer.parseInt(count.toString()) : 0;
    }
}
