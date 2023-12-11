import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DemoqaLoginTest {
    private static final By userInput = By.xpath("//input[@id='userName']");
    private static final By passwordInput = By.xpath("//input[@id='password']");
    private static final By loginButton = By.xpath("//button[@id='login']");
    private static final By userNameValue = By.xpath("//label[@id='userName-value']");
    private WebDriver driver = null;

    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
    }
    @Test(dataProvider = "user_provider")
    void shouldLogin(String username, String password) {
        waiter(driver, userInput).sendKeys(username);
        waiter(driver, passwordInput).sendKeys(password);
        waiter(driver, loginButton).sendKeys(Keys.ENTER);

        String resultusername = waiter(driver, userNameValue).getText();

        Assert.assertEquals(resultusername, username); // text of my valid user that i created before
    }
    @DataProvider(name = "user_provider")
    public Object[][] userProvider() {
        return new Object[][]{
                {"wrongUser", "wrongPassword"},
                {"", ""},
                {"liliyaqa", "123456Qa#"} //this is valid user
        };
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
