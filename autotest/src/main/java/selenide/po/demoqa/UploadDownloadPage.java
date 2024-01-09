package selenide.po.demoqa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class UploadDownloadPage {
    private static final SelenideElement uploadButton = $x("//input[@id='uploadFile']");
    private static final SelenideElement uploadText = $x("//p[@id='uploadedFilePath']");
    public static final String file = "file";
    public UploadDownloadPage clickButton() {
        uploadButton.shouldBe(visible).sendKeys("/Users/liliyamelnikova/Desktop/automation/autotest/src/file");
        return page(UploadDownloadPage.class);
    }
    public String getText() {
        return uploadText.shouldBe(visible).getText();
    }
}
