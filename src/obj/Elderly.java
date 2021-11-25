package obj;

public class Elderly implements TicketType {

	private static Elderly instance=new Elderly();
	
	
	private Elderly() {
		
	}
	public static Elderly getInstance() {
		return instance;
	}
	
	
  public double getPrice(){
    return 100.00 * 0.7;
  }
  
  public String getType(){
    return "Elderly";
  }
  
}
