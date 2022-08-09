
public class BikePart extends Listing {

	private String partType;

	public BikePart(String id, String name, double price, String partType) {
		super(id, name, price);
		this.partType = partType;
	}

	public String getPartType() {
		return partType;
	}

	public String getListing() {
		String output = String.format("%-5s %-30s %-10s %-15s %s\n", super.getId(), super.getName(), super.getPrice(),
				super.isAvailable(), partType);
		return output;
	}
}
