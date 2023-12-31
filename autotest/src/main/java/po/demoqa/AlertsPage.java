package po.demoqa;

import base.methods.BaseMethods;
import org.openqa.selenium.By;

import static base.driver.DriverInit.getDriver;

public class AlertsPage extends BaseMethods {
    private static final By alertButton = By.xpath("//button[@id='alertButton']");
    public AlertsPage() {
        getDriver().get("https://demoqa.com/alerts");
    }
    public AlertsPage clickButton() {
        click(alertButton);
        return this;
    }
    public AlertsPage acceptAlert() {
        getDriver().switchTo().alert().accept();
        return this;
    }
    public String buttonText() {
        return getText(alertButton);
    }
}
