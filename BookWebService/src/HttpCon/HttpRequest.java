package HttpCon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
	public static String getRespondFrom(String url_string) throws Exception {
		  
		  URL url = new URL(url_string);
		  HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		  
		  // Set the request method and properties
		  httpcon.setRequestMethod("GET");
		  httpcon.setRequestProperty("accept", "application/json");
		  
		  if (httpcon.getResponseCode() != 200) {
		   throw new RuntimeException("HttpURLConnectionError : " + httpcon.getResponseCode());
		  }
		  
//		  System.out.println("Response Code: " + httpcon.getResponseCode());
//		  System.out.println("Response Message: " + httpcon.getResponseMessage());
		  
		  BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));		  
		  String line;
		  StringBuilder Result = new StringBuilder();
		  while ((line = reader.readLine()) != null) {
			  Result.append(line);
		  }
		  return Result.toString();
		  
		 }
}
