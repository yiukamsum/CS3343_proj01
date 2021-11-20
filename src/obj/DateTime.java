package obj;

import java.time.LocalDateTime;

public class DateTime implements Comparable<DateTime>{
    int year;
    int month;
    int day;
    int hour;
    int minute;

    public DateTime(int year, int month, int day, int hour, int minute){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public DateTime(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString(){
        if(hour == 0 && minute == 0){
            return year + "-" + month + "-" + day;
        }else{
            return year + "-" + month + "-" + day + " " + hour + ":" + minute;
        }
    }

    public static DateTime today(){
        LocalDateTime t = LocalDateTime.now(); 
        int y = t.getYear();
        int m = t.getMonthValue();
        int d = t.getDayOfMonth();

        DateTime Today = new DateTime(y, m, d);
        return Today;
    }

    
    public static DateTime now(){
        LocalDateTime n = LocalDateTime.now(); 
        int y = n.getYear();
        int m = n.getMonthValue();
        int d = n.getDayOfMonth();
        int h = n.getHour();
        int min = n.getMinute();

        DateTime Now = new DateTime(y, m, d, h, min);
        return Now;
    }

    @Override
    public int compareTo(DateTime dateTime){
        return this.year - dateTime.year;
    }

}

