package obj;

import java.util.*;

public class Theatre {
	private String theatreId;
	private Integer colNum;
	private Integer rowNum;
	
	public Theatre(String theatreId, Integer colNum, Integer rowNum ) {
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
	
	public Integer compareTo(Theatre theatre){
		return this.theatreID.compareTo(theatre.theatreID);
	}
	
}
