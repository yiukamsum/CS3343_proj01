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
        this.hour = 0;
        this.minute = 0;
    }

    public void addMonth(int monthAdd) {
        this.month += monthAdd;
        if(this.month >= 13) {
            int yearAdd = this.month/12;
            this.month -= 12*yearAdd;
            if(this.month == 0) { this.month = 1; }
            this.year += yearAdd;
        }
    }

    public void addDay(int dayAdd) {
        this.day += dayAdd;
        if(this.day >= 32) {
            int monthAdd = this.day/31;
            this.day -= 31*monthAdd;
            if(this.day == 0) { this.day = 1; }
            addMonth(monthAdd);
        }
    }

    public void addHour(int hourAdd) {
        this.hour += hourAdd;
        if(this.hour >= 24) {
            int dayAdd = this.hour/24;
            this.hour -= 24*dayAdd;
            addDay(dayAdd);
        }
    }

    public void addMinute(int minuteAdd) {
        this.minute += minuteAdd;
        if(this.minute >= 60) {
            int hourAdd = this.minute/60;
            this.minute -= 60*hourAdd;
            addHour(hourAdd);
        }
    }

    @Override
    public String toString(){
        if(hour == 0 && minute == 0){
            return year + "-" + month + "-" + day + " 00:00";
        }else{
            return year + "-" + month + "-" + day + " " + hour + ":" + minute;
        }
    }

    public static DateTime clone(DateTime dateTime) {
        return new DateTime(
            dateTime.year,
            dateTime.month,
            dateTime.day,
            dateTime.hour,
            dateTime.minute
        );
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
        if(this.year != dateTime.year) { return this.year-dateTime.year; }
        if(this.month != dateTime.month) { return this.month-dateTime.month; }
        if(this.day != dateTime.day) { return this.day-dateTime.day; }
        if(this.hour != dateTime.hour) { return this.hour-dateTime.hour; }
        if(this.minute != dateTime.minute) { return this.minute-dateTime.minute; }
        return 0;
    }

}

