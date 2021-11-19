package obj;

import java.util.ArrayList;

public class Catalog {
    // ArrayList of any class that extends CatalogItem
    private ArrayList<? extends CatalogItem> itemList;
    
    public Catalog(ArrayList<? extends CatalogItem> itemList) {
        this.itemList = itemList;
    }

    public void show() {
        if(itemList.size() == 0) {
            System.out.println("No Item");
        }

        for(int idx = 0; idx < this.itemList.size(); idx++) {
            System.out.printf("%d. %s\n", idx+1, itemList.get(idx).toCatalogItemString());
        }

        System.out.println();
    }
}
