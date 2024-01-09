package selenium.po.demoqa;

import selenium.base.methods.BaseMethods;
import org.openqa.selenium.By;
import selenium.base.driver.DriverInit;

public class AlertsPage extends BaseMethods {
    private static final By alertButton = By.xpath("//button[@id='alertButton']");
    public AlertsPage() {
        DriverInit.getDriver().get("https://demoqa.com/alerts");
    }
    public AlertsPage clickButton() {
        click(alertButton);
        return this;
    }
    public AlertsPage acceptAlert() {
        DriverInit.getDriver().switchTo().alert().accept();
        return this;
    }
    public String buttonText() {
        return getText(alertButton);
    }
}
