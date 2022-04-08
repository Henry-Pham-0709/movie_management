package sait.mms.problemdomain;

public class Movie {
	private int id;
	private int duration;
	private String title;
	private int year;

	/**
	 * Default constructor
	 */
	public Movie() {

	}

	/**
	 * Constructor for a movie
	 * 
	 * @param id
	 * @param duration
	 * @param title
	 * @param year
	 */
	public Movie(int id, int duration, String title, int year) {
		this.id = id;
		this.duration = duration;
		this.title = title;
		this.year = year;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", duration=" + duration + ", title=" + title + ", year=" + year + "]";
	}

}
