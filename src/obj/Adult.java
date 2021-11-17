package obj;

public class Adult implements TicketType {
    
    @Override
    public double getPrice(){
      return 100.00;
    }
  
    @Override
    public String getType(){
      return "Adult";
    }
  
}
