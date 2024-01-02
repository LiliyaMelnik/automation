import org.testng.annotations.Test;
import po.demoqa.AlertsPage;
import po.demoqa.ButtonsPage;
import po.demoqa.DroppablePage;
import po.demoqa.FramesPage;
import po.demoqa.UploadDownloadPage;
import po.w3.TablePage;

import static base.driver.DriverInit.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class ActionsTest extends BaseTest {

    @Test
    void frameTestInside() {
        FramesPage frp = new FramesPage();

        String frameText = frp
                .enterFrame()
                .getFrameText();
        assertThat(frameText)
                .as("The text must be")
                .isEqualTo("This is a sample page");

        String outsideFrameT = frp
                .exitFrame()
                .getWrapperText();
        assertThat(outsideFrameT)
                .as("The text must be")
                .isEqualTo("Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below");
    }
    @Test
    void submitAlerts() {
        AlertsPage alp = new AlertsPage();
        String butText = alp
                .clickButton()
                .acceptAlert()
                .buttonText();
        assertThat(butText)
                .as("The text must be")
                .isEqualTo("Click me");
    }
    @Test
    void dragAndDropTest() {
        DroppablePage drp = new DroppablePage();
        String aftText = drp
                .dragAndDrop()
                .textAfterDr();
        assertThat(aftText)
                .as("The text must be")
                .isEqualTo("Dropped!");
    }
    @Test
    void contextAndClickTest() {
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
        UploadDownloadPage udPage = new UploadDownloadPage();
        String uploadText = udPage
                .clickButton()
                .getText();
        assertThat(uploadText)
                .as("The text must be")
                .isEqualTo("C:\\fakepath\\" + UploadDownloadPage.file);
    }
    @Test
    void getTableColumns() {
        getDriver().get("https://www.w3schools.com/html/html_tables.asp");
        String text = new TablePage().clickAccept().tableValue(3,3);
        assertThat(text)
                .as("The text must be")
                .isEqualTo("Austria");
    }
}
