package entertaimentContent.imdb;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import entertaimentContent.Content;

public class ImdbMovie extends Content {
	
	private String id;
	private Integer rank;
	private String fullTitle;
	private String[] crew;
	private Date year;
	private Double imdbRatingCount;
	private Double imdbRating;

	public ImdbMovie(String id, Integer rank, String title, String fullTitle, URL imageUrl, String[] crew, Date year, Double imdbRating, Double imdbRatingCount) throws IOException {
		super(title, imageUrl, imdbRating);
		this.id = id;
		this.rank = rank;
		this.fullTitle = fullTitle;
		this.crew = crew;
		this.year = year;
		this.imdbRatingCount = imdbRatingCount;
		this.imdbRating = imdbRating;
	}

	public String getId() {
		return id;
	}

	public Integer getRank() {
		return rank;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public String[] getCrew() {
		return crew;
	}

	public Date getYear() {
		return year;
	}

	public Double getImdbRatingCount() {
		return imdbRatingCount;
	}
	
	public Double getImdbRating() {
		return imdbRating;
	}
	
}
