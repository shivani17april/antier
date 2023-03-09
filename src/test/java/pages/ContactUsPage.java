package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sendEmail.SendEmail;

import java.util.Objects;

public class ContactUsPage {

    public String isContactUsTitleAvailable(WebDriver driver) {
        return driver.getTitle();
    }

    public void enterName(WebDriver driver, String name) {
        By nameField = By.name("your-name");
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(WebDriver driver, String email) {
        By emailField = By.name("email-708");
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(WebDriver driver, String email) {
        By phoneField = By.name("tel-147");
        driver.findElement(phoneField).sendKeys(email);
    }


    public void enterCountry(WebDriver driver, String countryCode, String country_name) {
        By countryIcon = By.xpath("//div[@class='flag-dropdown']");

        driver.findElement(countryIcon).click();
        By countryName = By.xpath("//li[@data-country-code='" + countryCode + "']/span[contains(text(),'" + country_name + "')]");
        driver.findElement(countryName).click();
    }
    public void enterMsg(WebDriver driver, String msg) {
        By msgField = By.name("your-message");
        driver.findElement(msgField).sendKeys(msg);
    }
    public void verifyCaptcha(WebDriver driver) {
        By selectedCaptcha = By.xpath("//*[@id=\"wpcf7-f2117-p122-o3\"]/form/div[7]/p/span/span/span[1]/label[2]");
        try {
            driver.findElement(selectedCaptcha).click();
        } catch (Exception e) {
            System.out.println("TAG...." + e.getMessage());
        }
    }

    public void clickOnContactSubmit(WebDriver driver) {
        By sub = By.xpath("//div[@class='mf-row']//input[@value='Submit']");

        driver.findElement(sub).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void success(WebDriver driver) {

        try {
            if (Objects.equals(driver.getTitle(), "Thanks - Antier Solutions")) {


                    SendEmail email = new SendEmail();
                    email.sendEmailFxn("Contact su", "https://www.antiersolutions.com/thanks/");

            }

        } catch (Exception e) {
            System.out.println("TAG" + e.getMessage());
        }
    }
}
