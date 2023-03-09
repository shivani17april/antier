package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import sendEmail.SendEmail;
import util.Utility;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TalkToExpertsPage extends Utility {
    By nameField = By.xpath("//*[@id=\"wpcf7-f1917-o1\"]/form/div[2]/div[1]/div/p/span/input");
    By emailField = By.name("email-65");
    //By phoneField = By.name("tel-147");
    By phoneField = By.xpath("//input[@placeholder='Phone Number*']");
    By msgField = By.name("textarea-662");
    //    By sub = By.xpath("//div[@class='f-block rg']//input[@value='Submit']");
//    By sub = By.className("wpcf7-form-control has-spinner wpcf7-submit");

    By sub = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[7]/div[1]/p[1]/input[1]");
    By countryIcon = By.xpath("//*[@id=\"wpcf7-f1917-o1\"]/form/div[2]/div[3]/div/p/span/div/div");

//    public String isContactUsTitleAvailable(WebDriver driver) {
//        return driver.getTitle();
//    }

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

    public void verifyCaptcha(WebDriver driver) {
        By captcha = By.xpath("//*[@id=\"wpcf7-f1917-o1\"]/form/div[2]/div[6]/p/span/span/span[1]/span/span");
        By selectedCaptcha = By.xpath("//*[@id=\"wpcf7-f1917-o1\"]/form/div[2]/div[6]/p/span/span/span[1]/label[2]");
        //*[@id="wpcf7-f1917-o1"]/form/div[2]/div[3]/div/p/span/div/div

        String sCaptcha = driver.findElement(captcha).getText();
        String lastWord = sCaptcha.substring(sCaptcha.lastIndexOf(" ") + 1);
        System.out.println("TAG :" + sCaptcha);
        System.out.println("TAG: " + lastWord);
        try {
            driver.findElement(selectedCaptcha).click();
        } catch (Exception e) {
            System.out.println("TAG...." + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void enterCountry(WebDriver driver, String countryCode, String country_name) {
        driver.findElement(countryIcon).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //(//span[@class='country-name'])[401])
        //(//div[@class='selected-flag'])[3]
        //*[@id="wpcf7-f1917-o1"]/form/div[2]/div[3]/div/p/span/div/div/ul/li[7]
        ////ul[@class='country-list']//span[@class='country-name'][normalize-space()='Albania (Shqipëri)']
//        By countryName = By.xpath("//li[@data-country-code='"
//                + countryCode + "']/span[contains(text(),'"
//                + country_name + "')]");

        try {
            By countryName = By.xpath("(//span[@class='country-name'])[402]");
            driver.findElement(countryName).click();
        } catch (Exception e) {
            System.out.println("TAG...." + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void clickOnContactSubmit(WebDriver driver) {
        try {
            takeSnapShot(driver,"D:\\test.png");
        } catch (Exception e) {
            System.out.println("TAG...." + e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(sub)).click().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void success(WebDriver driver) {
        try {
            takeSnapShot(driver,"D:\\test1.png");
        } catch (Exception e) {
            System.out.println("TAG...." + e.getMessage());
        }
        try {
            if (Objects.equals(driver.getTitle(), "Thanks - Antier Solutions")) {
                SendEmail email = new SendEmail();
                email.sendEmailFxn("Talk to expert", "https://www.antiersolutions.com/thanks/");
            }
        } catch (Exception e) {
            System.out.println("TAG" + e.getMessage());
        }
    }
}
