package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TalkToExpertsPage  {
    By nameField = By.name("text-800");
    By emailField = By.name("email-65");
    By phoneField = By.name("tel-147");
    By msgField = By.name("textarea-662");
    By sub = By.xpath("//div[@class='f-block rg']//input[@value='Submit']");

    By countryIcon = By.xpath("//div[@class='flag-dropdown']");

    public String isContactUsTitleAvailable(WebDriver driver) {
        return driver.getTitle();
    }

    public void enterName(WebDriver driver, String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(WebDriver driver, String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPhone(WebDriver driver, String email) {
        driver.findElement(phoneField).sendKeys(email);
    }
    public void enterMsg(WebDriver driver, String msg) {
        driver.findElement(msgField).sendKeys(msg);
    }

    public void enterCountry(WebDriver driver, String countryCode, String country_name) {
        driver.findElement(countryIcon).click();
        By countryName = By.xpath("//li[@data-country-code='" + countryCode + "']/span[contains(text(),'" + country_name + "')]");
        driver.findElement(countryName).click();
    }
    public void clickOnContactSubmit(WebDriver driver) {
        driver.findElement(sub).click();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
