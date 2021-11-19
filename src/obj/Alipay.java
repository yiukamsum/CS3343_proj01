package obj;

public class Alipay implements PaymentMethod {
	@Override
	public boolean pay(double amount) {
		try{
            if(false) {
                throw new CreditCardDenied("Credit Card Error");
            }
            System.out.println("Paid successfully!");
            return true;
        }catch(CreditCardDenied e){
            System.out.println("The payment is denied!");
            return false;
        }  	
	}
}
