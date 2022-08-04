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
		int subOption;
		
	while(option != 6) {
		menu();
		option = Helper.readInt("Enter option > ");
		//Buyer
		if(option == 1 ) {
			buyerMenu();
			subOption = Helper.readInt("Enter option > ");
			if (subOption == 1) {
				viewAllBuyers(buyerList);
			} else if (subOption == 2) {
				createnewbuyer(buyerList);
			} else if (subOption == 3) {
				deletebuyer(buyerList);
			} else if (subOption == 4) {
				System.out.println("***TBC***");
			} else if (subOption == 5) {
				System.out.println("***TBC***");
			}
			else {
				System.out.println("Invalid Option");
			}
		}
		//Bike
		else if(option == 2) {
			bikeMenu();
			subOption = Helper.readInt("Enter option > ");
			if (subOption == 1) {
				viewBike(bikeList);
			} else if (subOption == 2) {
				createBike();
			} else if (subOption == 3) {
				delBike(bikeList);
			} else if (subOption == 4) {
				System.out.println("***TBC***");
			} else if(subOption == 5) {
				System.out.println("***TBC***");
			}
			else {
				System.out.println("Invalid Option");
			}
		}
		//Bike Part
		else if(option == 3) {
			bikePMenu();
			subOption = Helper.readInt("Enter option > ");
			if (subOption == 1) {
				viewBikeParts(bikePartList);
			} else if (subOption == 2) {
				addBikePart(bikePartList);
			} else if (subOption == 3) {
				deleteBikePart(bikePartList);
			} else if (subOption == 4) {
				System.out.println("***TBC***");
			} else if(subOption == 5) {
				System.out.println("***TBC***");
			}
			else {
				System.out.println("Invalid Option");
			}
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
//===================================  BUYER CRUD (STUDENT 1)  =======================================================================================
	
	private void buyerMenu() {
		Helper.line(80, "=");
		System.out.println("BIKERS PORTAL");
		Helper.line(80, "=");
		
		System.out.println("1. View all buyers");
		System.out.println("2. Add buyer");
		System.out.println("3. Delete buyer");
		System.out.println("4. Update buyer");
		System.out.println("5. Search buyer");
	}
	
	private void createnewbuyer(ArrayList<Buyer> buyerList)  {
		  String newname = Helper.readString("Enter buyer name: ");
		  int mobileNum = Helper.readInt("Enter buyer's phone number: ");
		  String buyerID = Helper.readString("Enter buyer's account ID: ");
		  
		  
		  buyerList.add(new Buyer(buyerID, newname, mobileNum));
		  System.out.println("Buyer is successfully registered");
		 }
		 
		 private void deletebuyer(ArrayList<Buyer> buyerList) {
		  boolean isFound = false;
		  String deleteBuyer = Helper.readString("Enter Buyer's ID to delete: ");
		  for(int e = 0; e < buyerList.size(); e++) {
		   if(buyerList.get(e).getBuyerID().equals(deleteBuyer)) {
		    isFound = true;
		   }
		  }
		  if(isFound == true) {
		   for(int e = 0; e < buyerList.size(); e++) {
		    if(buyerList.get(e).getBuyerID().equals(deleteBuyer)) {
		     buyerList.remove(e);
		     System.out.println("User's account has been successfully deleted");
		    }
		   }
		  
		  }
		 }
		 public static void viewAllBuyers(ArrayList<Buyer> buyerList) {
		     System.out.println("BUYER's INFORMATION");
		     String output = String.format("%-10s %-10s %-10s\n", "ID", "NAME", "MOBILE NUMBER");

		     for(int e = 0; e < buyerList.size(); e++) {

		       output += String.format("%-10s %-10s %-10s\n", buyerList.get(e).getBuyerID(), buyerList.get(e).getBuyerName(), buyerList.get(e).getMobile());
		     }
		     System.out.println(output);
		  }
		 
//===================================  BIKE CRUD (STUDENT 2)  =======================================================================================
		 
	private void bikeMenu() {
		Helper.line(80, "=");
		System.out.println("BIKE LISTING");
		Helper.line(80, "=");
		System.out.println("1. View bike listing");
		System.out.println("2. Add bike listing");
		System.out.println("3. Delete bike listing");
		System.out.println("4. Edit bike listing");
	}
	private void viewBike(ArrayList <Bike>bikeList) {
		String output = String.format("%-10s %-20s %-10s %-15s %-10s %-20s\n", "ID", "NAME", "PRICE", "AVAILABLE", "COLOUR",
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
	
	private void delBike(ArrayList<Bike> bikeList) {
		String idSearch = Helper.readString("Enter id to delete > ");
		boolean del = false;
		for(Bike b: bikeList) {
			if(b.getId().equalsIgnoreCase(idSearch)) {
				bikeList.remove(b);
				System.out.println("Bike deleted");
				del = true;
				break;
			}
		}
		if(del == false) {
			System.out.println("Deletion cancelled!");
		}
	}
	//===================================  BIKE PART CRUD (STUDENT 3)  =======================================================================================
	private void bikePMenu() {
		Helper.line(80, "=");
		System.out.println("BIKE PART LISTING");
		Helper.line(80, "=");
		System.out.println("1. View bike part listing");
		System.out.println("2. Add bike part listing");
		System.out.println("3. Delete bike part listing");
		System.out.println("4. Edit bike part listing");
		System.out.println("5. Search bike part listing");
	}
	
	public static void addBikePart(ArrayList<BikePart>bikePartList) {
		 String id = Helper.readString("Enter Id > ");
		 String name = Helper.readString("Enter name > ");
		 double price = Helper.readDouble("Enter price > ");
		 char availability = Helper.readChar("Enter availability > ");
		 String partType = Helper.readString("Enter part type > ");
		 
		 BikePart newBikePart = new BikePart(id, name, price,partType);
		 bikePartList.add(newBikePart);
		 System.out.println("New bike part was successfully added!");
		 }
		// Read Bike Part
		 public static void viewBikeParts(ArrayList<BikePart>bikePartList) {
		 System.out.println("BIKE PART LISTING");
		 String output = String.format("%-5s %-30s %-10s %-15s %s\n", "ID","NAME","PRICE","AVAILABILITY","PART_TYPE");
		 
		 for (int i =0; i < bikePartList.size();i++) {
		   output += String.format("%-5s %-30s %-10s %-15s %s\n", bikePartList.get(i).getId(), bikePartList.get(i).getName(),
		     bikePartList.get(i).getPrice(), bikePartList.get(i).isAvailable(), bikePartList.get(i).getPartType());
		}
		 System.out.println(output);
}

		// Update Bike Part
//		public static void updateBikePart(ArrayList<BikePart>bikePartList) {
//		 String id = Helper.readString("Enter id to update >");
//		 
//		 boolean isFound= true;
//		 for (int i = 0; i < bikePartList.size(); i++) {
//		  if(bikePartList.get(i).getId().equals(id)) {
//		   isFound = false;
//		  }
//		 }
//		 if (isFound == false) {
//		  String name = Helper.readString("Enter name to update > ");
//		  double price = Helper.readDouble("Enter price to update > ");
//		  char availability = Helper.readChar("Enter y/n > ");
//		  String partType = Helper.readString("Enter part type > ");
//		  
//		  for(int i = 0; i < bikePartList.size();i++) {
//		   if (bikePartList.get(i).getId().equals(id)) {
//		    bikePartList.get(i).setName();
//		    bikePartList.get(i).setPrice(price);
//		    if (Character.toLowerCase(availability)=='y') {
//		     bikePartList.get(i).setAvailable(true);
//		    }
//		    else {
//		     if (Character.toLowerCase(availability)=='n') {
//		      bikePartList.get(i).setAvailable(false);
//		    }
//		   }
//		    System.out.println("Bike Part List has been updated!");
//		  }
//		   else {
//		    System.out.println("ID entered is not found.");
//		   }
//		  }
//		 }
//		}
		// Delete Bike Part
		  public static void deleteBikePart(ArrayList<BikePart>bikePartList) {
		   String id = Helper.readString("Enter ID to delete bikepart > ");
		   
		   boolean isFound = true;
		   for (int i =0;i<bikePartList.size();i++) {
		    if (bikePartList.get(i).getId().equals(id)){
		     isFound = false;
		    }
		   }
		   if (isFound == false) {
		    for (int i = 0; i< bikePartList.size();i++) {
		     if(bikePartList.get(i).getId().equals(id)) {
		      char prompt = Helper.readChar("Delete record? Please input y/n");
		      if(Character.toLowerCase(prompt) == 'y') {
		       bikePartList.remove(i);
		       System.out.println("Bike Part " + id + " has been successfully deleted.");
		      }
		      else {
		       System.out.println("User has decided to not delete bike part list");
		      }
		     }
		    }
		   }
		   else {
		    System.out.println("Id entered was not found in the system");
		   }
		  }

	//===================================  APPOINTMENT CRUD (STUDENT 4)  =======================================================================================
		  private void appointmentMenu() {
			Helper.line(80, "=");
			System.out.println("APPOINTMENT");
			Helper.line(80, "=");
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
		      boolean del = false;
		      for (int i = 0; i < appointmentList.size(); i++) {
		        if (appointmentList.get(i).getAppID().equalsIgnoreCase(id)) {
		          appointmentList.remove(i);
		          System.out.println("Appointment deleted!");
		          del = true;
		          break;
		        }

		      } if(del == false) {
		    	  System.out.println("Deletion cancelled!");
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
		    System.out.println("Appointment Created!");
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