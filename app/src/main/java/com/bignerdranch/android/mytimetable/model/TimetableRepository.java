package com.bignerdranch.android.mytimetable.model;

import com.bignerdranch.android.mytimetable.data.TimetableData;
import com.bignerdranch.android.mytimetable.home.LessonModel;

import java.util.Calendar;
import java.util.List;

//Class for working with time
public class TimetableRepository {
    private Calendar myCalendar;

    private String month;//название месяца
    private int monthNum;//номер месяца
    private int dayOfMonth;//день месяца

    private int weekType;//тип недели (числитель или знаменатель)

    private int dayInTimetable;//день в году, чтобы иметь дату для отталкивания
    private int dayOfWeekNum;//номер дня недели
    private String dayOfWeek;//название дня

    public final int TODAY;//день в году, чтобы иметь дату для отталкивания
    public final int MONTH;
    public final int HOUR;
    public final int MINUTE;

    public TimetableRepository() {
        myCalendar = Calendar.getInstance();
        TODAY = myCalendar.get(Calendar.DAY_OF_YEAR);
        MONTH = myCalendar.get(Calendar.MONTH);
        MINUTE = myCalendar.get(Calendar.MINUTE);
        HOUR = myCalendar.get(Calendar.HOUR_OF_DAY);
        UpdateFields();
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

    public int getDayInTimetable() {
        return dayInTimetable;
    }

    public void changeMyCalendar(int addDay) {
        myCalendar.add(Calendar.DAY_OF_MONTH, addDay);
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
        this.month = TimetableData.months[monthNum];
    }

    public void setMonthNum() {
        monthNum = myCalendar.get(Calendar.MONTH);
    }

    public void updateLessons(List<LessonModel> list) {
        int arraySize;
        if (weekType == 0)
            arraySize = TimetableData.lessonsCh[dayOfWeekNum].length;
        else
            arraySize = TimetableData.lessonsZn[dayOfWeekNum].length;

        list.clear();

        for (int i = 0; i < arraySize; i++) {
            if (weekType == 0)
                list.add(new
                        LessonModel(TimetableData.lessonsBegin[i][0] + ":" + TimetableData.lessonsBegin[i][1],
                        TimetableData.lessonsEnd[i][0] + ":" + TimetableData.lessonsEnd[i][1],
                        TimetableData.lessonsCh[dayOfWeekNum][i],
                        isCurrentLesson(i)));
            else
                list.add(new LessonModel(
                        TimetableData.lessonsBegin[i][0] + ":" + TimetableData.lessonsBegin[i][1],
                        TimetableData.lessonsEnd[i][0] + ":" + TimetableData.lessonsEnd[i][1],
                        TimetableData.lessonsZn[dayOfWeekNum][i],
                        isCurrentLesson(i)));
        }
    }

    private boolean isCurrentLesson(int position) {
        if ((MINUTE + HOUR * 60 > TimetableData.lessonsBeginInMinute[position] - 10) &&
                (MINUTE + HOUR * 60 <= TimetableData.lessonsEndInMinute[position]) &&
                (dayInTimetable == TODAY))
            return true;
        else return false;
    }
}
