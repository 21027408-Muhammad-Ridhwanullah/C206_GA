
public class BikePart extends Listing{

	private String partType;

	public BikePart(String id, String name, double price, boolean isAvailable, String partType) {
		super(id, name, price, isAvailable);
		this.partType = partType;
	}

	public String getPartType() {
		return partType;
	}
	
}
