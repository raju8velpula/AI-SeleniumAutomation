package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePopupsPage extends BasePage {

    public PracticePopupsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        initElements();
    }

    // Locators
    @FindBy(css = "a[href*='popups'], nav a[href*='popups']")
    private WebElement popupsNavLink;

    @FindBy(css = "button#alert, button[onclick*='alert'], .wp-block-button__link[href*=\"#\"]")
    private WebElement alertButton;

    // Actions
    public void waitUntilOnPopupsPage() {
        utils.waitForUrlContains("/popups/");
    }

    public void clickPopupsNavLink() {
        popupsNavLink.click();
        utils.waitForUrlContains("/popups/");
    }

    public void clickAlertButton() {
        alertButton.click();
    }

    public String readAlertText() {
        return utils.waitForAlertAndGetText();
    }

    public void closeAlert() {
        utils.acceptAlert();
    }
}
