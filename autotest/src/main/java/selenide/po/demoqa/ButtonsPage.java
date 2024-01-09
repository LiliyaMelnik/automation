package selenide.po.demoqa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ButtonsPage {
    private static final SelenideElement rightClickBtn = $x("//button[@id='rightClickBtn']");
    private static final SelenideElement doubleClickBtn = $x("//button[@id='doubleClickBtn']");
    private static final SelenideElement rightClickText = $x("//p[@id='rightClickMessage']");
    private static final SelenideElement doubleClickText = $x("//p[@id='doubleClickMessage']");

    public ButtonsPage rightCl() {
        rightClickBtn.shouldBe(visible).contextClick();
        return page(ButtonsPage.class);
    }
    public ButtonsPage doubleCl() {
        doubleClickBtn.shouldBe(visible).doubleClick();
        return page(ButtonsPage.class);
    }
    public String afterRightClText() {
        return rightClickText.shouldBe(visible).getText();
    }
    public String afterDoubleClText() {
        return doubleClickText.shouldBe(visible).getText();
    }
}

