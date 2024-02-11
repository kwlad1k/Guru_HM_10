package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CryptocurrenciesPage {

    private final SelenideElement tabLibraryButton = $("[aria-label='Open Tab Library dialog']"),
    trendingButton = $("[data-screen='library-trending'"),
    searchTabInput = $("[placeholder='Search for Tab...']"),
    resultTabList = $("[role='dialog'] ul li");


    public CryptocurrenciesPage openPage() {
        open("");

        return this;
    }

    public CryptocurrenciesPage clickTabLibraryButton() {
        tabLibraryButton.shouldBe(Condition.interactable).click();

        return this;
    }

    public CryptocurrenciesPage clickTrendingButton() {
        trendingButton.click();

        return this;
    }

    public CryptocurrenciesPage searchTab(String searchQuery) {
        searchTabInput.setValue(searchQuery);

        return this;
    }

    public CryptocurrenciesPage checkResultSearch(String searchQuery) {
        resultTabList.shouldHave(text(searchQuery));

        return this;
    }

    public CryptocurrenciesPage checkUserNameOwner(String userName) {
        resultTabList.shouldHave(text(userName));

        return this;
    }

}
