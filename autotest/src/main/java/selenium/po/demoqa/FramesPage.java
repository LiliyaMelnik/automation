package selenium.po.demoqa;

import selenium.base.methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static selenium.base.driver.DriverInit.getDriver;

public class FramesPage extends BaseMethods{

    private static final By frame = By.xpath("//iframe[@id='frame1']");
    private static final By sampleHeading = By.xpath("//h1[@id='sampleHeading']");
    private static final By framesWrapper = By.xpath("//div[@id='framesWrapper']/div");

    public FramesPage(){
        getDriver().get("https://demoqa.com/frames");
    }
    public FramesPage enterFrame() {
        WebElement a = waiter(frame);
        getDriver().switchTo().frame(a);
        return this;
    }
    public String getFrameText() {
        return getText(sampleHeading);
    }
    public FramesPage exitFrame() {
        getDriver().switchTo().defaultContent();
        return this;
    }
    public String getWrapperText() {
        return getText(framesWrapper);
    }
}
