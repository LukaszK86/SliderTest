import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class TestCase {

    public static WebDriver driver;

    public static void takesScreenshot(WebDriver driver, String fileWithPath) throws Exception {
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(fileWithPath);
        org.apache.commons.io.FileUtils.copyFile(sourceFile, destinationFile);
    }

    public static void analyzeLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }

    @BeforeClass
    public static void beforeTest() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://192.168.8.100:5556/wd/hub"), capabilities);
    }

    @AfterClass
    public static void afterTest() throws Exception {
        takesScreenshot(driver, "C:\\Users\\Kuki\\Documents\\Programowanie\\Test\\Test.bmp");
        analyzeLog();
        driver.quit();
    }
}
