package selenium.po.demoqa;

import selenium.base.methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static selenium.base.driver.DriverInit.getDriver;

public class DroppablePage extends BaseMethods {
    private static final By drag = By.xpath("//div[@id='draggable']");
    private static final By drop = By.xpath("//div[@id='droppable']");
    private static final By textAfter = By.xpath("//div[@id='droppable']/p");
    public DroppablePage() {
        getDriver().get("https://demoqa.com/droppable");
    }
    public DroppablePage dragAndDrop() {
        WebElement drg = waiter(drag);
        WebElement drp = waiter(drop);
        new Actions(getDriver())
                .dragAndDrop(drg, drp)
                .build().perform();
        return this;
    }
    public String textAfterDr() {
        return getText(textAfter);
    }
}
