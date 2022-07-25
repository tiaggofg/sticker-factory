package application;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import imdb.ImdbMovie;

public class Program {

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		
		String url = "https://alura-imdb-api.herokuapp.com/movies";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		List<ImdbMovie> movies = new ArrayList<>();
		JsonParser parser = new JsonParser();
		List<Map<String, String>> data = parser.parse(body);
		
		for (Map<String, String> movie : data) {
			String id = movie.get("id");
			Integer rank = Integer.parseInt((movie.get("rank")));
			String title = movie.get("title");
			String fullTitle = movie.get("fullTitle");
			URL imageUrl = new URL(movie.get("image"));
			String[] crew = movie.get("crew").split(", ");
			Date year = (new SimpleDateFormat("yyyy")).parse(movie.get("year"));
			Float emdbRating = Float.parseFloat(movie.get("imDbRating"));
			Float emdbRatingCount = Float.parseFloat(movie.get("imDbRatingCount"));	
			movies.add(new ImdbMovie(id, rank, title, fullTitle, imageUrl, crew, year, emdbRating, emdbRatingCount));
		}
		
	}

}