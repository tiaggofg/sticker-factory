package entertaimentContent;

import java.net.URL;

public abstract class Content {

	private String title;
	private URL imageUrl;
	private Double rating;
	
	public Content (String title, URL imageUrl, Double rating) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.rating = rating;
	}
	
	public String getTitle() {
		return title;
	}
	
	public URL getImageUrl() {
		return imageUrl;
	}
	
	public Double getRating() {
		return rating;
	}
}
