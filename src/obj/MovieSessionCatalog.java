package obj;

import java.util.ArrayList;

public class MovieSessionCatalog extends Catalog<MovieSession> {
    
    private ArrayList<MovieSession> allItems; // keep all item records

    public MovieSessionCatalog(ArrayList<MovieSession> itemList) {
        super(itemList);
        allItems = itemList;
    }

    public void removeFilter() {
        setItemList(allItems);
    }

    public void filterByMovieName(String name) {
        ArrayList<MovieSession> filterList = new ArrayList<>();
        for(MovieSession session : getItemList()) {
            if(session.getMovieName().equals(name)) {
                filterList.add(session);
            }
        }
        setItemList(filterList);
    }

    public void filterByCinemaName(String name) {
        ArrayList<MovieSession> filterList = new ArrayList<>();
        for(MovieSession session : getItemList()) {
            if(session.getCinemaName().equals(name)) {
                filterList.add(session);
            }
        }
        setItemList(filterList);
    }
}
