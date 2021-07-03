package com.bignerdranch.android.mytimetable;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bignerdranch.android.mytimetable.model.TimetableRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<LessonModel>> mLessons;
    private TimetableRepository timeRepo;

    public LiveData<List<LessonModel>> getLessons() {
        return mLessons;
    }

    public void init() {
        if (mLessons != null) {
            return;
        }
        timeRepo = new TimetableRepository();
        mLessons = new MutableLiveData<>();
        List<LessonModel> lessonModelList = new ArrayList<>();
        mLessons.setValue(lessonModelList);
        timeRepo.updateLessons(mLessons.getValue());
    }

    public void nextDay() {
        timeRepo.changeMyCalendar(1);
        List<LessonModel> currentLessons = getLessons().getValue();
        timeRepo.updateLessons(currentLessons);
        mLessons.postValue(currentLessons);
    }

    public void prevDay() {
        timeRepo.changeMyCalendar(-1);
        List<LessonModel> currentLessons = getLessons().getValue();
        timeRepo.updateLessons(currentLessons);
        mLessons.postValue(currentLessons);
    }

}
