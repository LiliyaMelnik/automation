package po;

import base.mathods.BaseMethods;
import org.openqa.selenium.By;

public class ArticlePage extends BaseMethods {

    private static final By firstHeading = By.xpath("//h1[@id='firstHeading']/span");

    public String getHeadingOfArticle() {
        return getText(firstHeading);
    }
}
