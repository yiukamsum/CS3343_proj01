package obj;

public class Adult implements TicketType {
	private static Adult instance=new Adult();
	
	
	private Adult() {
		
	}
	public static Adult getInstance() {
		return instance;
	}
	
    public double getPrice(){
      return 100.00;
    }
  
    public String getType(){
      return "Adult";
    }
  
}
