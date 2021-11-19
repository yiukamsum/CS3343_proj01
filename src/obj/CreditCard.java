public class CreditCard implements PaymentMethod{
    
    public boolean pay(double amount){
 
        try{
            System.out.println("Paid successfully!");
            return true;
        }catch(CreditCardDenied e){
            System.out.println("The credit card is denied!");
            return false;
        }       

    }
}


