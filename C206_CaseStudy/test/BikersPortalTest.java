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
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Bike arraylist to retrieve item from", bikeList);

		// test if the list ofBike retrieved from the SourceCentre is empty - boundary
		String allBike = BikersPortal.viewBike(bikeList);
		String testOutput = String.format("%-10s %-20s %-10s %-15s %-10s %-20s\n", "ID", "NAME", "PRICE", "AVAILABLE",
				"COLOUR", "BIKE TYPE");
		assertEquals("Test that the retrieved Bikelist is empty?", testOutput, allBike);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		BikersPortal.addBike(bikeList, bi1);
		BikersPortal.addBike(bikeList, bi2);
		BikersPortal.addBike(bikeList, bi3);
		assertEquals("Test that Bike arraylist size is 3", 3, bikeList.size());

		// test if the expected output string same as the list of Bike retrieved from
		// the SourceCentre
		allBike = BikersPortal.viewBike(bikeList);
		testOutput = String.format("%-10s %-20s %-10s %-15s %-10s %-20s\n", "ID", "NAME", "PRICE", "AVAILABLE",
				"COLOUR", "BIKE TYPE");

		testOutput += String.format("%-10s %-20s $%-10.2f %-15b %-10s %-20s\n", "B001", "bike1", 200.50, true, "red",
				"Mountain Bike");
		testOutput += String.format("%-10s %-20s $%-10.2f %-15b %-10s %-20s\n", "B002", "bike2", 300.70, true, "black",
				"Road Bike");
		testOutput += String.format("%-10s %-20s $%-10.2f %-15b %-10s %-20s\n", "B003", "bike3", 150.67, true, "white",
				"Folding Bike");
		assertEquals("Test that VIewBike", testOutput, allBike);

	}

	@Test
	public void testViewAppointment() {
//
		// Item list is not null, so that we can add a new item
		assertNotNull("Test if there is a valid Appointment arraylist to add to", appointmentList);

		// Test if the list of Appointment retrieved from the AppMain is empty
		assertEquals("Check that appointmentList is empty at the start", 0, appointmentList.size());

		// Given an empty list, after adding 4 items, test if the size of the list is 4
		BikersPortal.addAppointment(appointmentList, a1);
		BikersPortal.addAppointment(appointmentList, a2);
		BikersPortal.addAppointment(appointmentList, a3);
		BikersPortal.addAppointment(appointmentList, a4);

		assertEquals("Test if that Appointment arraylist size is 4?", 4, appointmentList.size());

		String expectoutput = String.format("%-5s %s\n", "ID", "APPOINTMENT DATE");
		expectoutput += String.format("%-5s %s\n", "A001", LocalDate.of(2022, 7, 10));
		expectoutput += String.format("%-5s %s\n", "A002", LocalDate.of(2022, 11, 11));
		expectoutput += String.format("%-5s %s\n", "A003", LocalDate.of(2022, 12, 12));
		expectoutput += String.format("%-5s %s\n", "A004", LocalDate.of(2023, 2, 8));

	}

	@Test
	public void testAddAppointment() {
		assertNotNull("check if appointment is valid to be added in the appointmentList", appointmentList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		BikersPortal.addAppointment(appointmentList, a1);
		assertEquals("Check that Appointment arraylist size is 1", 1, appointmentList.size());
		assertSame("Check that Appointment is added", a1, appointmentList.get(0));

		// (boundary) test if all elements are added or not.
		BikersPortal.addAppointment(appointmentList, a2);
		BikersPortal.addAppointment(appointmentList, a3);
		assertEquals("Check that Appointment arraylist size is 3", 3, appointmentList.size());

	}

	@Test
	public void testDeleteAppointment() {
		assertNotNull("check if appointment is valid to be added in the appointmentList", appointmentList);
		appointmentList.add(a1);
		appointmentList.add(a2);
		BikersPortal.delAppointment(appointmentList, a1);
		// (normal) deleting a Appointment and check if the size of the list is 1;
		assertEquals("Check that Appointment arraylist size is 1", 1, appointmentList.size());

		// (Boundary) deleting a2 and check if list size = 0
		BikersPortal.delAppointment(appointmentList, a2);
		assertEquals("Check that Appointment arraylist size is 0", 0, appointmentList.size());
	}

	@Test
	public void testViewBikePart() {
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Bike part arraylist to retrieve item from", bikePartList);

		// test if the list of Bike parts retrieved from the SourceCentre is empty -
		// boundary
		String allBikeParts = BikersPortal.viewBikeParts(bikePartList);
		String testOutput = String.format("%-5s %-30s %-10s %-15s %s\n", "ID", "NAME", "PRICE", "AVAILABILITY",
				"PART_TYPE");
		assertEquals("Test that the retrieved Bikelist is empty?", testOutput, allBikeParts);

		// Given an empty list, after adding 3 items, test if the size of the list is 3
		// - normal
		BikersPortal.addBikePart(bikePartList, bp1);
		BikersPortal.addBikePart(bikePartList, bp2);
		BikersPortal.addBikePart(bikePartList, bp3);
		assertEquals("Test that Bike part arraylist size is 3", 3, bikePartList.size());

		// test if the expected output string same as the list of Bike parts retrieved
		// from
		// the SourceCentre
		allBikeParts = BikersPortal.viewBikeParts(bikePartList);
		testOutput = String.format("%-5s %-30s %-10s %-15s %s\n", "ID", "NAME", "PRICE", "AVAILABILITY", "PART_TYPE");
		testOutput += String.format("%-5s %-30s %-10.1f %-15s %s\n", "BP001", "Cadex 65", 1000.0, true, "Bike Wheel");
		testOutput += String.format("%-5s %-30s %-10.1f %-15s %s\n", "BP002", "Polygon Xtrada 5 frame", 500.0, true,
				"Bike Frame");
		testOutput += String.format("%-5s %-30s %-10.1f %-15s %s\n", "BP003", "Wake", 80.0, true, "Bike handle bar");

		assertEquals("Test that View Bike Part is shown", testOutput, allBikeParts);
	}

	@Test
	public void testAddBikePart() {
		assertNotNull("Test if there is a valid Bike Part arraylist to add to", bikePartList);

		// Adding 1 item, should increase the size of the list to 1
		BikersPortal.addBikePart(bikePartList, bp1);
		assertEquals("Test if that Bike Part arraylist size is 1?", 1, bikePartList.size());

		// The item added is same as the first item of the list
		assertSame("Test that the Bike Part added is the same as the 1st item of the list?", bp1, bikePartList.get(0));

		// Add another 2 items. test The size of the list is 3? (boundary)
		// The last item added is the same as the last item of the list?
		BikersPortal.addBikePart(bikePartList, bp2);
		BikersPortal.addBikePart(bikePartList, bp3);
		assertEquals("Test that Bike Part arraylist size is 3?", 3, bikePartList.size());
		assertSame("Test that the Bike Part last added is the same as 3rd item of the list?", bp3, bikePartList.get(2));
	}

	@Test
	public void testDeleteBikePart() {
		// Item list is not null, so that we can delete a new item
		assertNotNull("Test if there is a valid Bike Part arraylist to delete from", bikePartList);

		// (normal) - 3 elements in ArrayList, check if 1 of them deleted and the size
		// is 2.
		BikersPortal.addBikePart(bikePartList, bp1);
		BikersPortal.addBikePart(bikePartList, bp2);
		BikersPortal.addBikePart(bikePartList, bp3);

		BikersPortal.deleteBikePart(bikePartList, bp1);

		assertEquals("Test if that Bike Part arraylist size is 2?", 2, bikePartList.size());

		// (normal)

		// Delete the item, and test if the size of the list is 0(boundary)
		BikersPortal.deleteBikePart(bikePartList, bp2);
		BikersPortal.deleteBikePart(bikePartList, bp3);
		assertEquals("Test if that Bike Part arraylist size is 0?", 0, bikePartList.size());
	}

	@Test
	public void testViewAllBuyer() {
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Buyer arraylist to retrieve item from", buyerList);

		// test if the list of Buyer is retrieved from the SourceCentre is empty -
		// boundary
		String allBuyer = BikersPortal.viewAllBuyers(buyerList);
		String testOutput = String.format("%-10s %-10s %-10s\n", "ID", "NAME", "MOBILE NUMBER");
		assertEquals("Test that the retrieved buyerlist is empty?", testOutput, allBuyer);

		// Given an empty list, after adding 3 items, test if the size of the list is 3
		// - normal
		BikersPortal.addBuyer(buyerList, b1);
		BikersPortal.addBuyer(buyerList, b2);
		BikersPortal.addBuyer(buyerList, b3);
		assertEquals("Test that Bike arraylist size is 3", 3, buyerList.size());

		// test if the expected output string same as the list of Buyer retrieved from
		// the SourceCentre
		allBuyer = BikersPortal.viewAllBuyers(buyerList);
		testOutput = String.format("%-10s %-10s %-10s\n", "ID", "NAME", "MOBILE NUMBER");
		testOutput += String.format("%-10s %-10s %-10d\n", "B001", "Mary", 83214567);
		testOutput += String.format("%-10s %-10s %-10d\n", "B002", "John", 98765432);
		testOutput += String.format("%-10s %-10s %-10d\n", "B003", "Timmy", 83214567);
		assertEquals("Test that view all buyer is shown", testOutput, allBuyer);
	}

	@Test
	public void testDeleteBuyer() {
		// Item list is not null, so that we can delete a new item
		assertNotNull("Test if there is a valid Bike arraylist to delete from", buyerList);

		// After adding 1 item, test if the size of the list is 1
		BikersPortal.addBuyer(buyerList, b1);
		assertEquals("Test if that Bike arraylist size is 1?", 1, buyerList.size());

		// Delete the item, and test if the size of the list is 0
		BikersPortal.deletebuyer(buyerList, b1); // Requires user input in console
		assertEquals("Test if that Bike arraylist size is 0?", 0, buyerList.size());
	}

	@Test
	public void testAddBuyer() {
// Item list is not null, so that can add a new Buyer to listing - boundary
		assertNotNull("Check if there is valid Bike arraylist to add to", buyerList);
// Given an empty list, after adding 1 Buyer listing, the size of the list is 1 -
// normal
// The item just added is as same as the first Buyer to listing of the list
		BikersPortal.addBuyer(buyerList, b1);
		assertEquals("Check that Bike arraylist size is 1", 1, buyerList.size());

// Add another Buyer to listing. test The size of the list is 2? -normal
// The Buyer to listing just added is as same as the second item of the list
		BikersPortal.addBuyer(buyerList, b2);
		assertEquals("Check that Buyer arraylist size is 2", 2, buyerList.size());
		assertSame("Check that Buyer is added", b2, buyerList.get(1));
	}
}
