package com.bignerdranch.android.mytimetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.android.mytimetable.util.AdapterForCards;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdapterForCards adapter;

    private TextView myDate1;
    private TextView myDate2;
    private RecyclerView rv;
    private Button btnNext;
    private Button btnBack;

    private MainActivityViewModel timeTableViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();

        setListeners();

        timeTableViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class );

        timeTableViewModel.init();

        timeTableViewModel.getLessons().observe(this, new Observer<List<LessonModel>>() {
            @Override
            public void onChanged(List<LessonModel> lessonModels) {
                adapter.notifyDataSetChanged();
            }
        });

        timeTableViewModel.getNumber().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                myDate1.setText(timeTableViewModel.getNumber().getValue());
            }
        });

        timeTableViewModel.getWeekDay().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                myDate2.setText(timeTableViewModel.getWeekDay().getValue());
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        adapter = new AdapterForCards(this, timeTableViewModel.getLessons().getValue());
        rv.setAdapter(adapter);
    }

    public void getReferences() {
        rv = findViewById(R.id.time_recycler);
        myDate1 = findViewById(R.id.date_text1);
        myDate2 = findViewById(R.id.date_text2);
        btnBack = findViewById(R.id.date_back);
        btnNext = findViewById(R.id.date_next);
    }

    public void setListeners() {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeTableViewModel.prevDay();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeTableViewModel.nextDay();
            }
        });
    }
}