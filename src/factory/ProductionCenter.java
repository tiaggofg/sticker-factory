package factory;

import java.net.MalformedURLException;
import java.util.List;

import entertaimentContent.Content;
import entertaimentContent.imdb.ImdbMovie;
import extractor.ImdbExtractor;
import http.MyHttpClient;

public class ProductionCenter {

	public static void main(String[] args) throws MalformedURLException {

		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		String json = MyHttpClient.getContent(url);
		ImdbExtractor extractor = new ImdbExtractor();
		List<Content> movies = extractor.data(json);
		
		UI.clearScreen();
		System.out.println("Gerando stickers para os filmes:" + "\n");
		for (int k = 1; k <= 250; k += 25) {
			var imageUrl = movies.get(k).getImageUrl();
			var title = movies.get(k).getTitle();
			var rating = movies.get(k).getRating();
			var imdbRating = ((ImdbMovie) movies.get(k)).getImdbRating();

			StickerGenerator.producer(imageUrl, title, rating);
			System.out.println(UI.ANSI_PURPLE_BACKGROUND + UI.ANSI_BLACK + title + UI.ANSI_RESET);
			System.out.println("Nota: " + imdbRating + "\n");
		}

	}

}