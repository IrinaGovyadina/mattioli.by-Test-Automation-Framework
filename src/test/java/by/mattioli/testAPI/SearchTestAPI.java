package by.mattioli.testAPI;

import by.mattioli.api.SearchService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTestAPI {

    @Test
    public void testSearch() {
        SearchService searchService = new SearchService();
        searchService.doRequest();

        assertAll("Search",
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getBody().contains("015"), "Найдено 5 товаров")
        );
    }
}
