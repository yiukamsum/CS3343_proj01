package obj;

public class Child implements TicketType {

  public double getPrice(){
     return 100.00 * 0.75;
   }
  
  public String getType(){
     return "Child";
   }
  
}
