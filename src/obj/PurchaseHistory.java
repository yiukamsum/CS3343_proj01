package obj;

public class PurchaseHistory implements Comparable<PurchaseHistory>, CatalogItem{
    
    private Member member;
    private Ticket ticket;
    private DateTime purchaseDate;
    private int historyID;

    public PurchaseHistory(int historyID, Member member, Ticket ticket, DateTime purchaseDate){
        this.historyID = historyID;
        this.member = member;
        this.ticket = ticket;
        this.purchaseDate = purchaseDate;
    }
    
    public int getHistoryID(){
        return historyID;
    }

    public int getMemberID() {
        return this.member.getMemberId();
    }

    @Override 
    public int compareTo(PurchaseHistory history){
        return this.historyID - history.historyID;
    }

    @Override
    public String toCatalogItemString(){

        return String.format(
			"\tHistory ID: \t%d\n"+
			"\tMember ID: \t%d\n"+
			"\tTicket Type: \t%s\n"+
            "\tTicket Price: \t%f\n"+
			"\tPurchase Date: \t%s\n"
		, historyID, member.getMemberId(), ticket.getType(), ticket.getPrice(), purchaseDate.toString());
	}
}
