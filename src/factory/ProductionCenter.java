package factory;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import entertaimentContent.Content;
import extractor.ImdbExtractor;
import http.MyHttpClient;

public class ProductionCenter {

	public static void main(String[] args) throws ParseException, MalformedURLException {

		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		String json  = MyHttpClient.getContent(url);
		ImdbExtractor extractor = new ImdbExtractor();
		
		List<Content> movies = extractor.data(json);
		
		for (int k = 1; k < 10; k++) {
			var imageUrl = movies.get(k).getImageUrl();
			var title = movies.get(k).getTitle();
			var rating = movies.get(k).getRating();
			
			StickerGenerator.producer(imageUrl, title, rating);
			System.out.println(title + "\n");
			//System.out.println(rating.get);
			
		}
		
	}

}