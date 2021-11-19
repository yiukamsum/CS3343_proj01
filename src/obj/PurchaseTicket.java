package obj;

import java.util.*;

public class PurchaseTicket {
	private Member member;

    public PurchaseTicket(Member member){
        this.member = member;
    }
    
    public void PurchaseTicket(MovieSession session, TicketType ticketType){
    	CreditCard card = new CreditCard();
    	if(card.pay(ticketType.getPrice())) {
    		//Database db = Database.connectDB(new HistoryManageAction())
    		Ticket ticket = new Ticket(ticketType, session) {};	
    		HistoryManageAction act = new HistoryManageAction();
    		PurchaseHistory history = new PurchaseHistory(act.getPurchaseHistorySize(), member, ticket, DateTime.today());
    		
    		act.addHistory(history);
    		
    		System.out.printf("Need ticket? (Y/N): ");
            //TODO: Add
    		
    		if(true) {
    			new PrintTicket(ticket).print();
    		}
    	}
    }
}
