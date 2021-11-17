package obj;

public class Elderly implements TicketType {

  public double getPrice(){
    return 100.00 * 0.7;
  }
  
  public String getType(){
    return "Elderly";
  }
  
}
