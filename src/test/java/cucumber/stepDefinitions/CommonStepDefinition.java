package cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class CommonStepDefinition {

    private WebDriver driver;
    @Before
    public void intializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Given("User navigate to landingPage")
        public void user_navigate_to_landingpage(){
        driver.get("https://www.saucedemo.com/");
        }

    @When("User type {string} on username textField")
    public void user_type_username(String username){
        System.out.println("---User login in---");
        driver.findElement(By.id("user-name")).sendKeys(username);
        System.out.println("---using account: " + username+"---");
    }

    @And("User type {string} on password textField")
    public void user_type_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("User click login button")
    public void user_click_password(){
        driver.findElement(By.id("login-button")).click();
    }

    @And("User can see homepage")
    public void user_can_see_homepage(){
        assertEquals(driver.findElement(By.className("app_logo")).getText(), ("Swag Labs"));
        System.out.println("---Success Logged in---");
    }

    @And("User can see {string} message")
    public void user_can_see_error(String error){
        assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText(), (error));
    }

    @And("User can see {string}")
    public void user_can_see_product(String product){
        if (product.equals("Sauce Labs Backpack")) {
            assertEquals(driver.findElement(By.id("item_4_title_link")).getText(), (product));
        } else if (product.equals("Sauce Labs Bike Light")) {
            assertEquals(driver.findElement(By.id("item_0_title_link")).getText(), (product));
        }
        System.out.println("---User can see the " + product +"---");
    }

    @And("User add {string} to chart")
    public void user_add_product_to_chart(String product){
        if (product.equals("Sauce Labs Backpack")) {
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        } else if (product.equals("Sauce Labs Bike Light")) {
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        }
    }

    @Then("User can see shopping cart page")
    public void user_can_see_shopping_cart_page(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("User can see {string} was listing")
    public void user_can_see_product_was_listing(String product){
        assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), (product));
        System.out.println("---Product" + product +" was listing---");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
