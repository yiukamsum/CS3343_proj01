package obj;

public class Child implements TicketType {
	private static Child instance=new Child();
	
	
	private Child() {
		
	}
	public static Child getInstance() {
		return instance;
	}
	
  public double getPrice(){
     return 100.00 * 0.75;
   }
  
  public String getType(){
     return "Child";
   }
  
}
