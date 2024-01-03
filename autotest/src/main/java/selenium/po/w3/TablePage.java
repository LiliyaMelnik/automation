package selenium.po.w3;

import selenium.base.methods.BaseMethods;
import selenium.base.table.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.base.driver.DriverInit;

public class TablePage extends BaseMethods {
    private final By table = By.xpath("//table[@class='ws-table-all']");
    private final By acceptBut = By.xpath("//div[@id='accept-choices']");
    public String tableValue(int rowIndex, int columnIndex) {
        WebElement elementTable = DriverInit.getDriver().findElement(table);
        return new Table(elementTable).getValue(rowIndex, columnIndex);
    }
    public TablePage clickAccept() {
        click(acceptBut);
        return this;
    }

}
