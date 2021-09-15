package com.bignerdranch.android.mytimetable.home;

public class LessonModel {
    private String beginTime;
    private String endTime;
    private String lessonName;
    private boolean isCurrentLesson;

    public LessonModel(String beginTime, String endTime, String lessonName, boolean isCurrentLesson) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.lessonName = lessonName;
        this.isCurrentLesson = isCurrentLesson;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getLessonName() {
        return lessonName;
    }

    public boolean isCurrentLesson() {
        return isCurrentLesson;
    }
}
