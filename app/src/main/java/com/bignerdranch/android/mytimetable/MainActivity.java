package com.bignerdranch.android.mytimetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.android.mytimetable.model.Time;
import com.bignerdranch.android.mytimetable.timetable.Timetable;
import com.bignerdranch.android.mytimetable.util.OnSwipeTouchListener;

public class MainActivity extends AppCompatActivity {
    private final int USERID = 6000;
    private Time time;

    TimeTableFragment myFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    LinearLayout linearLayoutMain;
    LinearLayout linearLayoutContainer;
    private TextView myDate1;
    private TextView myDate2;
    private TextView tvWeekDay;
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

        hideSystemUI();
        ShowWeekDay(this);
    }

    //Getting referencies to all components of activity
    public void getReferences() {

        myDate1 = findViewById(R.id.date_text1);
        myDate2 = findViewById(R.id.date_text2);
        btnBack = findViewById(R.id.date_back);
        btnNext = findViewById(R.id.date_next);
        linearLayoutMain = findViewById(R.id.layout_main);
        linearLayoutContainer = findViewById(R.id.container);

        //Получаем ссылку на фрагмент и вставляем его в активность
        fragmentManager = getSupportFragmentManager();
        myFragment = new TimeTableFragment(time);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, myFragment);
        fragmentTransaction.commit();
    }

    public void updateFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(myFragment);
        myFragment = new TimeTableFragment(time);
        fragmentTransaction.add(R.id.container, myFragment);
        fragmentTransaction.commit();
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
                time.ChangeMyCalendar(-1);
                setText();
                updateFragment();//Обновление фрагмента после изменения даты
                ShowWeekDay(context);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForWeekDay();
                time.ChangeMyCalendar(1);
                setText();
                updateFragment();
                ShowWeekDay(context);
            }
        });

        linearLayoutMain.setOnTouchListener(new OnSwipeTouchListener(this, btnBack, btnNext));
        linearLayoutContainer.setOnTouchListener(new OnSwipeTouchListener(this, btnBack, btnNext));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }


    private void ShowWeekDay(Context context) {
        if (time.getWeekType() == 0 && Timetable.lessonsCh[time.getDayOfWeekNum()].length == 0 ||
            time.getWeekType() == 1 && Timetable.lessonsZn[time.getDayOfWeekNum()].length == 0) {
            tvWeekDay = findViewById(USERID);
            if (tvWeekDay != null) {
                linearLayoutContainer.removeView(tvWeekDay);
            }
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
            linearLayoutContainer.addView(tvWeekDay);
        }
    }

    private void checkForWeekDay() {
        if (time.getWeekType() == 0 && Timetable.lessonsCh[time.getDayOfWeekNum()].length == 0 ||
            time.getWeekType() == 1 && Timetable.lessonsZn[time.getDayOfWeekNum()].length == 0) {
            tvWeekDay = findViewById(USERID);
            if (tvWeekDay != null) {
                linearLayoutContainer.removeView(tvWeekDay);
            }
        }
    }

}