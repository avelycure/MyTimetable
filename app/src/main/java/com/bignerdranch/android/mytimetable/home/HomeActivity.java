package com.bignerdranch.android.mytimetable.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.android.mytimetable.R;
import com.bignerdranch.android.mytimetable.refactor.RefactorActivity;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private AdapterForCards adapter;

    private TextView myDate1;
    private TextView myDate2;
    private RecyclerView rv;
    private Button btnNext;
    private Button btnBack;
    private Toolbar toolbar;

    private HomeActivityViewModel timeTableViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home__activity);

        getReferences();
        setListeners();
        setSupportActionBar(toolbar);

        timeTableViewModel = ViewModelProviders.of(this).get(HomeActivityViewModel.class);

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
        toolbar = findViewById(R.id.home_toolbar);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home__toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_refactor:
                Intent intent = new Intent(this, RefactorActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}