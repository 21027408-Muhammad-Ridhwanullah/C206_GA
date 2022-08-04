import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BikersPortalTest {

	private ArrayList<Buyer> buyerList;
	private ArrayList<Bike> bikeList;
	private ArrayList<BikePart> bikePartList;
	private ArrayList<Appointment> appointmentList;

	private Buyer b1;
	private Buyer b2;
	private Buyer b3;

	private Bike bi1;
	private Bike bi2;
	private Bike bi3;

	private BikePart bp1;
	private BikePart bp2;
	private BikePart bp3;

	private Appointment a1;
	private Appointment a2;
	private Appointment a3;
	private Appointment a4;

	@Before
	public void setUp() throws Exception {

		buyerList = new ArrayList<Buyer>();
		bikeList = new ArrayList<Bike>();
		bikePartList = new ArrayList<BikePart>();
		appointmentList = new ArrayList<Appointment>();

		b1 = new Buyer("B001", "Mary", 83214567);
		b2 = new Buyer("B002", "John", 98765432);
		b3 = new Buyer("B003", "Timmy", 83214567);

		bi1 = new Bike("B001", "bike1", 200.50, "red", "Mountain Bike");
		bi2 = new Bike("B002", "bike2", 300.70, "black", "Road Bike");
		bi3 = new Bike("B003", "bike3", 150.67, "white", "Folding Bike");

		bp1 = new BikePart("BP001", "Cadex 65", 1000, "Bike Wheel");
		bp2 = new BikePart("BP002", "Polygon Xtrada 5 frame", 500, "Bike Frame");
		bp3 = new BikePart("BP003", "Wake", 80, "Bike handle bar");

		a1 = new Appointment("A001", LocalDate.of(2022, 7, 10));
		a2 = new Appointment("A002", LocalDate.of(2022, 11, 11));
		a3 = new Appointment("A003", LocalDate.of(2022, 12, 12));
		a4 = new Appointment("A004", LocalDate.of(2023, 2, 8));

	}

	@After
	public void tearDown() throws Exception {
		buyerList = null;
		bikeList = null;
		bikePartList = null;
		appointmentList = null;

		b1 = null;
		b2 = null;
		b3 = null;

		bi1 = null;
		bi2 = null;
		bi3 = null;

		bp1 = null;
		bp2 = null;
		bp3 = null;

		a1 = null;
		a2 = null;
		a3 = null;
		a4 = null;
	}

	@Test
	public void testAddBike() {
		// Item list is not null, so that can add a new bike listing - boundary
		assertNotNull("Check if there is valid Bike arraylist to add to", bikeList);
		// Given an empty list, after adding 1 bike listing, the size of the list is 1 -
		// normal
		// The item just added is as same as the first bike listing of the list
		BikersPortal.addBike(bikeList, bi1);
		assertEquals("Check that Bike arraylist size is 1", 1, bikeList.size());

		// Add another bike listing. test The size of the list is 2? -normal
		// The bike listing just added is as same as the second item of the list
		BikersPortal.addBike(bikeList, bi2);
		assertEquals("Check that Bike arraylist size is 2", 2, bikeList.size());
		assertSame("Check that Bike is added", bi2, bikeList.get(1));
	}

	@Test
	public void testDelBike() {
		assertNotNull("Check if there is valid Bike arraylist", bikeList);
		bikeList.add(bi1);
		bikeList.add(bi2);
		BikersPortal.delBike(bikeList, bi1);
		// (normal) deleting a Bike listing and check if the size of the list is 1;
		assertEquals("Check that Bike arraylist size is 1", 1, bikeList.size());

		// (boundary) deleting bi2 bike to check if arraylist size is 0;
		BikersPortal.delBike(bikeList, bi2);
		assertEquals("Check that Bike arraylist size is 0", 0, bikeList.size());
	}

	@Test
	public void testViewBike() {

	}

}
