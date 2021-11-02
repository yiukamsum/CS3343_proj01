package obj;

public class Cinema {
	private String cinemaId;
	private String cinemaLoc;
	private String cinemName;
	private String cinemaPhoneNo;
	
	public Cinema() {
		this.cinemaId = "";
		this.cinemaLoc = "";
		this.cinemName = "";
		this.cinemaPhoneNo = "";
	}

	public String getCinemaId() {
		return this.cinemaId;
	}

	public String getCinemaLoc() {
		return this.cinemaLoc;
	}

	public void setCinemaLoc(String cinemaLoc) {
		this.cinemaLoc = cinemaLoc;
	}

	public String getCinemName() {
		return this.cinemName;
	}

	public void setCinemName(String cinemName) {
		this.cinemName = cinemName;
	}

	public String getCinemaPhoneNo() {
		return this.cinemaPhoneNo;
	}

	public void setCinemaPhoneNo(String cinemaPhoneNo) {
		this.cinemaPhoneNo = cinemaPhoneNo;
	}
}
