import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class Alerts{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shampriya\\Downloads\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/javascript_alerts']")).click();
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        String expected = "You entered: Ex-Test";
        driver.switchTo().alert().sendKeys("Ex-Test");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String result =driver.findElement(By.xpath("//p[@id='result']")).getText();
        if (expected.equals(result))
            System.out.println("PASS");
        else
            System.out.println("FAIL");
    }
}
