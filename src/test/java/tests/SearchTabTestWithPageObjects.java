package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CryptocurrenciesPage;

public class SearchTabTestWithPageObjects extends TestBase {
    CryptocurrenciesPage cryptocurrenciesPage = new CryptocurrenciesPage();

    @Test
    @DisplayName("Проверка успешного поиска таба по названию через поиск")
    void searchResultShouldContainTab() {
        cryptocurrenciesPage.openPage()
                .clickTabLibraryButton()
                .clickTrendingButton()
                .searchTab()
                .checkResultSearch();
    }
}
