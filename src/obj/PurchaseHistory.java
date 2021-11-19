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

    @Override 
    public int compareTo(PurchaseHistory history){
        return this.historyID - history.historyID;
    }

    @Override
    public String toCatalogItemString(){
        String output = "";
        output = output + "History ID: " + historyID + "\n";
        output = output + "Member ID: " + member.getMemberId() + "\n";
        output = output + "Ticket Type: " + ticket.getType() + "\n";
        output = output + "Purchase Date: " + purchaseDate.toCatalogItemString() + "\n";

        return output;
    }
}