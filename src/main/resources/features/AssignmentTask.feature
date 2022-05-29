Feature: Login Related Tests

  Background: User logs into the Application
    Given Navigate to the Url
    When User clicks on Sign In and Enters Mobile Number and OTP
    Then Verify User is landed on Spot counselling Url: "SpotCounsellingUrl"

  Scenario: Qualified Slot 1 user Auto LS Plus
    When User selects Country: "Country"
    And User selects preferred intake: "Intake" and program "Course"
    When User selects Education: "Education" and Percentage "Percentage" and Graduation: "Graduation" and validate percentage field
    And User selects Status of IELTS TOEFL Exam as "StatusOfIELTS"
    And User selects Already Have university Admit: "UniversityAdmit"
    And User enters Name and Email Id
    And User clicks on Complete button
    Then Validate Url: "SlotTypeUrl"
    And User clicks on Claim Access button
    And User clicks on Goto Dashboard and validate Url: "ProfileChatUrl"
    And User clicks on Home and validate Url: "ProfileCounsellingUrl"

  Scenario: Qualified Slot 2 user
    When User selects Country: "Country"
    And User selects preferred intake: "Intake" and program "Course"
    When User selects Education: "Education" and Percentage "Percentage" and Graduation: "Graduation" and validate percentage field
    And User selects Status of IELTS TOEFL Exam as "StatusOfIELTS"
    And User enters Name and Email Id
    And User clicks on Complete button
    And User picks and Confirms the Slot
    Then Validate Url: "ScProfileUrl"
    And User clicks on Skip Now and Confirms Skip
    And Validate Url: "CounsellingOverviewUrl"
    And User clicks on Get LS plus Now button
    And Validate Url: "PaymentUrl"
    And User clicks on Pay Now and chooses NetBanking SBI
    And User clicks on Pay 199 and Success button
    And Validate Url: "OnboardingUrl"
    And User clicks on Skip Now and Confirms Skip
    And Validate Url: "ProfileChatUrl"
    And User clicks on Home and validate Url: "ProfileCounsellingUrl"

  Scenario: Disqualified Slot 3 user
    When User selects Country: "Country"
    And User selects preferred intake: "Intake" and program "Course"
    When User selects Education: "Education" and Percentage "Percentage" and Graduation: "Graduation" and validate percentage field
    And User selects Status of IELTS TOEFL Exam as "StatusOfIELTS"
    And User selects Already Have university Admit: "UniversityAdmit"
    And User enters Name and Email Id
    And User clicks on Complete button
    Then Validate Url: "SlotTypeUrl"
    And Validate Thank you text: "ThankYouText"
    And User clicks on Goto Profile and validate Url: "CounsellingOverviewUrl"

