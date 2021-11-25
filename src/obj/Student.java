package obj;

public class Student implements TicketType {

	private static Student instance=new Student();
	
	
	private Student() {
		
	}
	public static Student getInstance() {
		return instance;
	}
	
	
  public double getPrice(){
    return 100.00 * 0.85;
  }
  
  public String getType(){
    return "Student";
  }
  
}
