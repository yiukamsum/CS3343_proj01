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

	public int getNextHistoryID(int memberID) {
		ArrayList<PurchaseHistory> memberHistory = getHistory(memberID);

		if(memberHistory.size() == 0) { return 1; }
		return memberHistory.get(memberHistory.size()-1).getHistoryID()+1;
	}
	
	public ArrayList<PurchaseHistory> getHistory(){
		return historyList;
	}

	// get history list for a member
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

