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
	    
		 buyerList.add(new Buyer("B001", "Mary", 83214567));
		    buyerList.add(new Buyer("B002", "John", 98765432));
		    buyerList.add(new Buyer("B003", "Timmy", 83214567));

		    bikeList.add(new Bike("B001", "bike1", 200.50, "red", "Mountain Bike"));
		    bikeList.add(new Bike("B002", "bike2", 300.70,"black", "Road Bike"));
		    bikeList.add(new Bike("B003", "bike3", 150.67,"white", "Folding Bike"));

		    bikePartList.add(new BikePart("BP001", "Cadex 65", 1000,"Bike Wheel"));
		    bikePartList.add(new BikePart("BP002", "Polygon Xtrada 5 frame", 500,"Bike Frame"));
		    bikePartList.add(new BikePart("BP003", "Wake", 80,"Bike handle bar"));

		    appointmentList.add(new Appointment("A001", LocalDate.of(2022, 7, 10)));
		    appointmentList.add(new Appointment("A002", LocalDate.of(2022, 11, 11)));
		    appointmentList.add(new Appointment("A003", LocalDate.of(2022, 12, 12)));
		    appointmentList.add(new Appointment("A004", LocalDate.of(2023, 2, 8)));
		    
		    feedbackList.add(new Feedback());
		    
		int option = 0;
		
	while(option != 6) {
		menu();
		//Buyer
		if(option == 1 ) {}
		//Bike
		else if(option == 2) {
			bikeMenu();
			int subOption = Helper.readInt("Enter option > ");
			if (subOption == 1) {
				viewBike();
			} else if (subOption == 2) {
				createBike();
			} else if (subOption == 3) {
				delBike();
			} else if (subOption == 4) {
				System.out.println("***TBC***");
			} else {
				System.out.println("Invalid Option");
			}
		}
		//Bike Part
		else if(option == 3) {
			
		}
		//Appointment
		else if(option == 4) {
			appointmentMenu();
	        appointment(appointmentList);
		}
		//Feedback
		else if(option == 5) {
			
		}
		//Quit
		else if(option == 6) {
			System.out.println("Thank you for using Bikers Portal!");
		}
		//Invalid
		else {
			System.out.println("Invalid Option");
		}
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
		System.out.println("3. Delete bike listing");
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
	
	private void createBike() {
		String id = Helper.readString("Enter ID > ");
		String name = Helper.readString("Enter Bike Name > ");
		double price = Helper.readDouble("Enter bike price > ");
		String colour = Helper.readString("Enter bike colour > ");
		String type = Helper.readString("Enter bike type > ");
		
		bikeList.add(new Bike(id, name, price, colour, type));
		System.out.println("Bike added!");
		
	}
	
	private void delBike() {
		String idSearch = Helper.readString("Enter id to delete > ");
		for(Bike b: bikeList) {
			if(b.getId().equalsIgnoreCase(idSearch)) {
				bikeList.remove(b);
				System.out.println("Bike deleted");
				break;
			}
		}
	}
		  private void appointmentMenu() {
		    System.out.println("1. View Appointments");
		    System.out.println("2. Create Appointment");
		    System.out.println("3. Update Appointment Information");
		    System.out.println("4. Delete Appointment");
		    System.out.println("5. Search Appointment by Date");
		    System.out.println("6. Search Appointment by Buyer's ID");
		  }

		  private void appointment(ArrayList<Appointment> appointmentList) {
		    int option = Helper.readInt("Enter an option > ");

		    if (option == 1) {
		    	//View
		      viewAllAppointments(appointmentList);

		    } else if (option == 2) {
		    	//add
		      createAppointment(appointmentList);

		    } else if (option == 3) {
		      // update
		      String id = Helper.readString("Enter a id");
		      for (Appointment i : appointmentList) {
		        if (i.getAppID().equalsIgnoreCase(id)) {
		          LocalDate date = Helper.readLocalDate("Enter a date");
		          i.setAppDate(date);
		          break;
		        }
		      }
		    } else if (option == 4) {
		      // delete
		      String id = Helper.readString("Enter a id");
		      for (int i = 0; i < appointmentList.size(); i++) {
		        if (appointmentList.get(i).getAppID().equalsIgnoreCase(id)) {
		          appointmentList.remove(i);
		          break;
		        }

		      }

		    } else if (option == 5) {
		    	//search
		      searchAppointmentByDate(appointmentList);

		    } else if (option == 6) {
		    	//update
		      searchAppointmentByID(appointmentList);
		    } else {
		      System.out.println("Invalid input.");
		    }
		  }

		// view appointment
		  public static void viewAllAppointments(ArrayList<Appointment> appointmentList) {
		    System.out.println("Appointment");
		    String output = String.format("%-5s %s\n", "ID", "APPOINTMENT DATE");

		    for (int i = 0; i < appointmentList.size(); i++) {
		      output += String.format("%-5s %s\n", appointmentList.get(i).getAppID(),
		          appointmentList.get(i).getAppDate());
		    }
		    System.out.println(output);
		  }

		  // create appointment
		  public static void createAppointment(ArrayList<Appointment> appointmentList) {
		    String id = Helper.readString("Enter id > ");
		    String apptDate = Helper.readString("Enter appointment date (yyyy-MM-dd) > ");

		    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    LocalDate apptDateLD = LocalDate.parse(apptDate, dtf);
		    appointmentList.add(new Appointment(id, apptDateLD));
		  }

		  // search appointment
		  public static void searchAppointmentByDate(ArrayList<Appointment> appointmentList) {
		    boolean isFound = false;
		    String output = String.format("%-5s %s\n", "ID", "APPOINTMENT DATE");
		    LocalDate date = Helper.readLocalDate("Enter Date of Appointment > ");
		    for (Appointment i : appointmentList) {
		      if (i.getAppDate() == date) {
		        output += String.format("%-5s %s\n", i.getAppID(), i.getAppDate());
		        isFound = true;
		      }
		    }
		    if (isFound) {
		      System.out.println(output);
		    } else {
		      System.out.println("No Records Found.");
		    }
		  }

		  public static void searchAppointmentByID(ArrayList<Appointment> appointmentList) {
		    boolean isFound = false;
		    String output = String.format("%-5s %s\n", "ID", "APPOINTMENT DATE");
		    String id = Helper.readString("Enter Appointment ID > ");
		    for (Appointment i : appointmentList) {
		      if (i.getAppID().equalsIgnoreCase(id)) {
		        output += String.format("%-5s %s\n", i.getAppID(), i.getAppDate());
		        isFound = true;
		      }
		    }
		    if (isFound) {
		      System.out.println(output);
		    } else {
		      System.out.println("No Records Found.");
		    }
		  }

}