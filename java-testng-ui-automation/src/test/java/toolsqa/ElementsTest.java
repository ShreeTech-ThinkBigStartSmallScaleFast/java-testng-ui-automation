package toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div"));
        clickOnWebElementUsingJavaScriptExecutor(element);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void elementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickOnWebElementUsingJavaScriptExecutor(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    @Test(priority = 0)
    public void navigateToTextBoxSection() {
        fillTextBoxForm();
    }

    @Test(priority = 1)
    public void navigateToCheckBoxesSection() {
        selectCheckboxes();
    }

    @Test(priority = 2)
    public void  navigateToRadioButtonSection(){
        selectRadioButtonAndGetMessage();
    }

    private void selectRadioButtonAndGetMessage() {
        WebElement radioButton = driver.findElement(By.id("item-2"));
        radioButton.click();

        WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        clickOnWebElementUsingJavaScriptExecutor(yesRadio);

        WebElement getMessage = driver.findElement(By.xpath("//div/div/div/div[2]/div[2]/p"));
        System.out.println(getMessage.getText());
    }

    public void fillTextBoxForm() {
        WebElement textBox = driver.findElement(By.id("item-0"));
        textBox.click();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Jenna Williams");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("jennawilliams@gamil.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("NY14EY, UK, London 3456");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("NY14EY, UK, London 3456");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    public void selectCheckboxes() {
        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();

        WebElement expandOptions = driver.findElement(By.xpath("//button[@title='Expand all']"));
        expandOptions.isDisplayed();
        expandOptions.click();

        WebElement checkOne = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]"));
        clickOnWebElementUsingJavaScriptExecutor(checkOne);
    }
}
