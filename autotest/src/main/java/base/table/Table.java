package base.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    WebElement elementTable;
    public Table(WebElement elementTable) {
        this.elementTable = elementTable;
    }
    public List<WebElement> getRows() {
        return elementTable.findElements(By.xpath(".//tbody/tr"));
    }
    public List<List<WebElement>> getRowsAndColumns() {
        List<WebElement> rows = getRows();
        rows.remove(0);
        List<List<WebElement>> rowsAndColumns = new ArrayList<>();
        for (WebElement row: rows) {
            List<WebElement> rowWithColumn = row.findElements(By.xpath(".//td"));
            rowsAndColumns.add(rowWithColumn);
        }
        return rowsAndColumns;
    }
    public String getValue(int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsWithColumns = getRowsAndColumns();
        return rowsWithColumns.get(rowNumber -1).get(columnNumber -1).getText();
    }
}
