package pageDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageMethods.GeneralMethods;

public class GeneralDefinitions {
    @Given("Executing Chrome Driver")
    public void initDriver() {
        GeneralMethods.initDriver();
    }

    @Then("Close Chrome Driver")
    public void closeDriver() throws InterruptedException {
        GeneralMethods.closeDriver();
    }
}
