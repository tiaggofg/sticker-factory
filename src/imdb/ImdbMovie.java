package imdb;

import java.net.URL;
import java.util.Date;

public class ImdbMovie {
	
	private String id;
	private Integer rank;
	private String title;
	private String fullTitle;
	private URL imageUrl;
	private String[] crew;
	private Date year;
	private Float imdbRating;
	private Float imdbRatingCount;

	public ImdbMovie(String id, Integer rank, String title, String fullTitle, URL imageUrl, String[] crew, Date year, Float imdbRating, Float imdbRatingCount) {
		this.id = id;
		this.rank = rank;
		this.title = title;
		this.fullTitle = fullTitle;
		this.imageUrl = imageUrl;
		this.crew = crew;
		this.year = year;
		this.imdbRating = imdbRating;
		this.imdbRatingCount = imdbRatingCount;
	}

	public String getId() {
		return id;
	}

	public Integer getRank() {
		return rank;
	}

	public String getTitle() {
		return title;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public URL getImageUrl() {
		return imageUrl;
	}

	public String[] getCrew() {
		return crew;
	}

	public Date getYear() {
		return year;
	}

	public Float getImdbRating() {
		return imdbRating;
	}

	public Float getImdbRatingCount() {
		return imdbRatingCount;
	}
	
}
