package HttpRestClient.HttpRestClient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.client.RestClient;
import com.restapi.TestBase;

public class Test1 extends TestBase{

	TestBase testBase; 
	String serviceURL;
	String apiURL; 
	String url; 
	RestClient restClient;
	
	@BeforeMethod
	public void Setup() {
		testBase = new TestBase(); 
		serviceURL = prop.getProperty("URL"); 
		apiURL = prop.getProperty("serviceURL"); 
		url = serviceURL + apiURL; 
	}
	
	@Test
	public void getApiTest() throws ClientProtocolException, IOException {
		restClient = new RestClient(); 
		restClient.get(url);
	}
	
	
	
	
}
