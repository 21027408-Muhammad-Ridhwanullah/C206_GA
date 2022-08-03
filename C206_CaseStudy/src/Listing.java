
public class Listing {
	
	private String id;
	private String name;
	private double price;
	private boolean isAvailable;
	
	public Listing(String id, String name, double price, boolean isAvailable) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.isAvailable = isAvailable;
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
	
	
	
	

}
