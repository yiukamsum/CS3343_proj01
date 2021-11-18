package obj;

import java.util.*;

public class Theatre implements Comparable<Theatre>{
	private String theatreID;
	private Integer colNum;
	private Integer rowNum;
	
	public Theatre(String theatreID, Integer colNum, Integer rowNum ) {
		this.theatreID = theatreID;
		this.colNum = colNum;
		this.rowNum = rowNum;
	}
	
	public Integer getColNum(){
		return colNum;
	}
	
	public Integer getRowNum(){
		return rowNum;
	}
	
	public String getTheatreID(){
		return theatreID;
	}
	
	public int compareTo(Theatre theatre){
		return this.theatreID.compareTo(theatre.theatreID);
	}
	
}
