package extractor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import entertaimentContent.Content;
import entertaimentContent.imdb.ImdbMovie;

public class ImdbExtractor implements Extractor {
	
	public List<Content> data (String json) {
		
		try {
			
			List<Map<String, String>> data = (new JsonParser()).parse(json);
			List<Content> movies = new ArrayList<>();
			
			for (Map<String, String> movie : data) {
				String id = movie.get("id");
				Integer rank = Integer.parseInt((movie.get("rank")));
				String title = movie.get("title");
				String fullTitle = movie.get("fullTitle");
				String[] url = movie.get("image").split("._V", 0);
				URL imageUrl = new URL(url[0]);
				String[] crew = movie.get("crew").split(", ");
				Date year = (new SimpleDateFormat("yyyy")).parse(movie.get("year"));
				Double imdbRating = Double.parseDouble(movie.get("imDbRating"));
				Double imdbRatingCount = Double.parseDouble(movie.get("imDbRatingCount"));	
				try {
					movies.add(new ImdbMovie(id, rank, title, fullTitle, imageUrl, crew, year, imdbRating, imdbRatingCount));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return movies;
			
		} catch(MalformedURLException | ParseException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
