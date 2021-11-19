public class CreditCard implements PaymentMethod{
    
    public void pay(double amount){
 
        try{
            System.out.println("Paid successfully!");
        }catch(CreditCardDenied e){
            System.out.println("The credit card is denied!");
        }       

    }
}