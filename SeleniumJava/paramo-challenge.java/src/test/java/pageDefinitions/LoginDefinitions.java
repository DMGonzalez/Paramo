package pageDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageMethods.LoginMethods;

public class LoginDefinitions {
    @When("User login")
    public void userLogin() throws InterruptedException {
        LoginMethods.userLogin();
    }

    @And("Checking login")
    public void checkLogin() {
        LoginMethods.checkLogin();
    }
}
