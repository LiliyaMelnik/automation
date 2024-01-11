package ui.selenide;

import org.testng.annotations.Test;
import ui.selenide.po.ArticlePage;
import ui.selenide.po.LoginPage;
import ui.selenide.po.SearchPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static ui.selenide.controllers.UserController.getUserCredentials;

public class WikiTest extends BaseTest {

    @Test
    void shouldBeOpenedArticle() {
        new SearchPage()
                .searchUbisoftArticle("Ubisoft")
                .clickEnter()
                .clickOnUbisoftArticle();

        assertThat(new ArticlePage().getHeadingOfArticle()).as("The text must be Ubisoft").isEqualTo("Ubisoft");
    }

    @Test
    void shouldBeAuth() {
        new LoginPage()
                .clickLogin()
                .auth(getUserCredentials());
    }
}
