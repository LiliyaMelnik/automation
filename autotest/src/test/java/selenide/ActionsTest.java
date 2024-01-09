package selenide;

import org.testng.annotations.Test;
import selenide.po.demoqa.ButtonsPage;
import selenide.po.demoqa.UploadDownloadPage;


import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class ActionsTest extends BaseTest {

    @Test
    void contextAndClickTest() {
        open("https://demoqa.com/buttons");

        ButtonsPage btnPage = new ButtonsPage();

        String rightClickText = btnPage
                .rightCl()
                .afterRightClText();
        assertThat(rightClickText)
                .as("The text must be")
                .isEqualTo("You have done a right click");

        String doubleClickText = btnPage
                .doubleCl()
                .afterDoubleClText();
        assertThat(doubleClickText)
                .as("The text must be")
                .isEqualTo("You have done a double click");
    }

    @Test
    void uploadFile() {
        open("https://demoqa.com/upload-download");

        UploadDownloadPage udPage = new UploadDownloadPage();
        String uploadText = udPage
                .clickButton()
                .getText();

        assertThat(uploadText)
                .as("The text must be")
                .isEqualTo("C:\\fakepath\\" + UploadDownloadPage.file);
    }
}
