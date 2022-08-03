import java.util.ArrayList;

public class BikersPortal {
	    ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
	    ArrayList<Bike> bikeList = new ArrayList<Bike>();
	    ArrayList<BikePart> bikePartList = new ArrayList<BikePart>();
	    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	    ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
	    
//	    buyerList.add(new Buyer(""));
	  
	    
	    
	

	public static void main(String[] args) {
		BikersPortal bp = new BikersPortal();
		bp.start();

	}
	private void start() {
		int option = 0;
		
	while(option != 6) {
		menu();
		if(option == 1 ) {}
		else if(option == 2) {}
		else if(option == 3) {}
		else if(option == 4) {}
		else if(option == 5) {}
		else if(option == 6) {}
		else {}
	}
	}

	private void menu() {
		Helper.line(80, "=");
		System.out.println("BIKERS PORTAL");
		Helper.line(80, "=");
		
		System.out.println("1. Buyer");
		System.out.println("2. Bike");
		System.out.println("3. Bike Parts");
		System.out.println("4. Appointment");
		System.out.println("5. Feedback");
		System.out.println("6. Quit");
	}
}
	
	//Student 1
	//student 2
	//student 3
	//student 4
//	System.out.println("1. View Appointments");
//    System.out.println("2. Create Appointment");
//    System.out.println("3. Update Appointment Information");
//    System.out.println("4. Delete Appointment");
//    System.out.println("5. Search Appointment by Date");
//    System.out.println("6. Search Appointment by Buyer's ID");
//    
//    int option = Helper.readInt("Enter an option > ");
//    
//    if (option == 1) {
//    	viewAllAppointment(appointmentList);
//    }
//    else if (option == 2) {
//    	
//    }
//	//student 5
//	
//
//}