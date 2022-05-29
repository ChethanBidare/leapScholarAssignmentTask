package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pageObjects.LoginPage;

public class LoginPageSteps {

    TestContext testContext;
    LoginPage loginPage;

    public LoginPageSteps(TestContext context){
        this.testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("Navigate to the Url")
    public void navigate_to_the_url() {
        loginPage.navigateToUrl();
    }
    @When("User clicks on Sign In and Enters Mobile Number and OTP")
    public void user_clicks_on_sign_in_and_enters_mobile_number_and_otp() {
        loginPage.clickOnSignInButton();
        loginPage.enterMobileNumberAndOTP();
    }
    @Then("Verify User is landed on Spot counselling Url: {string}")
    public void verify_user_is_landed_on_spot_counselling_url(String spotCounsellingUrl) {
        //Assert.assertTrue(loginPage.getUrl().equalsIgnoreCase(spotCounsellingUrl));
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.getUrl()).isEqualToIgnoringCase(spotCounsellingUrl);

    }
}
