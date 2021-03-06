public class Rental
{
	private Movie movie;
	int daysRented;
	
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public String getMovieTitle() {
		return movie.getTitle();
	}
	
	double determineAmount() {
		return movie.determineAmount(daysRented);
	}
	
	int determineFrequentRenterPoints() {
		return movie.determineFrequentRenterPoints(daysRented);
	}
}