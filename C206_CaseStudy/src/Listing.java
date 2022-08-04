
public class Listing {
	
	private String id;
	private String name;
	private double price;
	private boolean isAvailable;
	
	public Listing(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.isAvailable = true;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String showListing() {
		String output = String.format("%-10s %-20s $%-10.2f %-15b", id, name, price, isAvailable);
		return output;
	}

}
