import java.time.LocalDate;

public class Appointment {
	private String appID;
	private LocalDate appDate;

	public Appointment(String appID, LocalDate appDate) {
		this.appID = appID;
		this.appDate = appDate;
	}

	public LocalDate getAppDate() {
		return appDate;
	}

	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}

	public String getAppID() {
		return appID;
	}

}
