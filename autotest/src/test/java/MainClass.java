import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Task1
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("L2AGLb")).click(); // accept all
        driver.findElement(By.id("APjFqb")).sendKeys("котики");
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Task2
        driver.get("https://ru.wikipedia.org/wiki");
        driver.findElement(By.xpath("//li[@id='ca-view']/following-sibling::li[1]"));
        driver.findElement(By.xpath("//span[text()='Войти']/ancestor::li"));
        driver.findElement(By.xpath("//li[@class='main-top-createArticle']"));
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
