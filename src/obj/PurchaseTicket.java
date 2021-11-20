package obj;

import java.util.ArrayList;

public class PurchaseTicket {
	private MemberConsole console;

    public PurchaseTicket(MemberConsole console){
        this.console = console;
    }

	public boolean purchase(MovieSession session, ArrayList<Ticket> ticketList) {
		// cal total amount
		double amount = calTicketsAmount(ticketList);
		System.out.printf("\nTotal amount: %f\n", amount);

		// ask for payment method
		PaymentMethod paymentMethod = selectPaymentMethod();
		
		/* pay */
		boolean isPaySuccess = paymentMethod.pay(amount);
		
		/* pay failed */
		if(!isPaySuccess) { return false; }
		
		/* pay success */
		// record purchase history
		recordPurchaseHistory(ticketList);
		return true;
	}

	private double calTicketsAmount(ArrayList<Ticket> ticketList) {
		double amount = 0.0;
		for(Ticket ticket : ticketList) {
			amount += ticket.getPrice();
		}
		return amount;
	}

	private PaymentMethod selectPaymentMethod() {
        int input = 0;
        PaymentMethod method = null;

        do {
            System.out.printf("How do you want to pay? (1-Alipay, 2-Credit Card):");
            input = console.getInputStream().nextInt();
            console.getInputStream().nextLine();

            switch(input) {
                case 1:
                    method = new Alipay();
                    break;
                case 2:
                    method = new CreditCard();
                    break;
                default:
                    System.out.println("Wrong input");
            }

        } while(method == null);

        return method;
    }

	private void recordPurchaseHistory(ArrayList<Ticket> ticketList) {
		// create ticket record, payment history record and take seat
		HistoryManageAction historyAct = new HistoryManageAction(); // DB action for managing payment history

		for(Ticket ticket : ticketList) {
			// new histroy record
			int historyID = historyAct.getPurchaseHistorySize()+1;
			PurchaseHistory history = new PurchaseHistory(historyID, this.console.getMember(), ticket, DateTime.now());

			// store record
			historyAct.addHistory(history);
		}
	}
}
