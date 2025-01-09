Feature: Validation of Place API's of Google API
@Add @Reg
Scenario Outline: Validation of addition of place using AddPlaceAPI
	Given Add place playload with "<name>" , "<language>" and "<address>"
	When user tries to hit "AddPlaceAPI" with "POST" request
	Then the statuscode is 200
	And "status" in the response is "OK"
	And "scope" in the response is "APP"
	And get the "place_id"
	#And check if created place_id maps to "<name>" using "getPlaceAPI"

Examples:
 |name   |language   |address         |
 |swatz  |French     |123 wall street |

@Delete	@Reg
Scenario: Verify if Delete place is working Fine
  Given Delete place playload 
	When user tries to hit "deletePlaceAPI" with "POST" request
	Then the statuscode is 200
	#And "status" in the response is "OK"