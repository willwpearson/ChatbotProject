package chat.model;

import java.time.LocalDate;

public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	/**
	 * Initializes the data members needed.
	 */
	public Movie(String title)
	{
		this.title = "";
		this.genre = "";
		this.ratingMPAA = "";
		this.review = "";
		this.length = 0;
		this.releaseDate = null;
		this.starScore = Double.NaN;
	}

	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getRatingMPAA()
	{
		return ratingMPAA;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return length;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
	}

	public void setReview(String review)
	{
		this.review = review;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	public String toString()
	{
		String description = "This movie is titled " + title + " and is in the genre " + genre + ". This movie got a rating of " + ratingMPAA + " and has this review: " + review + ". This movie has a length of " + length + " and was released on " + releaseDate + "."; 
	
		return description;
	}
}
