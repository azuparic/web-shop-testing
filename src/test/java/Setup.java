import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;


public class Setup {
    public String testURL = "https://www.futura-it.hr/";
    public String browser = "Chrome";

    public WebDriver SetupDriver() { //default browser is Google Chrome
        if(browser.equals("Edge")){
            System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
            return new EdgeDriver();
        }
        else if( browser.equals("Opera")){
            System.setProperty("webdriver.chrome.driver", "operadriver.exe");
            return new OperaDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            return new ChromeDriver();
        }

    }
}
