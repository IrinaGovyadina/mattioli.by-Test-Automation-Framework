package by.mattioli.testAPI;

import by.mattioli.api.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTestAPI {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testSearch() {
        SearchService searchService = new SearchService();
        logger.info("Выполняется поиск по запросу:'015'");
        searchService.doRequest("015");

        assertAll("Search",
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getBody().contains("015"))
        );
        logger.info("Тест поиска успешно завершен");
    }
}
