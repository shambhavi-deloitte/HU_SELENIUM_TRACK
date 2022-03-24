import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class frame {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shampriya\\Downloads\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        By frames = By.xpath("//a[@href='/frames']");
        driver.findElement(frames).click();
        By Nestedframes = By.xpath("//a[text()='Nested Frames']");
        driver.findElement(Nestedframes).click();
    }
}
