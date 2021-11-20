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

	public ArrayList<PurchaseHistory> getHistory(int memberId) {
		ArrayList<PurchaseHistory> memberHistory = new ArrayList<>();
		for(PurchaseHistory history : this.historyList) {
			if(history.getMemberID() == memberId) {
				memberHistory.add(history);
			}
		}
		return memberHistory;
	}
        
}

