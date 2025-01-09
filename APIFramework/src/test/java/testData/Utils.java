package testData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification reqspec;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(reqspec==null) {      //this is to check if logfile is already created, if yes the just return reqspec
		PrintStream log=new PrintStream(new FileOutputStream("logfile.txt"));  //creates new file and add logs to it
		reqspec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.addQueryParam("key","qaclick123").setAccept(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))  //req logs
				.addFilter(ResponseLoggingFilter.logResponseTo(log))// res logs ->to mention obj of log file where logs has to be printed
				.build();
		return reqspec;
		}
		return reqspec;

	}

	public String getGlobalValue(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream f=new FileInputStream("G:\\Testing\\Learnings\\Eclipse\\APIFramework\\src\\test\\java\\testData\\global.properties");
		p.load(f);
		String val=p.getProperty("key");
		System.out.print(val);
		return val;
	}

	public String getJsonvalue(Response response, String key)
	{
		String resp=response.asString();
		System.out.println(resp);
		JsonPath js=new JsonPath(resp);
	    String out=js.get(key).toString();
	    System.out.println(out);
	    return out;
	}
}

