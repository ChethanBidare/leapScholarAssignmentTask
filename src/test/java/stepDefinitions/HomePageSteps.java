package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.ExcelManager;
import org.junit.Assert;
import pageObjects.HomePage;
import utils.Constants;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;
    ExcelManager excelManager;
    private String scenarioName;

    public HomePageSteps(TestContext context){
        this.testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        excelManager = testContext.getPageObjectManager().getExcelManager();
    }

    @Before
    public void beforeHook(Scenario scenario) {
        scenarioName = scenario.getName();
    }

    @Given("Navigate to the Url: {string}")
    public void navigate_to_the_url(String url) {
        String urlData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, url);
        homePage.navigateToUrl(urlData);
    }

    @When("User selects Country: {string}")
    public void user_selects_country(String country) {
        String countryData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, country);
        homePage.selectCountry(countryData);
    }

    @When("User selects preferred intake: {string} and program {string}")
    public void user_selects_preferred_intake_and_program(String intake, String program) {
        String intakeData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, intake);
        String programData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, program);
        homePage.selectPreferredIntakeAndProgram(intakeData, programData);
    }

    @When("User selects Education: {string} and Percentage {string} and Graduation: {string} and validate percentage field")
    public void user_selects_education_and_percentage_and_graduation(String degree, String percentage, String year) {
        String degreeData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, degree);
        String percentageData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, percentage);
        String yearData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, year);
        Assert.assertTrue(homePage.selectEducationDetails(degreeData, percentageData, yearData));
    }

    @When("User selects Status of IELTS TOEFL Exam as {string}")
    public void user_selects_status_of_ielts_toefl_exam_as(String status) {
        String statusData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, status);
        homePage.selectStatusIeltsToeflExam(statusData);
    }
    @When("User selects Already Have university Admit: {string}")
    public void user_selects_already_have_university_admit(String status) {
        String statusData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, status);
        homePage.selectUniversityAdmit(statusData);
    }

    @When("User enters Name and Email Id")
    public void user_enters_name_and_email_id() {
        homePage.enterNameAndEmailAddress();
    }

    @When("User clicks on Complete button")
    public void user_clicks_on_complete_button() {
        homePage.clickOnCompleteButton();
    }

    @Then("Validate Url: {string}")
    public void validate_url(String expected) {
        String expectedData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, expected);
        Assert.assertTrue(homePage.validateUrl(expectedData));
    }

    @Then("User clicks on Claim Access button")
    public void user_clicks_on_claim_access_button() {
        homePage.clickOnClaimAccessButton();
    }

    @Then("User clicks on Goto Dashboard and validate Url: {string}")
    public void user_clicks_on_goto_dashboard_and_validate_url(String expected) {
        String expectedData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, expected);
        homePage.clickOnGotoDashboardButton();
        Assert.assertTrue(homePage.validateUrl(expectedData));
    }

    @Then("User clicks on Home and validate Url: {string}")
    public void user_clicks_on_home_and_validate_url(String expected) {
        String expectedData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, expected);
        homePage.clickOnHomeLink();
        Assert.assertEquals(expectedData, homePage.getUrl());
    }

    @Then("Validate Thank you text: {string}")
    public void validate_thank_you_text(String expected) {
        String expectedData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, expected);
        Assert.assertEquals(expectedData, homePage.getThankYouText());
    }

    @Then("User clicks on Goto Profile and validate Url: {string}")
    public void user_clicks_on_goto_profile_and_validate_url(String expected) {
        String expectedData = excelManager.get(Constants.DATASHEET_STRING, scenarioName, expected);
        homePage.clickOnGotoProfile();
        Assert.assertEquals(expectedData, homePage.getUrl());
    }

    @When("User picks and Confirms the Slot")
    public void user_picks_and_confirms_the_slot() {
        homePage.confirmSlot();
    }

    @Then("User clicks on Skip Now and Confirms Skip")
    public void user_clicks_on_skip_now_and_confirms_skip() {
        homePage.clickOnSkipForNow();
    }

    @Then("User clicks on Get LS plus Now button")
    public void user_clicks_on_get_ls_plus_now_button() {
        homePage.clickOnGetLsPlusNowButton();
    }

    @Then("User clicks on Pay Now and chooses NetBanking SBI")
    public void user_clicks_on_pay_now_and_chooses_net_banking_sbi() {
        homePage.clickOnPayNowButton();
        homePage.clickOnNetBankingAndSelectSBI();
    }

    @Then("User clicks on Pay {int} and Success button")
    public void user_clicks_on_pay_and_success_button(Integer int1) {
        homePage.clickOnSuccessButton();
    }
}
