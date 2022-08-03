import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BikersPortal {
	
	   private ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
	   private ArrayList<Bike> bikeList = new ArrayList<Bike>();
	   private ArrayList<BikePart> bikePartList = new ArrayList<BikePart>();
	   private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	   private ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();   

	public static void main(String[] args) {
		BikersPortal bp = new BikersPortal();
		bp.start();

	}
	private void start() {
		ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
	    ArrayList<Bike> bikeList = new ArrayList<Bike>();
	    ArrayList<BikePart> bikePartList = new ArrayList<BikePart>();
	    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	    ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
	    
	    buyerList.add(new Buyer("B001", "Mary", 83214567));
	    buyerList.add(new Buyer("B002", "John", 98765432));
	    buyerList.add(new Buyer("B003", "Timmy", 83214567));
	    
	    bikeList.add(new Bike("B001", "Mountain bike", 200.50, "red", ""));
		int option = 0;
		int subOption = 0;
		
	while(option != 6) {
		menu();
		if(option == 1 ) {}
		else if(option == 2) {
			bikeMenu();
			if (subOption == 1) {
				viewBike();
			} else if (subOption == 2) {

			} else if (subOption == 3) {

			} else if (subOption == 4) {

			} else {
				System.out.println("Invalid Option");
			}
		}
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
	
	//Student 1
	//student 2
	private void bikeMenu() {
		Helper.line(80, "=");
		System.out.println("BIKE LISTING");
		Helper.line(80, "=");
		System.out.println("1. View bike listing");
		System.out.println("2. Add bike listing");
		System.out.println("3. Edit bike listing");
		System.out.println("4. Edit bike listing");
	}
	private void viewBike() {
		String output = String.format("%-10s %-20s %-10s %-15s", "ID", "NAME", "PRICE", "AVAILABLE", "COLOUR",
				"BIKE TYPE");
		for (Bike b : bikeList) {
			output += b.getListing();
		}
		System.out.println(output);
	}

	//student 3
	//student 4
	System.out.println("1. View Appointments");
    System.out.println("2. Create Appointment");
    System.out.println("3. Update Appointment Information");
    System.out.println("4. Delete Appointment");
    System.out.println("5. Search Appointment by Date");
    System.out.println("6. Search Appointment by Buyer's ID");
    
    int option = Helper.readInt("Enter an option > ");
    
    if (option == 1) {
    	viewAllAppointment(appointmentList);
    }
    else if (option == 2) {
    	Appointment newAppointment = newAppoint();
        addAppointment(appointmentList, newAppointment);
    }
    else if (option == 3) {
        System.out.println("## Not Coded ##");
        //TODO
      }
      else if (option == 4) {
        System.out.println("## Not Coded ##");
        //TODO
      }
      else if (option == 5) {
        searchAppointmentByDate(appointmentList);
      }
      else if (option == 6) {
        searchAppointmentByID(appointmentList);
      }
      else {
        System.out.println("Invalid input.");
      }
    }
  //create appointment
    public static Appointment newAppoint() {
        String id = Helper.readString("Enter id > ");
        String apptDate = Helper.readString("Enter appointment date (yyyy-MM-dd) > ");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate apptDateLD = LocalDate.parse(apptDate, dtf);

        Appointment newAppointment = new Appointment(id, apptDateLD);
        return newAppointment;
      }
      
      public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment newAppointment) {
        appointmentList.add(newAppointment);
        System.out.println("New appointment has been successfully added.");
      }
      
//	//student 5
//	
//
//}