package steps;

import java.time.Duration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.PracticeHomePage;
import pages.PracticePopupsPage;

public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    private PracticeHomePage homePage;
    private PracticePopupsPage popupsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver(); // Selenium Manager will provision driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new PracticeHomePage(driver, wait);
        popupsPage = new PracticePopupsPage(driver, wait);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Given("I am on Practice Automation home page {string}")
    public void i_am_on_practice_automation_home_page(String url) {
        homePage.open(url);
    }

    @When("I navigate to Popups page")
    public void i_navigate_to_popups_page() {
        // Use the available page object method to click the Popups link
        popupsPage.clickPopupsNavLink();
    }

    @Then("I should land on the Popups page")
    public void i_should_land_on_the_popups_page() {
        popupsPage.waitUntilOnPopupsPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/popups/"), "URL did not contain /popups/");
    }

    @When("I click the Alert popup button")
    public void i_click_the_alert_popup_button() {
        popupsPage.clickAlertButton();
    }

    @Then("I should see an alert containing {string}")
    public void i_should_see_an_alert_containing(String expected) {
        String actual = popupsPage.readAlertText();
        Assert.assertTrue(actual.contains(expected), "Expected alert to contain: " + expected + " but was: " + actual);
    }

    @And("I close the alert")
    public void i_close_the_alert() {
        popupsPage.closeAlert();
    }
}
