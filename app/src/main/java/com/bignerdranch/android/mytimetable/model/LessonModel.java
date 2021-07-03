package com.bignerdranch.android.mytimetable.model;

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

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public boolean isCurrentLesson() {
        return isCurrentLesson;
    }

    public void setCurrentLesson(boolean currentLesson) {
        isCurrentLesson = currentLesson;
    }
}
