package AutomationPractice;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class StepDefinations {
    String baseUrl = "http://automationpractice.com/index.php";
    public WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @After
   public void closeBrowser() {
      driver.quit(); }

    @Given("^User is on home page$")
    public void userIsOnHomePage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#home-page-tabs")).isDisplayed());
    }

    @When("^User click SignIn link$")
    public void userClickSignInLink() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".login")).click();
    }

    @Then("^User should be able to navigate to Authentication page$")
    public void userShouldBeAbleToNavigateToAuthenticationPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#create-account_form")).isDisplayed());
    }

    @And("^User should see SignIn Panel$")
    public void userShouldSeeSignInPanel() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#login_form")).isDisplayed());
    }

    @When("^User enter Email address as (.*), password as (.*)$")
    public void enterLogindetails(String email, String password) {
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
    }

    @And("^click SIgnIn button$")
    public void clickSIgnInButton() {
        driver.findElement(By.cssSelector("#SubmitLogin")).click();
    }

    @Then("^User should loggedIn sucessfully$")
    public void userShouldLoggedInSucessfully() {
        Assert.assertEquals("My account - My Store", driver.getTitle());
    }

    @And("User should be on My Account page")
    public void userShouldBeOnMyAccountPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".myaccount-link-list")).isDisplayed());
    }

    @Then("^User should see validation message as (.*)$")
    public void userShouldSeeValidationMessageAsMessage(String errorMessage) {
        String actualErrorMessage = driver.findElement(By.cssSelector(".alert.alert-danger ol li")).getText();
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }

    @And("^User should see create an account panel$")
    public void userShouldSeeCreateAnAccountPanel() {
        Assert.assertTrue(driver.findElement(By.id("create-account_form")).isDisplayed());
    }

    @When("^User enter Email address as (.*)$")
    public void userEnterEmailAddress(String email) {
        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
    }

    @And("^Click on Create An Account button$")
    public void clickOnCreateAnAccountButton() {
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
    }

    @Then("^User should be able to navigate to registration page$")
    public void userShouldBeAbleToNavigateToRegistrationPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#account-creation_form")).isDisplayed());
    }


    @Then("^User should be able to see (.*)$")
    public void userShouldBeAbleToSeeErrorMessage(String errorMessage) {
        String actualErrorMessage = driver.findElement(By.cssSelector("#create_account_error ol li")).getText();
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }

    @When("^User select Title as (.*)$")
    public void userSelectTitle(String Title) {
        if (Title == "Mr") {
            WebElement Title1 = driver.findElement(By.cssSelector("#id_gender1"));
            Title1.click();
        } else if (Title == "Mrs") {
            WebElement Title2 = driver.findElement(By.cssSelector("#id_gender2"));
            Title2.click();
        }
    }
    @And("^First name as (.*), Last name as (.*),Password as (.*)$")
    public void enterDetails(String Name1,String Name2,String Pwd) {
        WebElement FirstName = driver.findElement(By.cssSelector("#customer_firstname"));
        FirstName.sendKeys(Name1);
        WebElement LastName = driver.findElement(By.cssSelector("#customer_lastname"));
        LastName.sendKeys(Name2);
        WebElement Password = driver.findElement(By.cssSelector("#passwd"));
        Password.sendKeys(Pwd);
    }

    @And("^Company as (.*),City as (.*),State as (.*),Zip as (.*),Country as (.*)$")
    public void address(String add1, String City, String State,String Zip,String Country) {
        driver.findElement(By.cssSelector("#address1")).sendKeys(add1);
        driver.findElement(By.cssSelector("#city")).sendKeys(City);
        driver.findElement(By.cssSelector("#id_state")).sendKeys(State);
        driver.findElement(By.cssSelector("#postcode")).sendKeys(Zip);
        driver.findElement(By.cssSelector("#id_country")).sendKeys(Country);
    }
    @And("^Enter Mobile number as (.*)$")
    public void mobileNo(String number)
    {
        WebElement mobilenumber = driver.findElement(By.cssSelector("#phone_mobile"));
        mobilenumber.sendKeys(number);
    }
    @And("^click on Register button$")
    public void clickOnRegisterButton() {
        driver.findElement(By.cssSelector("#submitAccount")).click();
    }

   }


