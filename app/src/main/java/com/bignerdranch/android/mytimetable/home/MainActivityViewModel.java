package com.bignerdranch.android.mytimetable.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bignerdranch.android.mytimetable.model.LessonModel;
import com.bignerdranch.android.mytimetable.model.TimetableData;
import com.bignerdranch.android.mytimetable.model.TimetableRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<LessonModel>> mLessons;
    private TimetableRepository timeRepo;

    private MutableLiveData<String> weekDay;
    private MutableLiveData<String> number;

    public LiveData<String> getWeekDay() {
        return weekDay;
    }

    public LiveData<String> getNumber() {
        return number;
    }

    public LiveData<List<LessonModel>> getLessons() {
        return mLessons;
    }

    public void init() {
        if (mLessons != null) {
            return;
        }
        timeRepo = new TimetableRepository();
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

    private void updateUI() {
        weekDay.setValue(timeRepo.getDayOfMonth() + " " + timeRepo.getMonth());
        number.setValue(TimetableData.days[timeRepo.getDayOfWeekNum()]);
        List<LessonModel> currentLessons = getLessons().getValue();
        timeRepo.updateLessons(currentLessons);
        mLessons.postValue(currentLessons);
    }

    public void prevDay() {
        timeRepo.changeMyCalendar(-1);
        updateUI();
    }

    public boolean isWeekend(){
        return (timeRepo.getWeekType() == 0 && TimetableData.lessonsCh[timeRepo.getDayOfWeekNum()].length == 0 ||
                timeRepo.getWeekType() == 1 && TimetableData.lessonsZn[timeRepo.getDayOfWeekNum()].length == 0);
    }
}
