package testData;

import java.util.ArrayList;

import pojo.AddPlaceGoogleResponse;
import pojo.DeletePlaceRequest;
import pojo.Location;

public class TestDataMethods {

	public AddPlaceGoogleResponse addPlacePayload(String name, String lang, String addr)
	{
		AddPlaceGoogleResponse ad=new AddPlaceGoogleResponse();
		ad.setAccuracy(50);
		ad.setName(name);
		ad.setPhone_number("7698989009");
		ad.setAddress(addr);
		ad.setWebsite("http://google.com");
		ad.setLanguage(lang);
		ArrayList<String> ty=new ArrayList<>();  // as its a list of strings create a arraylist and add the values
		ty.add("shoe park");
		ty.add("shop");
		ad.setTypes(ty);
		Location l=new Location();     //create obj of class as it has nested json
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ad.setLocation(l);
		return ad;
	}

	public DeletePlaceRequest deleteReqPayload(String place_id)
	{
		DeletePlaceRequest del=new DeletePlaceRequest();
		del.setPlace_id(place_id);
		return del;
	}
}
