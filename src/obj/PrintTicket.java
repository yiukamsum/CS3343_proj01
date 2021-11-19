package obj;

public class PrintTicket {
    private Ticket ticket;

    public PrintTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public void print(){
        System.out.println("Ticket Type: " +  ticket.getType());
        System.out.println("Ticket Price: " + ticket.getPrice());
        System.out.println(ticket.getSession().toCatalogItemString());
    }
}
