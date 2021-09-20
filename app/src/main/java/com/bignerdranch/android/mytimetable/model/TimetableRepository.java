package com.bignerdranch.android.mytimetable.model;

import android.util.Log;

import com.bignerdranch.android.mytimetable.data.TimetableData;
import com.bignerdranch.android.mytimetable.home.LessonModel;

import java.util.Calendar;
import java.util.List;

/**
 * Class for working with time
 */
public class TimetableRepository {
    private final TimetableData timetableData;
    private final Calendar myCalendar;

    /**
     * Month name
     */
    private String month;

    /**
     * Number of month
     */
    private int monthNum;

    /**
     * Number of day in month
     */
    private int dayOfMonth;

    /**
     * Type of week. There are two types: Numerator and Denominator
     */
    private int weekType;

    /**
     * Selected day of the year
     */
    private int selectedDay;

    /**
     * Number of selected day in a week
     */
    private int dayOfWeekNum;

    /**
     * Constants that are showing the moment of launching the app
     */
    public final int TODAY;
    public final int MONTH;
    public final int HOUR;
    public final int MINUTE;

    public TimetableRepository(TimetableData timetableData) {
        this.timetableData = timetableData;
        myCalendar = Calendar.getInstance();
        TODAY = myCalendar.get(Calendar.DAY_OF_YEAR);
        MONTH = myCalendar.get(Calendar.MONTH);
        MINUTE = myCalendar.get(Calendar.MINUTE);
        HOUR = myCalendar.get(Calendar.HOUR_OF_DAY);
        updateFields();
    }

    public void updateFields() {
        setMonthNum();
        setMonth(monthNum);
        setDayOfMonth();
        setDayInTimetable();
        setDayOfWeekNum();
        setWeekType();
    }

    public void setDayInTimetable() {
        selectedDay = myCalendar.get(Calendar.DAY_OF_YEAR);
    }

    public void setDayOfMonth() {
        dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void changeMyCalendar(int addDay) {
        myCalendar.add(Calendar.DAY_OF_YEAR, addDay);
        updateFields();
    }

    public void setWeekType() {
        weekType = (myCalendar.get(Calendar.WEEK_OF_YEAR)) % 2;
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
        this.month = timetableData.months.get(monthNum);
    }

    public void setMonthNum() {
        monthNum = myCalendar.get(Calendar.MONTH);
    }

    //pay attention to weekType
    public void updateLessons(List<LessonModel> list) {
        int arraySize;
        if (weekType == 1)
            arraySize = timetableData.lessonsCh.get(dayOfWeekNum).size();
        else
            arraySize = timetableData.lessonsZn.get(dayOfWeekNum).size();
        list.clear();

        for (int i = 0; i < arraySize; i++) {
            if (weekType == 1)
                list.add(new LessonModel(
                        timetableData.lessonsBegin.get(i).get(0) + ":" + timetableData.lessonsBegin.get(i).get(1),
                        timetableData.lessonsEnd.get(i).get(0) + ":" + timetableData.lessonsEnd.get(i).get(1),
                        timetableData.lessonsCh.get(dayOfWeekNum).get(i),
                        isCurrentLesson(i)));
            else
                list.add(new LessonModel(
                        timetableData.lessonsBegin.get(i).get(0) + ":" + timetableData.lessonsBegin.get(i).get(1),
                        timetableData.lessonsEnd.get(i).get(0) + ":" + timetableData.lessonsEnd.get(i).get(1),
                        timetableData.lessonsZn.get(dayOfWeekNum).get(i),
                        isCurrentLesson(i)));
        }
    }

    /**
     * Checking if the lesson is going now
     */
    private boolean isCurrentLesson(int position) {
        if ((HOUR * 60 + MINUTE > timetableData.lessonsBeginInMinute.get(position) - 5) &
                (HOUR * 60 + MINUTE <= timetableData.lessonsEndInMinute.get(position)) &
                (myCalendar.get(Calendar.DAY_OF_YEAR) == TODAY)) {
            return true;
        } else {
            return false;
        }
    }
}
