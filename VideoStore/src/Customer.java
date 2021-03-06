import java.util.List;
import java.util.ArrayList;

public class Customer 
{
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	private double totalAmount;
	private int	frequentRenterPoints;
	public Customer(String name){
		this.name = name;
	}
	
	public void addRental(Rental rental) {
		rentals.add(rental);
	}
	
	public String getName() {
		return name;
	}
	
	public String generateStatement() {
		clearTotal();
		String statementText = header();
		statementText += rentalLines();
		statementText += footer();
		return statementText;
	}
	
	private void clearTotal() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}

	private String header() {
		return String.format("Rental Record for %s\n", name);
	}
	
	private String rentalLines() {
		String rentalLines = "";
		for(Rental rental: rentals) 
			rentalLines += rentalLine(rental);
		
		return rentalLines;
	}
	
	private String footer() {
		return String.format("You owed %.1f\nYou earned %d frequent renter points\n", totalAmount, frequentRenterPoints);
	}

	private String rentalLine(Rental rental) {
		double thisAmount = rental.determineAmount();
		frequentRenterPoints += rental.determineFrequentRenterPoints();
		totalAmount += thisAmount;
		
		return formatRentalLine(rental, thisAmount);
	}

	private String formatRentalLine(Rental rental, double thisAmount) {
		return String.format("\t%s\t%.1f\n", rental.getMovieTitle(),thisAmount);
	}
}