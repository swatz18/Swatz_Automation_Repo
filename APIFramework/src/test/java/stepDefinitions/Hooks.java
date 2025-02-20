package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@Delete")
	public void beforeDeletePlace() throws IOException
	{
		if(AddplaceStepDef.placeID==null)
		{
		AddplaceStepDef sd=new AddplaceStepDef();
		sd.add_place_playload_with_and("gk", "Tamil", "India");
		sd.user_tries_to_hit_with_request("AddPlaceAPI", "POST");
	    sd.get_the(AddplaceStepDef.placeID);
		System.out.println(AddplaceStepDef.placeID);
		}
	}
}
