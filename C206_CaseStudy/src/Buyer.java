
public class Buyer {
	private String buyerID;
	private String buyerName;
	private int age;
	
	public Buyer(String buyerID, String buyerName, int age) {
		this.buyerID = buyerID;
		this.buyerName = buyerName;
		this.age = age;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBuyerID() {
		return buyerID;
	}
	
}
