package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class MyHttpClient {
	
	public static String getContent (String url) {
		
		try {
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return response.body();
		
		} catch (IOException | InterruptedException e) {
			return e.getMessage();
		}
		
	}
	
}