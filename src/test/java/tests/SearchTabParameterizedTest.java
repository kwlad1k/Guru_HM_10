package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CryptocurrenciesPage;

public class SearchTabParameterizedTest extends TestBase {
    CryptocurrenciesPage cryptocurrenciesPage = new CryptocurrenciesPage();

    @ValueSource(strings = {
            "Bullish assets", "Total Funds Raised"
    })
    @ParameterizedTest(name = "Проверка поиска {0} таба через библиотеку табов Trending")
    void successfulSearchTabTest(String searchQuery) {
        cryptocurrenciesPage.openPage()
                .clickTabLibraryButton()
                .clickTrendingButton()
                .searchTab(searchQuery)
                .checkResultSearch(searchQuery);
    }

    @CsvSource(value = {
            "Bullish assets , bruce",
            "Gems with Binance Liquidity , willAchieve100"
    })
    @ParameterizedTest(name = "Проверка поиска {0} таба владельца {1} через библиотеку табов Trending")
    void successfulSearchTabTest1(String searchQuery, String userName) {
        cryptocurrenciesPage.openPage()
                .clickTabLibraryButton()
                .clickTrendingButton()
                .searchTab(searchQuery)
                .checkResultSearch(searchQuery)
                .CheckUserNameOwner(userName);
    }
}
