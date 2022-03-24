import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
public class Dragdrop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shampriya\\Downloads\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String URL = "https://jqueryui.com/droppable/";
        driver.get(URL);
        Actions builder = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement source= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destination=driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,destination).build().perform();
    }
}
