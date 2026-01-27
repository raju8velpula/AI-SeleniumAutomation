package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ReusableMethods;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final ReusableMethods utils;

    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = (wait != null) ? wait : new WebDriverWait(driver, Duration.ofSeconds(10));
        this.utils = new ReusableMethods(this.driver, this.wait);
    }

    // Helper to initialize PageFactory elements from subclasses
    protected void initElements() {
        PageFactory.initElements(this.driver, this);
    }

    // Reusable dynamic locators
    protected By linkByText(String text) {
        return By.linkText(text);
    }

    protected By partialLinkByText(String text) {
        return By.partialLinkText(text);
    }

    protected By buttonByText(String text) {
        return By.xpath("//button[normalize-space()='" + text + "']");
    }
}
