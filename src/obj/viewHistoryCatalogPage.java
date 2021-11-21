package obj;

import java.util.ArrayList;

public class viewHistoryCatalogPage extends Page{
    private Catalog<PurchaseHistory> historyCatalog;
    private Member member;

    public viewHistoryCatalogPage(MemberConsole console) {
        super(console);

        this.member = console.getMember();

        ArrayList<PurchaseHistory> historyList = new HistoryManageAction().getHistory(member.getMemberId());
        historyCatalog = new Catalog<PurchaseHistory>(historyList);
    }

    @Override
    public void display() {

        System.out.printf("\n====Purchase History====\n");

        int input = 0;

        do {       
            System.out.printf(
                "(1) Show Purchase History list\n"+          
                "(-1) Leave this page\n");
            input = getInputStream().nextInt();

            if(input == -1) { break;}
            else if(input == 1){showHistoryIDList();}
            else
                System.out.println("Invalid input!");

        }while(input != -1);
    }

    private void showHistoryIDList(){
        System.out.printf("\n---Purchase History List---\n");
        historyCatalog.show();
        System.out.printf("\n-------------------------\n");
    }
}
