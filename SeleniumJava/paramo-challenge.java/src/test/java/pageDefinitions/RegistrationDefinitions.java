package pageDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageMethods.RegistrationMethods;

public class RegistrationDefinitions {
    @When("User registration")
    public void userRegistration() {
        RegistrationMethods.userRegistration();
    }

    @And("Checking registration and deposit the bonus")
    public void userCheck() throws InterruptedException {
        RegistrationMethods.userCheck();
        RegistrationMethods.depositAndCheck();
    }
}
