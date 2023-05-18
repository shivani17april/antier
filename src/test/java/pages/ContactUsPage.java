package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sendEmail.SendEmail;

import java.util.Objects;

public class ContactUsPage {
    By nameField = By.name("your-name");
    By emailField = By.name("email-708");
    By phoneField = By.name("tel-147");
    By msgField = By.name("your-message");
    By sub = By.xpath("//div[@class='mf-row']//input[@value='Submit']");

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


    public void enterCountry(WebDriver driver, String countryCode, String country_name) {
        driver.findElement(countryIcon).click();
        By countryName = By.xpath("//li[@data-country-code='" + countryCode + "']/span[contains(text(),'" + country_name + "')]");
        driver.findElement(countryName).click();
    }
    public void enterMsg(WebDriver driver, String msg) {
        driver.findElement(msgField).sendKeys(msg);
    }
    public void verifyCaptcha(WebDriver driver) {
        By selectedCaptcha = By.xpath("//*[@id=\"wpcf7-f2117-p122-o3\"]/form/div[7]/p/span/span/span[1]/label[1]");
        try {
            driver.findElement(selectedCaptcha).click();
        } catch (Exception e) {
            System.out.println("TAG...." + e.getMessage());
        }
    }

    public void clickOnContactSubmit(WebDriver driver) {
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
                    email.sendEmailFxn("hellos", "https://www.antiersolutions.com/thanks/");

            }

        } catch (Exception e) {
            System.out.println("TAG" + e.getMessage());
        }
    }
}
