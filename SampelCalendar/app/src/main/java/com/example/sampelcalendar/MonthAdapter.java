package com.example.sampelcalendar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class MonthAdapter extends BaseAdapter {
    MonthItem[] items;
    Calendar mCalendar;
    int firstDay;
    int lastDay,mStartDay,curYear,curMonth,startDay;
    boolean recreateItems = false;
    private int countColumn = 7;
    private int selectedPosition = -1;
    public static int oddColor = Color.rgb(225, 225, 225);
    public static int headColor = Color.rgb(12, 32, 158);
    Context mContext;
    public static final String TAG = "MonthAdapter";

    public MonthAdapter(Context context){
        super();
        mContext=context;
        init();
    }
    public MonthAdapter(Context context, AttributeSet attrs){
        super();
        mContext=context;
        init();
    }
    private void init(){
        items=new MonthItem[7*6];
        mCalendar= Calendar.getInstance();
        recalculate();
        resetDayNumbers();
    }
    public void recalculate(){
        mCalendar.set(Calendar.DAY_OF_MONTH,1);
        int dayOfWeek=mCalendar.get(Calendar.DAY_OF_WEEK);
        firstDay=getFirstDay(dayOfWeek);
        mStartDay=mCalendar.getFirstDayOfWeek();
        curYear=mCalendar.get(Calendar.YEAR);
        curMonth=mCalendar.get(Calendar.MONTH);
        lastDay=
    }
    public void setPreviousMonth(){

    }
    public void setNextMonth(){

    }
    public void resetDayNumbers(){

    }
    public View getView(int position, View convertView, ViewGroup parent){

    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return items[position].getDate();
    }
    private int getFirstDay(int dayOfWeek) {
        int result = 0;
        if (dayOfWeek == Calendar.SUNDAY) {
            result = 0;
        } else if (dayOfWeek == Calendar.MONDAY) {
            result = 1;
        } else if (dayOfWeek == Calendar.TUESDAY) {
            result = 2;
        } else if (dayOfWeek == Calendar.WEDNESDAY) {
            result = 3;
        } else if (dayOfWeek == Calendar.THURSDAY) {
            result = 4;
        } else if (dayOfWeek == Calendar.FRIDAY) {
            result = 5;
        } else if (dayOfWeek == Calendar.SATURDAY) {
            result = 6;
        }

        return result;
    }

}
