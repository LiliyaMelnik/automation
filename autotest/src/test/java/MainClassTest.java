import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClassTest {
    private static final By acceptButton = By.id("L2AGLb");
    private static final By searchInput = By.id("APjFqb");
    private static final By article = By.xpath("//a[@class='a-no-hover-decoration GCkZZe']");
    private static final By firstHeading = By.xpath("//span[@class='VlHyHc'][text()='забавные котики']");
    private WebDriver driver = null;

    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }
    @Test
    void shouldBeCatArticleEnter() {
        waiter(driver, acceptButton).click();
        waiter(driver, searchInput).sendKeys("котики");
        waiter(driver, searchInput).sendKeys(Keys.ENTER);
        waiter(driver, article).click();

        String text = waiter(driver, firstHeading).getText();
        Assert.assertEquals(text, "забавные котики");

        System.out.println(text);
    }
    @AfterMethod
    void quit() {
        driver.quit();
    }
    public static WebElement waiter(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
