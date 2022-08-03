
public class Buyer {
	private String buyerID;
	private String buyerName;
	private int mobile;
	
	
	public Buyer(String buyerID, String buyerName, int mobile) {
		this.buyerID = buyerID;
		this.buyerName = buyerName;
		this.mobile = mobile;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getBuyerID() {
		return buyerID;
	}
	
}
