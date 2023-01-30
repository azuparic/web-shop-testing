import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
    private final Setup setup = new Setup();
    public WebDriver driver;
    @BeforeMethod
    public void SetupTest(){
        driver = setup.SetupDriver();
        driver.navigate().to(setup.testURL);
        driver.manage().window().maximize();
    }


    @Test(priority = 1)
    public void EmptySearch() throws InterruptedException {
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchform\"]/button"));
        searchButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), setup.testURL);
    }
    @Test(priority = 2)
    public void RandomTextSearch() throws InterruptedException {
        WebElement searchTextBox = driver.findElement(By.id("artikl"));
        searchTextBox.sendKeys("asdfghjk12345");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchform\"]/button"));
        searchButton.click();
        Thread.sleep(2000);
        WebElement noResultTextBox = driver.findElement(By.xpath("//*[@id=\"product-list\"]/h2"));
        Assert.assertEquals(noResultTextBox.getText(), "NEMA NITI JEDAN ARTIKL ZA PRIKAZ");
    }
    @Test(priority = 3)
    public void ItemSearch() throws InterruptedException {
        WebElement searchTextBox = driver.findElement(By.id("artikl"));
        searchTextBox.sendKeys("ryzen 5 5600x");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchform\"]/button"));
        searchButton.click();
        Thread.sleep(2000);
        WebElement firstResultTextBox = driver.findElement(By.xpath("//*[@id=\"item_136923\"]/div/div[3]/h2/a/span"));
        Assert.assertEquals(firstResultTextBox.getText(), "CPU AMD Ryzen 5 5600X 100-100000065BOX");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
