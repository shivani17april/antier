package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By elementUserName = By.id("email");
    private By elementPassword = By.id("pass");

    public void userLaunchWebApplication(String appUrl) {
        launchApplication(appUrl);
    }

    public void submitUserName(String username) {
        System.out.println(username);
        driver.findElement(elementUserName).sendKeys("Admin");
    }

    public void submitPassword(String password) {
        driver.findElement(elementPassword).sendKeys("admin123");
    }


}
