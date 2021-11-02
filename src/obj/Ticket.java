package obj;

public abstract class Ticket {
	private Integer ticketPrice;
	private String ticketType;
	
	public Integer getTicketPrice() {
		return this.ticketPrice;
	}
	
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
