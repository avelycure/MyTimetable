package com.bignerdranch.android.mytimetable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bignerdranch.android.mytimetable.model.TimeTableModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<LessonModel>> mLessons;
    private TimeTableModel time;

    public LiveData<List<LessonModel>> getLessons() {
        return mLessons;
    }


    public MainActivityViewModel() {
        time = new TimeTableModel();
    }
}
