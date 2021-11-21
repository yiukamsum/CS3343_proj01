package obj;

public class Theatre implements Comparable<Theatre>, CatalogItem{
	private int theatreID;
	private int colNum;
	private int rowNum;
	
	public Theatre(int theatreID, int colNum, int rowNum ) {
		this.theatreID = theatreID;
		this.colNum = colNum;
		this.rowNum = rowNum;
	}
	
	public int getColNum(){
		return colNum;
	}
	
	public int getRowNum(){
		return rowNum;
	}
	
	public int getTheatreID(){
		return theatreID;
	}
	
    @Override
	public int compareTo(Theatre theatre){
		return this.theatreID - theatre.theatreID;
	}

	@Override
	public String toCatalogItemString() {
		return String.format("row num %d, col num %d\n", rowNum, colNum);
	}
	
}
