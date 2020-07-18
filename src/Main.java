import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        //WebDriver driver = new FirefoxDriver();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("window-size=1200x600");
        //WebDriver driver = new ChromeDriver(options);

        HtmlUnitDriver driver = new HtmlUnitDriver(true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //WebDriver driver = new HtmlUnitDriver();
        //WebDriverWait wait = new WebDriverWait(driver, 10000);

        try {

           driver.get("http://checkip.dyndns.com");
            //http://62.33.203.46/asoz/index.htm
            //http://checkip.dyndns.com
            String ipstring = driver.findElement( By.cssSelector("html body") ).getText();
            WebElement element = driver.findElement(By.name("UserName"));
           // element.sendKeys(MagMonRec);
           // WebElement element = driver.findElement(By.name("UserName"));
            System.out.println( "Debug: " + ipstring ); // just a debug statement to print out result

            //driver.get("https://google.com");
            //WebElement el = driver.findElement(By.name("q"));
            //el.sendKeys("Selenium Java");
            //el.sendKeys(Keys.ENTER);
            //List<WebElement> listEl = driver.findElements(By.xpath("//div[@class='g']//h3/a"));

            //for(WebElement a: listEl)
            //    System.out.println(a.getAttribute("textContent"));
            //driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
          //  WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
           // System.out.println(firstResult.getAttribute("textContent"));
        } finally {
            driver.quit();
        }
    }
}
