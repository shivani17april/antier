package stepDefintion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static support.FileUtilities.*;

public class LoginSteps extends LoginPage {

    String PROPERTY_FILE_NAME= "login";

    @Given("The user launches the application")
    public void userLaunchesTheApplication(){
        String appURL= readProperty("login","app_url");
        userLaunchWebApplication(appURL);
    }

    @When("The user enters the username and password")
    public void userEntersTheUsernameAndPassword(){
        String username= readProperty(PROPERTY_FILE_NAME,"username");
        String password= readProperty(PROPERTY_FILE_NAME,"password");
        submitUserName(username);
        submitPassword(password);

    }

//    @When("The user clicks on Login button")
//    public void the_user_clicks_on_Login_button() {
//        System.out.println("click on Login");
//    }
//
//    @When("The user enters the inVlaid username and invalid Password")
//    public void userEntersTheInvalidUsernameAndInValidPassword(){
//        System.out.println("userEntersTheInvalidUsernameAndInValidPassword");
//    }
//
//    @Then("The user should not be able to see the Home page")
//    public void homepageShouldNotBeDisplayed(){
//        System.out.println("homepageShouldNotBeDisplayed");
//    }


}
