import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import sun.security.util.FilePaths;
import sun.security.util.Password;

//@BeforeMethod
public class login {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shampriya\\Downloads\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");}

        public void login() throws Exception {

            String excelFilePath = "C:\\Users\\shampriya\\Documents\\logindata.xlsx";
            FileInputStream fi = new FileInputStream(excelFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fi);
            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow row = null;
            XSSFCell cell = null;
            String Username = null;
            String password = null;

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    cell = row.getCell(j);
                    if (j == 0) {
                        Username = cell.getStringCellValue();
                    }
                    if (j == 1) {
                        password = cell.getStringCellValue();
                    }
                }
                System.out.println(("Read data from excel sheet"));
                WebDriver driver = null;
                driver.findElement(By.id("Username")).sendKeys(Username);
                driver.findElement(By.id("Password")).sendKeys(password);
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
                Thread.sleep(1000);
                String result = null;

                String actualUrl = driver.getCurrentUrl();
                Boolean isLoggedIn = actualUrl.equals("https://www.saucedemo.com/");

                if (isLoggedIn == true) {
                    result = "Login Successful";
                    System.out.println(result);
                } else {
                    result = "Login Failed";
                    System.out.println(result);
                }
            }


        }
    }


