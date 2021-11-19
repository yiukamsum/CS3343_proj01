package obj;

public class CreditCard implements PaymentMethod{
    
    public void pay(double amount){
 
        try{
            if(false) {
                throw new CreditCardDenied("Credit Card Error");
            }
            System.out.println("Paid successfully!");
        }catch(CreditCardDenied e){
            System.out.println("The credit card is denied!");
        }       

    }
}