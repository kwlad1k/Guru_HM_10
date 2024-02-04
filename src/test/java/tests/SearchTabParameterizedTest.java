package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CryptocurrenciesPage;

import java.util.List;
import java.util.stream.Stream;

public class SearchTabParameterizedTest extends TestBase {
    CryptocurrenciesPage cryptocurrenciesPage = new CryptocurrenciesPage();

    @ValueSource(strings = {
            "Bullish assets", "Total Funds Raised"
    })
    @ParameterizedTest(name = "Проверка поиска {0} таба через библиотеку табов Trending")
    void searchResultsShouldHaveTab(String searchQuery) {
        cryptocurrenciesPage.openPage()
                .clickTabLibraryButton()
                .clickTrendingButton()
                .searchTab(searchQuery)
                .checkResultSearch(searchQuery);
    }

    @CsvFileSource(resources = "/testData/searchResultsShouldContainExpectedUserName.csv")
    @ParameterizedTest(name = "Проверка поисковго запроса таба с названием: {0} и именем владельца {1} через библиотеку табов Trending")
    void searchResultsShouldContainExpectedUserName(String searchQuery, String userName) {
        cryptocurrenciesPage.openPage()
                .clickTabLibraryButton()
                .clickTrendingButton()
                .searchTab(searchQuery)
                .checkResultSearch(searchQuery)
                .CheckUserNameOwner(userName);
    }

    static Stream<Arguments> searchResultsShouldContainExpectedUserName1() {
        return Stream.of(
                Arguments.of("Bullish assets", "bruce"),
                Arguments.of("Gems with Binance Liquidity", "willAchieve100")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка поисковго запроса таба с названием: {0} и именем владельца {1} через библиотеку табов Trending")
    void searchResultsShouldContainExpectedUserName1(String searchQuery, List<String> ownerUser) {
        cryptocurrenciesPage.openPage()
                .clickTabLibraryButton()
                .clickTrendingButton()
                .searchTab(searchQuery)
                .checkResultSearch(searchQuery)
                .checkResultSearch(String.valueOf(ownerUser));
    }
}


