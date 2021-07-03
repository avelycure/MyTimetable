package com.bignerdranch.android.mytimetable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.mytimetable.model.Time;
import com.bignerdranch.android.mytimetable.util.AdapterForCards;


public class TimeTableFragment extends Fragment {
    Time fragTime;
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return ;
    }*/
    public TimeTableFragment(Time time){
        this.fragTime = time;
    }
}