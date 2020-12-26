package com.bignerdranch.android.mytimetable;
import java.util.Calendar;

//Class for working with time
public class Time {
    private Calendar myCalendar;

    private String month;//название месяца
    private int monthNum;//номер месяца
    private int dayOfMonth;//день месяца
    private int firstDayOfMonth;
    private int lastDayOfMonth;

    private int weekType;//тип недели (числитель или знаменатель)

    private int dayInTimetable;//день в году, чтобы иметь дату для отталкивания
    private int dayOfWeekNum;//номер дня недели
    private String dayOfWeek;//название дня

    public final int TODAY;//день в году, чтобы иметь дату для отталкивания
    public final int MONTH;
    public final int HOUR;
    public final int MINUTE;

    public Time(){
        myCalendar = Calendar.getInstance();
        TODAY = myCalendar.get(Calendar.DAY_OF_YEAR);
        MONTH = myCalendar.get(Calendar.MONTH);
        MINUTE =myCalendar.get(Calendar.MINUTE);
        HOUR =myCalendar.get(Calendar.HOUR_OF_DAY);
        UpdateFields();
    }

    public void UpdateFields(){
        setMonthNum();
        setMonth(monthNum);
        setFirstDayOfMonth();
        setLastDayOfMonth();
        setDayOfMonth();
        setDayInTimetable();
        setDayOfWeekNum();
        setWeekType();
    }
    public void setDayInTimetable() {
        dayInTimetable = myCalendar.get(Calendar.DAY_OF_YEAR);
    }

    public void setDayOfMonth() {
        dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getDayInTimetable() {
        return dayInTimetable;
    }

    public void setFirstDayOfMonth() {
        firstDayOfMonth = myCalendar.getActualMinimum(Calendar.DAY_OF_MONTH);
    }

    public void setLastDayOfMonth() {
        lastDayOfMonth = myCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public void ChangeMyCalendar(int AddDay){
        myCalendar.add(Calendar.DAY_OF_MONTH,AddDay);
        UpdateFields();
    }

    public void setWeekType() {
        weekType = myCalendar.get(Calendar.WEEK_OF_YEAR) % 2;
    }

    public int getWeekType() {
        return weekType;
    }

    public int getDayOfWeekNum() {
        return dayOfWeekNum;
    }

    public void setDayOfWeekNum() {
        dayOfWeekNum = myCalendar.get(Calendar.DAY_OF_WEEK) - 2;
        if (dayOfWeekNum == -1)
            dayOfWeekNum = 6;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(int monthNum) {
        this.month = Timetable.months[monthNum];
    }

    public void setMonthNum() {
        monthNum = myCalendar.get(Calendar.MONTH);
    }
}
