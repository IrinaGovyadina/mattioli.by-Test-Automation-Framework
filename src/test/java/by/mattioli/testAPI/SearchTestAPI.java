package by.mattioli.testAPI;

import by.mattioli.api.SearchService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTestAPI {

    @Test
    public void testSearchBar() {
        SearchService searchService = new SearchService();
        String query = "015";

        searchService.doRequest(query);

        assertAll("Search",
                () -> assertEquals(200, searchService.getStatusCode()),
                () -> assertTrue(searchService.getFoundCount() > 0)
        );
    }
}
