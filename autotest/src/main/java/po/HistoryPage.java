package po;

import base.mathods.BaseMethods;
import org.openqa.selenium.By;

public class HistoryPage extends BaseMethods {

    private static final By firstHeadingHistory = By.xpath("//h1[@id='firstHeading']");
    private static final By historyButton = By.xpath("//li[@id='ca-history']");

    public HistoryPage clickOnHistory() {
        click(historyButton);
        return this;
    }
    public String getHeadingOfHistory() {
        return getText(firstHeadingHistory);
    }
}
