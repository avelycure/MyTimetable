package com.bignerdranch.android.mytimetable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TimeTableFragment extends Fragment {
    Time fragTime;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       RecyclerView myrec = (RecyclerView)inflater.inflate(
                R.layout.fragment_time_table, container, false);
        AdapterForCards adapter = new AdapterForCards(fragTime, getContext());

        if (adapter.getItemCount() != 0){
            myrec.setAdapter(adapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            myrec.setLayoutManager(layoutManager);
        }
        return myrec;
    }
    public TimeTableFragment(Time time){
        this.fragTime = time;
    }
}