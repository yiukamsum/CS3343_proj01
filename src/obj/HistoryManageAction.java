package obj;

import java.util.ArrayList;
import java.util.Collections;

public class HistoryManageAction extends DbAction {
	
	public void addHistory(PurchaseHistory history) {
		getDatabase().getPurchaseHistoryList().add(history);	
	    Collections.sort(getDatabase().getPurchaseHistoryList());
    }
	
	  public int getPurchaseHistorySize() {
	  return getDatabase().getPurchaseHistoryList().size();
	}
	
	
}

