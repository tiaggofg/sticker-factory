package entertaimentContent;

import java.io.IOException;
import java.net.URL;

import factory.classification.Rating;

public abstract class Content {

	private String title;
	private URL imageUrl;
	private Rating rating;
	
	public Content (String title, URL imageUrl, Double rating) throws IOException {
		this.title = title;
		this.imageUrl = imageUrl;
		this.rating = new Rating(rating);
	}
	
	public String getTitle() {
		return title;
	}
	
	public URL getImageUrl() {
		return imageUrl;
	}
	
	public Rating getRating() {
		return rating;
	}
	
}
