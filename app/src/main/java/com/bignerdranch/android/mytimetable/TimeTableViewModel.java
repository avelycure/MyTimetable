package com.bignerdranch.android.mytimetable;

import androidx.lifecycle.ViewModel;

import com.bignerdranch.android.mytimetable.model.TimeTableModel;

public class TimeTableViewModel extends ViewModel {

    private TimeTableModel time;

    public TimeTableViewModel() {
        time = new TimeTableModel();
    }
}
