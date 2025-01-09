package testData;
//enum is special class to declare constants
public enum EnumClass {
	//declare the API you want to use
	AddPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");  //enum has collection of variables/methods and ends with ;
	//create a local variable and add constructor
	private String resource;

	EnumClass(String resource) {
		this.resource=resource;
	}
	//return the resource
	public String getResource()
	{
		return resource;
	}
}
