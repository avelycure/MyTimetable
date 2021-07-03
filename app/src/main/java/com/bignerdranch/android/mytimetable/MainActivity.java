package com.bignerdranch.android.mytimetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.android.mytimetable.model.Time;
import com.bignerdranch.android.mytimetable.timetable.Timetable;
import com.bignerdranch.android.mytimetable.util.AdapterForCards;

public class MainActivity extends AppCompatActivity {
    private final int USERID = 6000;
    private Time time;
    AdapterForCards adapter;

    private TextView myDate1;
    private TextView myDate2;
    private TextView tvWeekDay;
    private RecyclerView myrec;
    private Button btnNext;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = new Time();

        getReferences();

        setText();

        setListeners(this);

        showWeekDay(this);

        myrec = (RecyclerView) findViewById(R.id.time_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myrec.setLayoutManager(layoutManager);

        adapter = new AdapterForCards(time, this);
        myrec.setAdapter(adapter);
    }

    //Getting referencies to all components of activity
    public void getReferences() {
        myDate1 = findViewById(R.id.date_text1);
        myDate2 = findViewById(R.id.date_text2);
        btnBack = findViewById(R.id.date_back);
        btnNext = findViewById(R.id.date_next);
    }

    //Setting date and day of week
    public void setText() {
        myDate1.setText(time.getDayOfMonth() + " " + time.getMonth());
        myDate2.setText(Timetable.days[time.getDayOfWeekNum()]);
    }

    //Setting listeners on buttons
    public void setListeners(final Context context) {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForWeekDay();
                time.changeMyCalendar(-1);
                setText();
                showWeekDay(context);
                adapter.notifyDataSetChanged();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForWeekDay();
                time.changeMyCalendar(1);
                setText();
                showWeekDay(context);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void showWeekDay(Context context) {
        if (time.getWeekType() == 0 && Timetable.lessonsCh[time.getDayOfWeekNum()].length == 0 ||
                time.getWeekType() == 1 && Timetable.lessonsZn[time.getDayOfWeekNum()].length == 0) {
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
        if (time.getWeekType() == 0 && Timetable.lessonsCh[time.getDayOfWeekNum()].length == 0 ||
                time.getWeekType() == 1 && Timetable.lessonsZn[time.getDayOfWeekNum()].length == 0) {
            tvWeekDay = findViewById(USERID);
        }
    }

}