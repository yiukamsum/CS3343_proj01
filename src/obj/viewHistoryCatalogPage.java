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
                "(2) Search Purchase History\n"+
                "(-1) Leave this page\n");
            input = getInputStream().nextInt();

            if(input == -1) { break;}
            else if(input == 1){showHistoryIDList();}
            else if(input == 2){
                System.out.printf("Please enter the purchase history ID: \n" );
                input = getInputStream().nextInt();
                
                if(input != -1)
                    searchPurchaseHistory(input);
                else
                    break;
            }else
                System.out.println("Invalid input!");

        }while(input != -1);
    }

    private void showHistoryIDList(){
        historyCatalog.show();
    }

    private void searchPurchaseHistory(int historyID){

        for (PurchaseHistory p: historyCatalog){
            if(p.getHistoryID() == historyID){
                System.out.println("Result: ");
                p.toCatalogItemString();
                break;
            } 
        }
         
        System.out.println("Cannot find the history record!");
    }

}
