package po.demoqa;

import base.methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static base.driver.DriverInit.getDriver;

public class ButtonsPage extends BaseMethods {
    private static final By rightClickBtn = By.xpath("//button[@id='rightClickBtn']");
    private static final By doubleClickBtn = By.xpath("//button[@id='doubleClickBtn']");
    private static final By rightClickText = By.xpath("//p[@id='rightClickMessage']");
    private static final By doubleClickText = By.xpath("//p[@id='doubleClickMessage']");
    public ButtonsPage() {
        getDriver().get("https://demoqa.com/buttons");
    }
    public ButtonsPage rightCl() {
        WebElement b = waiter(rightClickBtn);
        new Actions(getDriver())
                .contextClick(b)
                .build().perform();
        return this;
    }
    public ButtonsPage doubleCl() {
        WebElement c = waiter(doubleClickBtn);
        new Actions(getDriver())
                .doubleClick(c)
                .build().perform();
        return this;
    }
    public String afterRightClText() {
        return getText(rightClickText);
    }
    public String afterDoubleClText() {
        return getText(doubleClickText);
    }
}

