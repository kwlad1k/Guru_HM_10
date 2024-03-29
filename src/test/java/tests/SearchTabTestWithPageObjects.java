package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CryptocurrenciesPage;

public class SearchTabTestWithPageObjects extends TestBase {
    CryptocurrenciesPage cryptocurrenciesPage = new CryptocurrenciesPage();

    @Test
    @DisplayName("Проверка успешного поиска через поиск таба по названию")
    void searchResultShouldContainTab() {
        cryptocurrenciesPage.openPage()
                .clickTabLibraryButton()
                .clickTrendingButton()
                .searchTab("Bullish assets")
                .checkResultSearch("Bullish assets")
                .checkUserNameOwner("bruce");
    }
}
