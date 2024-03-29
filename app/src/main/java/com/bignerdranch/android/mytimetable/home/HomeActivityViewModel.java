package com.bignerdranch.android.mytimetable.home;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bignerdranch.android.mytimetable.data.TimetableData;
import com.bignerdranch.android.mytimetable.model.TimetableRepository;

import org.json.JSONException;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class HomeActivityViewModel extends ViewModel {

    private MutableLiveData<List<LessonModel>> mLessons;
    private TimetableRepository timeRepo;
    private TimetableData timetableData;

    private MutableLiveData<String> weekDay;
    private MutableLiveData<String> number;

    public void init(TimetableData timetableData, Context context) {
        if (mLessons != null)
            return;

        this.timetableData = timetableData;

        timeRepo = new TimetableRepository(timetableData);
        mLessons = new MutableLiveData<>();
        weekDay = new MutableLiveData<>();
        number = new MutableLiveData<>();

        List<LessonModel> lessonModelList = new ArrayList<>();
        mLessons.setValue(lessonModelList);
        timeRepo.updateLessons(mLessons.getValue());
        updateUI();
    }

    public void nextDay() {
        timeRepo.changeMyCalendar(1);
        updateUI();
    }

    public void prevDay() {
        timeRepo.changeMyCalendar(-1);
        updateUI();
    }

    public void updateUI() {
        weekDay.setValue(timeRepo.getDayOfMonth() + " " + timeRepo.getMonth());
        number.setValue(timetableData.days.get(timeRepo.getDayOfWeekNum()));
        List<LessonModel> currentLessons = getLessons().getValue();
        timeRepo.updateLessons(currentLessons);
        mLessons.postValue(currentLessons);
    }

    public LiveData<String> getWeekDay() {
        return weekDay;
    }

    public LiveData<String> getNumber() {
        return number;
    }

    public LiveData<List<LessonModel>> getLessons() {
        return mLessons;
    }
}
