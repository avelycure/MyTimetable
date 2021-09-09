package com.bignerdranch.android.mytimetable.model;

import com.bignerdranch.android.mytimetable.data.TimetableData;
import com.bignerdranch.android.mytimetable.home.LessonModel;

import java.util.Calendar;
import java.util.List;

/**
 * Class for working with time
 */
public class TimetableRepository {
    private TimetableData timetableData;
    private Calendar myCalendar;

    private String month;//название месяца
    private int monthNum;//номер месяца
    private int dayOfMonth;//день месяца

    private int weekType;//тип недели (числитель или знаменатель)

    private int dayInTimetable;//день в году, чтобы иметь дату для отталкивания
    private int dayOfWeekNum;//номер дня недели

    public int TODAY;//день в году, чтобы иметь дату для отталкивания
    public int MONTH;
    public int HOUR;
    public int MINUTE;

    public TimetableRepository(TimetableData timetableData) {
        this.timetableData = timetableData;
        myCalendar = Calendar.getInstance();
        setTime();
        UpdateFields();
    }

    private void setTime(){
        TODAY = myCalendar.get(Calendar.DAY_OF_YEAR);
        MONTH = myCalendar.get(Calendar.MONTH);
        MINUTE = myCalendar.get(Calendar.MINUTE);
        HOUR = myCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public void UpdateFields() {
        setMonthNum();
        setMonth(monthNum);
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

    public void changeMyCalendar(int addDay) {
        myCalendar.add(Calendar.DAY_OF_MONTH, addDay);
        UpdateFields();
    }

    public void setWeekType() {
        weekType = (myCalendar.get(Calendar.WEEK_OF_YEAR) + 1) % 2;
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
        this.month = timetableData.months.get(monthNum);
    }

    public void setMonthNum() {
        monthNum = myCalendar.get(Calendar.MONTH);
    }

    public void updateLessons(List<LessonModel> list) {
        int arraySize;
        if (weekType == 0)
            arraySize = timetableData.lessonsCh.get(dayOfWeekNum).size();
        else
            arraySize = timetableData.lessonsZn.get(dayOfWeekNum).size();

        list.clear();

        for (int i = 0; i < arraySize; i++) {
            if (weekType == 0)
                list.add(new LessonModel(timetableData.lessonsBegin.get(i).get(0) + ":" + timetableData.lessonsBegin.get(i).get(1),
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

    private boolean isCurrentLesson(int position) {
        setTime();
        if ((MINUTE + HOUR * 60 > timetableData.lessonsBeginInMinute.get(position) - 10) &&
                (MINUTE + HOUR * 60 <= timetableData.lessonsEndInMinute.get(position)) &&
                (dayInTimetable == TODAY))
            return true;
        else return false;
    }
}
