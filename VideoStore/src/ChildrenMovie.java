
public class ChildrenMovie extends Movie {
	public ChildrenMovie(String title) {
		super(title);
	}

	double determineAmount(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 1.5;
		return thisAmount;
	}

	int determineFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
