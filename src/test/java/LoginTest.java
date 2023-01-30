import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTest {
    private final Setup setup = new Setup();
    public WebDriver driver;
    @BeforeMethod
    public void SetupTest(){
        driver = setup.SetupDriver();
        driver.navigate().to(setup.testURL);
        driver.manage().window().maximize();
        WebElement loginTextBox = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div/div[4]/div[4]/div/a[1]"));
        loginTextBox.click();
    }


    @Test(priority = 1)
    public void LoginOnlyMail() throws InterruptedException {
        Thread.sleep(2000);
        WebElement mailTextBox = driver.findElement(By.name("Input.Email"));
        mailTextBox.sendKeys("azuparic2@gmail.com");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/button"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement passwordRequired = driver.findElement(By.id("Input_Password-error"));
        Assert.assertEquals(passwordRequired.getText(), "Polje Lozinka je obavezno");
    }
    @Test(priority = 2)
    public void LoginOnlyPassword() throws InterruptedException {
        Thread.sleep(2000);
        WebElement passwordTextBox = driver.findElement(By.name("Input.Password"));
        passwordTextBox.sendKeys("passwordless!");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/button"));
        submitButton.click();
        WebElement emailRequired = driver.findElement(By.id("Input_Email-error"));
        Assert.assertEquals(emailRequired.getText(), "Polje Email je obavezno");
    }
    @Test(priority = 3)
    public void LoginIncorrectCredentials() throws InterruptedException {
        Thread.sleep(2000);
        WebElement mailTextBox = driver.findElement(By.name("Input.Email"));
        mailTextBox.sendKeys("azuparic2@gmail.com");
        WebElement passwordTextBox = driver.findElement(By.name("Input.Password"));
        passwordTextBox.sendKeys("passwordless!");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/button"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement passwordRequired = driver.findElement(By.xpath("//*[@id=\"account\"]/div[1]"));
        Assert.assertEquals(passwordRequired.getText(), "Greška. Provjerite email adresu ili lozinku!");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
