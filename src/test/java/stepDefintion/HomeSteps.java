package stepDefintion;

import io.cucumber.java.en.Then;

public class HomeSteps {

    @Then("The user verify Home page is displayed")
    public void the_user_verify_Home_page_is_displayed() {
        System.out.println("the_user_verify_Home_page_is_displayed");
    }

    @Then("The user verify the Logout link availability")
    public void the_user_verify_the_Logout_link_availability() {
        System.out.println("the_user_verify_the_Logout_link_availability");
    }
}
