package util;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ReusableMethods(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Navigation
    public void openUrl(String url) {
        driver.get(url);
    }

    // Assertions
    public void assertTitlePresent() {
        String title = driver.getTitle();
        if (title == null || title.isBlank()) {
            throw new AssertionError("Page title should not be empty");
        }
    }

    // Waits
    public void waitForUrlContains(String fragment) {
        wait.until(ExpectedConditions.urlContains(fragment));
    }

    // Alerts
    public String waitForAlertAndGetText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert != null ? alert.getText() : null;
    }

    public void closeAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            try {
                wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
            } catch (TimeoutException ignored) {
                try {
                    driver.switchTo().alert().dismiss();
                } catch (NoAlertPresentException ignored2) {}
            }
        } catch (NoAlertPresentException ignored) {
            // No alert to close
        }
    }

    public void acceptAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }
}
