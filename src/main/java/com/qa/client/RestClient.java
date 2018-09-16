package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	public void get(String url) throws ClientProtocolException, IOException {
		
		// Create an httpclient with which request will be made 
		CloseableHttpClient  httpClient = HttpClients.createDefault(); 
		//create a http get request 
		HttpGet httpGet = new HttpGet(url);
		//execute the get request using http client and store the response
		CloseableHttpResponse httpResponse =  httpClient.execute(httpGet);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is "+statusCode);
		String responseString = EntityUtils.toString(httpResponse.getEntity());
		JSONObject jsonObject = new JSONObject(responseString); 
		System.out.println("JSON object is "+jsonObject);
		
		Header[] headers = httpResponse.getAllHeaders(); 
		HashMap<String, String> allHeadersMap = new HashMap<String, String>(); 
		for(Header header : headers) {
			allHeadersMap.put(header.getName(), header.getValue()); 
			System.out.println(header.getName() + " : "+ header.getValue());
		}
		
		
		
	}
	
}
