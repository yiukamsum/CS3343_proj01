package obj;

import java.util.ArrayList;

public class Catalog<T extends CatalogItem> {
    // ArrayList of any class that extends CatalogItem
    private ArrayList<T> itemList;
    
    public Catalog(ArrayList<T> itemList) {
        this.itemList = itemList;
    }

    public void show() {
        if(itemList.size() == 0) {
            System.out.println("No Item");
        }

        for(int idx = 0; idx < this.itemList.size(); idx++) {
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
