package obj;

import java.util.ArrayList;

// Any subClass of CatalogItem
public class Catalog<T extends CatalogItem> {

    private ArrayList<T> itemList;
    
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
        if(idx >= itemList.size() || idx < 0) {
            return null;
        }
        return itemList.get(idx);
    }

    public int size() {
        return itemList.size();
    }

    protected ArrayList<T> getItemList() {
        return this.itemList;
    }
    protected void setItemList(ArrayList<T> itemList) {
        this.itemList = itemList;
    }
}
