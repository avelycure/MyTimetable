package com.bignerdranch.android.mytimetable.refactor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bignerdranch.android.mytimetable.R;
import com.bignerdranch.android.mytimetable.dagger.App;
import com.bignerdranch.android.mytimetable.data.TimetableData;

import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


//todo add coordinator layout
public class RefactorActivity extends AppCompatActivity {
    private Button btnSave;
    private Context context;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private RadioGroup rg;
    private RadioButton rbCh;

    private RefactorAdapter refactorAdapter;
    private TimetableData timetableData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refactor__activity);

        context = this;

        recyclerView = findViewById(R.id.refactor_rv);
        rg = findViewById(R.id.refactor_rg);
        rbCh = rg.findViewById(R.id.refactor_rb_ch);
        btnSave = findViewById(R.id.refactor_save_to_file);
        rbCh.setChecked(true);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        timetableData = ((App) getApplication()).appComponent.getTimetableData();
        refactorAdapter = new RefactorAdapter(timetableData.lessonsCh, timetableData.lessonsZn, timetableData.lessonsBegin,
                timetableData.lessonsEnd, timetableData.days, timetableData, this);

        recyclerView.setAdapter(refactorAdapter);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        toolbar = findViewById(R.id.refactor_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                refactorAdapter.setChChecked(rbCh.isChecked());
                refactorAdapter.notifyDataSetChanged();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (rbCh.isChecked())
                        timetableData.writeToFile(timetableData.lessonsCh, "lessonsCh", context);
                    else
                        timetableData.writeToFile(timetableData.lessonsZn, "lessonsZn", context);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}