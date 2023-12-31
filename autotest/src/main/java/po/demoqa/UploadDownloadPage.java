package po.demoqa;

import base.methods.BaseMethods;
import org.openqa.selenium.By;

import static base.driver.DriverInit.getDriver;

public class UploadDownloadPage extends BaseMethods {
    private static final By uploadButton = By.xpath("//input[@id='uploadFile']");
    private static final By uploadText = By.xpath("//p[@id='uploadedFilePath']");
    public static final String file = "file";
    public UploadDownloadPage() {
        getDriver().get("https://demoqa.com/upload-download");
    }
    public UploadDownloadPage clickButton() {
        send(uploadButton, "/Users/liliyamelnikova/Desktop/automation/autotest/src/file");
        return this;
    }
    public String getText() {
        return getText(uploadText);
    }
}
