package obj;

import java.util.ArrayList;
import java.util.Collections;

public class HistoryManageAction extends DbAction {
	
	ArrayList<PurchaseHistory> historyList;

	HistoryManageAction() {
		historyList = getDatabase().getPurchaseHistoryList();
	}

	public void addHistory(PurchaseHistory history) {
		historyList.add(history);	
	    Collections.sort(historyList);
        }
	
	public int getPurchaseHistorySize() {
		return historyList.size();
	}
	
	public ArrayList<PurchaseHistory> getHistory(){
		return historyList;
	}
        
}

