package obj;

public class Child implements TicketType {

  public double getPrice(){
     return 100.00 * 0.85;
   }
  
  public String getType(){
     return "Child";
   }
  
}
