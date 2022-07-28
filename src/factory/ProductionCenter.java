package factory;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import extractor.ImdbExtractor;
import httpClient.MyHttpClient;
import imdb.ImdbMovie;

public class ProductionCenter {

	public static void main(String[] args) throws ParseException, MalformedURLException {

		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		String json  = (new MyHttpClient()).getContent(url);
		var extractor = new ImdbExtractor();
		
		List<ImdbMovie> movies = extractor.data(json);

		
	}

}