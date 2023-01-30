import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTest {
    private final Setup setup = new Setup();
    public WebDriver driver;
    JavascriptExecutor js;
    @BeforeMethod
    public void SetupTest(){
        driver = setup.SetupDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor)driver;
        driver.navigate().to(setup.testURL);
        WebElement searchTextBox = driver.findElement(By.id("artikl"));
        searchTextBox.sendKeys("ryzen 5 5600x");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchform\"]/button"));
        searchButton.click();
    }


    @Test(priority = 1)
    public void FavoriteItem() throws InterruptedException {
        Thread.sleep(2000);
        WebElement favoriteCheckBox = driver.findElement(By.id("fav_136923"));
        js.executeScript("arguments[0].click();", favoriteCheckBox);
        Thread.sleep(8000);
        WebElement heartCountText = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div/div[4]/div[3]/a/i/span"));
        Assert.assertEquals(heartCountText.getText(), "1");
    }
    @Test(priority = 2)
    public void CompareItem() throws InterruptedException {
        WebElement compareCheckBox = driver.findElement(By.id("com_136923"));
        js.executeScript("arguments[0].click();", compareCheckBox);
        Thread.sleep(8000);
        WebElement compareCountText = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div/div[4]/div[2]/a/i/span"));
        Assert.assertEquals(compareCountText.getText(), "1");
    }
    @Test(priority = 3)
    public void AddItemToCart() throws InterruptedException {
        WebElement addCartBox = driver.findElement(By.xpath("//*[@id=\"item_136923\"]/div/div[3]/ul/li[3]/a/i"));
        js.executeScript("arguments[0].click();", addCartBox);
        Thread.sleep(3000);
        WebElement continueShoppingBox = driver.findElement(By.xpath("//*[@id=\"product-page\"]/div/div[5]/div/div[1]/a"));
        continueShoppingBox.click();
        Thread.sleep(3000);
        WebElement compareCountText = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div/div[4]/div[1]/div/div/a/i/span"));
        Assert.assertEquals(compareCountText.getText(), "1");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
