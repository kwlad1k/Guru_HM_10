package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CryptocurrenciesPage {

    private SelenideElement tabLibraryButton = $("[aria-label='Open Tab Library dialog']");

    public CryptocurrenciesPage openPage() {
        open("");
        return this;
    }

    public CryptocurrenciesPage clickTabLibraryButton() {
        tabLibraryButton.cached().click();;
        $("[aria-modal='true']").shouldBe(visible);
        return this;
    }

    public CryptocurrenciesPage clickTrendingButton() {
        $("[data-screen='library-trending'").cached().click();
        return this;
    }

    public CryptocurrenciesPage searchTab(String searchQuery) {
        $("[placeholder='Search for Tab...']").setValue(searchQuery);
        return this;
    }

    public CryptocurrenciesPage checkResultSearch(String searchQuery) {
        $("[role='dialog'] ul li").shouldHave(text(searchQuery));
        return this;
    }

    public CryptocurrenciesPage CheckUserNameOwner(String userName) {
        $("[role='dialog'] ul li").shouldHave(text(userName));
        return this;
    }

}
