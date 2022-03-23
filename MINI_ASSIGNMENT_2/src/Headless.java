import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shampriya\\Downloads\\chromedriver.exe");
        WebDriver driver;
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver(options);
        String url="https://phptravels.com/demo";
        driver.get(url);
        System.out.println("Page is opened in HEADLESS_MODE");
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        String a = driver.getTitle();
        if (driver.getTitle().contains("PHPTRAVELS"))
            System.out.println("PASS");
        else
            System.out.println("FAIL");
        driver.navigate().to("https://phptravels.org/login");
        String Actual = driver.getTitle();
        String Expctd = "Login";
        if(Actual.equals(Expctd))
            System.out.println("PASS");
        else
            System.out.println("FAIL");
        driver.findElement(By.linkText("Pricing")).click();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.close();
        System.out.println(a);

    }
}
