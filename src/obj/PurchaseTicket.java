package obj;

import java.util.ArrayList;

public class PurchaseTicket {
	private Member member;

    public PurchaseTicket(Member member){
        this.member = member;
    }

	public ArrayList<Ticket> purchase(MovieSession session, ArrayList<TicketType> ticketTypeList, ArrayList<String> seatList, PaymentMethod paymentMethod) {
		ArrayList<Ticket> paidTicket = new ArrayList<>();

		// print total amount
		double amount = calTicketsAmount(ticketTypeList);
		System.out.printf("Total amount: %f\n", amount);
		
		/* pay */
		boolean isPaySuccess = paymentMethod.pay(amount);
		
		/* pay failed */
		if(!isPaySuccess) { return null; }
		
		
		// create ticket record, payment history record and take seat
		HistoryManageAction historyAct = new HistoryManageAction(); // DB action for managing payment history

		int ticketNum = ticketTypeList.size();
		for(int ticketIdx = 0; ticketIdx < ticketNum; ticketIdx++) {
			// new ticket record
			Ticket ticket = new Ticket(ticketTypeList.get(ticketIdx), session);
			paidTicket.add(ticket);
			
			// new histroy record
			int historyID = historyAct.getPurchaseHistorySize()+1;
			PurchaseHistory history = new PurchaseHistory(historyID, member, ticket, DateTime.now());

			// store record
			historyAct.addHistory(history);

			// take seat
			session.takeSeat(seatList.get(ticketIdx));
		}

		return paidTicket;
	}

	private double calTicketsAmount(ArrayList<TicketType> typeList) {
		double amount = 0.0;
		for(TicketType type : typeList) {
			amount += type.getPrice();
		}
		return amount;
	}
}
