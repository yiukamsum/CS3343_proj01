package obj;

import java.util.ArrayList;

// Any subClass of CatalogItem
public class Catalog<T extends CatalogItem> {

    private ArrayList<T> itemList;  // for storing items after filter
    
    public Catalog(ArrayList<T> itemList) {
        this.itemList = itemList;
    }

    public void show() {
        if(itemList.size() == 0) {
            System.out.println("No Item");
        }

        for(int idx = 0; idx < itemList.size(); idx++) {
            System.out.printf("%d. %s\n", idx+1, itemList.get(idx).toCatalogItemString());
        }
    }

    public T getItem(int idx) {
        if(idx >= itemList.size()) {
            System.out.println("Wrong number");
            return null;
        }
        return itemList.get(idx);
    }
}
