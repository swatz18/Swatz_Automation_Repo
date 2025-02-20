
@home
Feature: Naukri Application Home Page Functionalities
  Background:
    Given I navigate to Naukri Application
    And enter the credentials
	
  Scenario: Edit Carrer Profile
    When I naviagte to my profile
    And Click on carrer profile
    And I click on "preffered location", select/deslect a "location"
    And clcik on save button
    Then I should see profile updated as "Today"
    
   Scenario: Update Resume
    When I naviagte to my profile
    And Click on "update" in resume
    And I click on resume that has to be uploaded
    Then Resume should br uploaded successfully
    And I should see profile updated as "Today"