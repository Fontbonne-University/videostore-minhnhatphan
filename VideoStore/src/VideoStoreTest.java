import junit.framework.*;

public class VideoStoreTest extends TestCase
{
	private Customer customer;
	private Movie newReleaseMovie1;
	private Movie newRealeaseMovie2;
	private Movie childrenMovie;
	private Movie regularmovie1;
	private Movie regularMovie2;
	private Movie regularMovie3;
	
	public VideoStoreTest(String name) {
		super(name);
	}
	
	protected void setUp ()  {
		customer = new Customer ("Fred");
		newReleaseMovie1 = new NewReleaseMovie("The Cell");
		newRealeaseMovie2 = new NewReleaseMovie("The Tigger Movie");
		childrenMovie = new ChildrenMovie("The Tigger Movie");
		regularmovie1 = new RegularMovie("Plan 9 from Outer Space");
		regularMovie2 = new RegularMovie("8 1/2");
		regularMovie3 = new RegularMovie("Eraserhead");
	}
	
	public void testSingleNewReleaseStatement() {
		
		customer.addRental(new Rental(newReleaseMovie1, 3));		
		assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.generateStatement());
	}

	public void testDualNewReleaseStatement() {
		customer.addRental(new Rental(newReleaseMovie1, 3));
		customer.addRental(new Rental(newRealeaseMovie2, 3));
		assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.generateStatement());
	}

	public void testSingleChildrensStatement () {
		customer.addRental(new Rental(childrenMovie, 3));
		assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.generateStatement());
	}
	
	public void testMultipleRegularStatement () {
		
		customer.addRental(new Rental(regularmovie1, 1));
		customer.addRental(new Rental(regularMovie2, 2));
		customer.addRental(new Rental(regularMovie3, 3));
		
		assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.generateStatement());
	}

}