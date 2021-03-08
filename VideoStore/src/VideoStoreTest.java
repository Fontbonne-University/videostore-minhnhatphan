import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VideoStoreTest
{
	private Statement statement;
	private final double DELTA=0.001;
	private Movie newReleaseMovie1;
	private Movie newRealeaseMovie2;
	private Movie childrenMovie;
	private Movie regularmovie1;
	private Movie regularMovie2;
	private Movie regularMovie3;
	
	
	@Before
	public void setUp ()  {
		statement = new Statement ("Customer");
		newReleaseMovie1 = new NewReleaseMovie("New Release 1");
		newRealeaseMovie2 = new NewReleaseMovie("New Release 2");
		childrenMovie = new ChildrenMovie("Childrens"); 
		regularmovie1 = new RegularMovie("Regular 1");
		regularMovie2 = new RegularMovie("Regular 2");
		regularMovie3 = new RegularMovie("Regular 3");
	}
	
	@Test
	public void testSingleNewReleaseStatementTotals(){
		statement.addRental(new Rental(newReleaseMovie1, 3));
		statement.generate();
		assertEquals(9.0, statement.getTotal(), DELTA);
		assertEquals(2, statement.getfrequentRenterPoints());
	}
	
	@Test
	public void testDualNewReleaseStatementTotals(){
		statement.addRental(new Rental(newReleaseMovie1, 3));
		statement.addRental(new Rental(newRealeaseMovie2, 3));
		statement.generate();
		assertEquals(18.0, statement.getTotal(), DELTA);
		assertEquals(4, statement.getfrequentRenterPoints());
	}
	
	@Test
	public void testSingleChildrensStatementTotals(){
		statement.addRental(new Rental(childrenMovie, 3));
		statement.generate();
		assertEquals(1.5, statement.getTotal(), DELTA);
		assertEquals(1, statement.getfrequentRenterPoints());
	}
	
	@Test
	public void testMultipleRegularStatementTotals(){
		statement.addRental(new Rental(regularmovie1, 1));
		statement.addRental(new Rental(regularMovie2, 2));
		statement.addRental(new Rental(regularMovie3, 3));
		statement.generate();
		assertEquals(7.5, statement.getTotal(), DELTA);
		assertEquals(3, statement.getfrequentRenterPoints());
	}
	
	@Test
	public void testMultipleRegularStatementFormat(){
		statement.addRental(new Rental(regularmovie1, 1));
		statement.addRental(new Rental(regularMovie2, 2));
		statement.addRental(new Rental(regularMovie3, 3));
		
		assertEquals("Rental Record for Customer\n"
				+ "\tRegular 1\t2.0\n"
				+ "\tRegular 2\t2.0\n"
				+ "\tRegular 3\t3.5\n"
				+ "You owed 7.5\n"
				+ "You earned 3 frequent renter points\n", statement.generate());
	}

}