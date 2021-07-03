package com.bignerdranch.android.mytimetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bignerdranch.android.mytimetable.util.AdapterForCards;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final int USERID = 6000;
    private AdapterForCards adapter;

    private TextView myDate1;
    private TextView myDate2;
    private TextView tvWeekDay;
    private RecyclerView rv;
    private Button btnNext;
    private Button btnBack;

    private List<LessonModel> lessonModels;
    private MainActivityViewModel timeTableViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();

        setText();

        setListeners(this);

        //showWeekDay(this);

        timeTableViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class );

        timeTableViewModel.init();

        timeTableViewModel.getLessons().observe(this, new Observer<List<LessonModel>>() {
            @Override
            public void onChanged(List<LessonModel> lessonModels) {
                adapter.notifyDataSetChanged();
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

    //Setting date and day of week
    public void setText() {
        //myDate1.setText(time.getDayOfMonth() + " " + time.getMonth());
        //myDate2.setText(TimetableData.days[time.getDayOfWeekNum()]);
    }

    //Setting listeners on buttons
    public void setListeners(final Context context) {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkForWeekDay();
                timeTableViewModel.prevDay();
                setText();
                //showWeekDay(context);
                //adapter.setLessonModelsList(time.fillLessonModel());
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkForWeekDay();
                //time.changeMyCalendar(1);
                timeTableViewModel.nextDay();
                setText();
                //showWeekDay(context);
                //adapter.setLessonModelsList(time.fillLessonModel());
            }
        });
    }

    /*private void showWeekDay(Context context) {
        if (time.getWeekType() == 0 && TimetableData.lessonsCh[time.getDayOfWeekNum()].length == 0 ||
                time.getWeekType() == 1 && TimetableData.lessonsZn[time.getDayOfWeekNum()].length == 0) {
            tvWeekDay = findViewById(USERID);

            tvWeekDay = new TextView(context);
            tvWeekDay.setText("Выходной");
            tvWeekDay.setId(USERID);
            tvWeekDay.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            tvWeekDay.setTextColor(getResources().getColor(R.color.colortextViewMain));
            tvWeekDay.setTextSize(34);
            tvWeekDay.setGravity(Gravity.CENTER);
        }
    }

    private void checkForWeekDay() {
        if (time.getWeekType() == 0 && TimetableData.lessonsCh[time.getDayOfWeekNum()].length == 0 ||
                time.getWeekType() == 1 && TimetableData.lessonsZn[time.getDayOfWeekNum()].length == 0) {
            tvWeekDay = findViewById(USERID);
        }
    }*/

}