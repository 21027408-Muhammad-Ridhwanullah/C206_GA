
public class Bike extends Listing{
	private String colour;
	private String bikeType;
	
	public Bike(String id, String name, double price, boolean isAvailable, String colour, String bikeType) {
		super(id, name, price, isAvailable);
		this.colour = colour;
		this.bikeType = bikeType;
	}

	public String getColour() {
		return colour;
	}

	public String getBikeType() {
		return bikeType;
	}
	
	public String getListing() {
		String listing = super.showListing();
		String output = String.format("%-55s %-15s %-15s", listing, colour, bikeType);
		
		return output;
	}

}
