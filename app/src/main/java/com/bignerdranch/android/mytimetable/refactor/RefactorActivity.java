package com.bignerdranch.android.mytimetable.refactor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bignerdranch.android.mytimetable.R;
import com.bignerdranch.android.mytimetable.data.TimetableData;


//todo add coordinator layout
public class RefactorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private RadioGroup rg;
    private RadioButton rbCh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refactor__activity);

        recyclerView = findViewById(R.id.refactor_rv);
        rg = findViewById(R.id.refactor_rg);
        rbCh = rg.findViewById(R.id.refactor_rb_ch);
        rbCh.setChecked(true);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        TimetableData timetableData = new TimetableData(this);

        final RefactorAdapter refactorAdapter = new RefactorAdapter(timetableData.lessonsCh, timetableData.lessonsZn, timetableData.lessonsBegin,
                timetableData.lessonsEnd, timetableData.days, this);

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