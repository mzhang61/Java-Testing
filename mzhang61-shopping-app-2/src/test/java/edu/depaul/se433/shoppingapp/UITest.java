package edu.depaul.se433.shoppingapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class UITest {

  private static WebDriver driver;
  private SoftAssertions softly;

  @BeforeAll
  static void setup() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setupSoftly() {
    softly = new SoftAssertions();
    driver = new ChromeDriver();
  }

  @AfterEach
  void executeVerification() {
    softly.assertAll();
    driver.quit();
  }

  @Test
  @DisplayName("verify project ui,running it second time will cause error. plz stop running the shopping app when doing gradle clean built or other tests")
  void testBasic() {
    driver.get("http://localhost:8085/");
    String title = driver.getTitle();
    softly.assertThat(title).as("title").isEqualTo("Online Shopping");
    WebElement customerName = driver.findElement(By.id("customer-name"));
    customerName.sendKeys("Nick");

    WebElement destinationState = driver.findElement(By.id("state"));
    destinationState.sendKeys("IL");

    WebElement shippingOption = driver.findElement(By.id("shipping"));
    destinationState.sendKeys("STANDARD");

    WebElement nameofProduct = driver.findElement(By.id("name"));
    destinationState.sendKeys("cookie");

    WebElement unitPrice = driver.findElement(By.id("unit_price"));
    destinationState.sendKeys("5");

    WebElement quantity = driver.findElement(By.id("quantity"));
    destinationState.sendKeys("2");

    WebElement submitButton = driver.findElement(By.id("add-item-btn"));
    submitButton.click();
    WebElement submitButton1 = driver.findElement(By.id("get-price-btn"));
    submitButton1.click();
    WebElement submitButton2 = driver.findElement(By.id("checkout-btn"));
    submitButton2.click();

    WebDriverWait wait = new WebDriverWait(driver, 1);

    WebElement resultDiv = driver.findElement(By.id("result"));
    wait.until(ExpectedConditions.textToBePresentInElement(resultDiv, "Fine"));
    String msg = resultDiv.getText();
    softly.assertThat(msg).as("name contents").isEqualTo("");

    // verify clear function clears everything
    WebElement resetButton = driver.findElement(By.id("reset-btn"));
    resetButton.click();
    wait = new WebDriverWait(driver, 1);
    softly.assertThat(customerName.getText()).as("should be clear").isBlank();
    softly.assertThat(destinationState.getText()).as("should be clear").isBlank();
    softly.assertThat(nameofProduct.getText()).as("should be clear").isBlank();
    Select select = new Select(shippingOption);
    WebElement option = select.getFirstSelectedOption();
    softly.assertThat(option.getText()).as("should be clear").isEqualTo("-- select an option --");
    softly.assertThat(resultDiv.getText()).as("should be clear").isBlank();
    softly.assertThat(unitPrice.getText()).as("should be clear").isBlank();
    softly.assertThat(quantity.getText()).as("should be clear").isBlank();
  }

}
