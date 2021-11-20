package obj;

import java.util.ArrayList;

public class viewHistoryCatalogPage extends Page{
    private Catalog<PurchaseHistory> historyCatalog;
    private Member member;

    public viewHistoryCatalogPage(MemberConsole console) {
        super(console);

        ArrayList<PurchaseHistory> historyList = new HistoryManageAction().getHistory();
        historyCatalog = new Catalog<PurchaseHistory>(historyList);

        member = console.getMember();
    }

    @Override
    public void display() {

        System.out.printf("\n====Purchase History====\n");

        int input = 0;

        do {       
            System.out.printf("Enter 1 to show the history list and 2 to search purchase history (-1 to leave)\n" );
            input = getInputStream().nextInt();

            if(input == -1) { break;}
            else if(input == 1){showHistoryIDList();}
            else if(input == 2){
                System.out.printf("Please enter the history ID: (-1 to leave)\n" );
                input = getInputStream().nextInt();
                
                if(input != -1)
                    searchPurchaseHistory(input);
                else
                    break;
            }

        }while(input != -1);
    }

    public void showHistoryIDList(){

        int index = 0;
        for (PurchaseHistory p: historyCatalog){
            if(p.getMemberID() == member.getMemberId()){
                if(index == 0){ 
                    System.out.printf("The purchase history ID list: \n");
                }

                System.out.printf("%d. History ID: %d, Purchase Date: %s \n", index, p.getHistoryID(), p.getPurchaseDate());
                index++;
            } 
        }

        if(index == 0){
            System.out.println("No History Record!");
        }
           
    }

    public void searchPurchaseHistory(int historyID){

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
