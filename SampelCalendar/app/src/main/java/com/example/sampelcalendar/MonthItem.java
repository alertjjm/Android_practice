package com.example.sampelcalendar;

public class MonthItem {
    String date;
    public MonthItem(String date){
        this.date=date;
    }
    public MonthItem(int date){
        this.date=Integer.toString(date);
    }
    public int getDate(){
        return Integer.parseInt(date);
    }
    public void setDate(int date){
        this.date=Integer.toString(date);
    }
    public void setDate(String date){
        this.date=date;
    }
}
