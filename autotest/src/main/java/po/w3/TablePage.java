package po.w3;

import base.methods.BaseMethods;
import base.table.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static base.driver.DriverInit.getDriver;

public class TablePage extends BaseMethods {
    private final By table = By.xpath("//table[@class='ws-table-all']");
    private final By acceptBut = By.xpath("//div[@id='accept-choices']");
    public String tableValue(int rowIndex, int columnIndex) {
        WebElement elementTable = getDriver().findElement(table);
        return new Table(elementTable).getValue(rowIndex, columnIndex);
    }
    public TablePage clickAccept() {
        click(acceptBut);
        return this;
    }

}
