package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeHomePage extends BasePage {

    // Static locators for common elements on home page (extend as needed)
    @FindBy(css = "nav, .menu, .navbar")
    private WebElement navContainer;

    @FindBy(linkText = "Popups")
    private WebElement popupsLink;

    public PracticeHomePage(org.openqa.selenium.WebDriver driver, org.openqa.selenium.support.ui.WebDriverWait wait) {
        super(driver, wait);
        initElements(); // Initialize @FindBy elements
    }

    public void navigateTo(String pageName) {
        // Prefer link inside a nav container if present; fall back globally
        try {
            if (navContainer != null) {
                try {
                    navContainer.findElement(linkByText(pageName)).click();
                    return;
                } catch (NoSuchElementException ignore) {
                    // Try partial inside nav
                    navContainer.findElement(partialLinkByText(pageName)).click();
                    return;
                }
            }
            // Global fallback
            driver.findElement(linkByText(pageName)).click();
        } catch (NoSuchElementException e) {
            driver.findElement(partialLinkByText(pageName)).click();
        }
    }

    // Actions
    public void open(String url) {
        utils.openUrl(url);
    }

    public void clickPopups() {
        popupsLink.click();
    }
}
