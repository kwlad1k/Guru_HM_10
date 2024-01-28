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
        tabLibraryButton.click();
        $("[aria-modal='true']").shouldBe(visible);
        return this;
    }

    public CryptocurrenciesPage clickTrendingButton() {
        $("[data-screen='library-trending'").click();
        return this;
    }

    public CryptocurrenciesPage searchTab() {
        $("[placeholder='Search for Tab...']").setValue("Bullish assets");
        return this;
    }

    public CryptocurrenciesPage checkResultSearch() {
        $("[role='dialog'] ul li").shouldHave(text("Bullish assets"));
        return this;
    }
}
