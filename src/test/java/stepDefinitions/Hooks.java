package stepDefinitions;

import cucumber.TestContext;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import utils.BaseSetup;
import utils.Constants;

public class Hooks extends BaseSetup {
    TestContext testContext;
    public Hooks(TestContext context){
        testContext = context;
    }
}
