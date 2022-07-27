package extractor;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import imdb.ImdbMovie;

public class ImdbExtractor {
	
	public List<ImdbMovie> data (String json) {
		
		try {
			
			List<Map<String, String>> data = (new JsonParser()).parse(json);
			List<ImdbMovie> movies = new ArrayList<>();
			
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
			return movies;
			
		} catch(MalformedURLException | ParseException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
