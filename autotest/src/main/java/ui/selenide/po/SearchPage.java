package ui.selenide.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    public SelenideElement searchInput() {
        return $(".vector-search-box-input");
    }

    public SelenideElement article() {
        return $x("//div[@class='mw-search-result-heading']/a[@data-prefixedtext='Ubisoft']");
    }

    public SearchPage searchUbisoftArticle(String text) {
        searchInput().shouldBe(visible).sendKeys(text);
        return page(SearchPage.class);
    }

    public SearchPage clickEnter() {
        searchInput().shouldBe(visible).sendKeys(Keys.ENTER);
        return page(SearchPage.class);
    }

    public void clickOnUbisoftArticle() {
        article().shouldBe(visible, enabled).click();
    }
}
