/*package com.bignerdranch.android.mytimetable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;

import java.util.Calendar;

public class MyCardAdapter extends RecyclerView.Adapter<MyCardAdapter.ViewHolder>{
    //тип недели (числитель или знаменатель)
    private int weekType;
    private int today;
    private Calendar myCalendar;
    //номер дня недели
    private int dayOfWeekNum;
    //поля в карточке для заполнения
    TextView lessonName;
    TextView time_text1;
    TextView time_text2;

    @Override
    public int getItemCount(){
        if (weekType == 0){
            return Timetable.lessonsCh[dayOfWeekNum].length;
        }else{
            return Timetable.lessonsZn[dayOfWeekNum].length;
        }
    }

    public MyCardAdapter(Calendar myCalendar, int today){
        this.today = today;
        this.myCalendar = myCalendar;
        dayOfWeekNum = myCalendar.get(Calendar.DAY_OF_WEEK) - 2;
        if (dayOfWeekNum == -1){
            dayOfWeekNum = 6;
        }
        weekType = myCalendar.get(Calendar.WEEK_OF_YEAR) % 2;
        Log.d("Mytag", "today: " + today + "Calendar show : " + myCalendar.get(Calendar.DAY_OF_YEAR));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    @Override
    public MyCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.time_card, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Log.d("Mytag", "setting text");
        boolean isCurrentLesson = false;
        //вычисляем текущее время в минутах от начала дня и подсвечиваем зелёным текущий урок
        int curMin = myCalendar.get(Calendar.MINUTE) + myCalendar.get(Calendar.HOUR_OF_DAY) * 60;
        if ((curMin > Timetable.lessonsBeginInMinute[position] - 10) && (curMin <= Timetable.lessonsEndInMinute[position]) && (myCalendar.get(Calendar.DAY_OF_YEAR) == today)){
            isCurrentLesson = true;
        }
        CardView cardView = holder.cardView;

        if (isCurrentLesson){
            cardView.setCardBackgroundColor(0xff2ecc71);
        }

        lessonName = cardView.findViewById(R.id.lesson_text);
        time_text1 = cardView.findViewById(R.id.time_text1);
        time_text2 = cardView.findViewById(R.id.time_text2);

        if (weekType == 0){
            lessonName.setText(Timetable.lessonsCh[dayOfWeekNum][position]);
        }else{
            lessonName.setText(Timetable.lessonsZn[dayOfWeekNum][position]);
        }

        time_text1.setText(Timetable.lessonsBegin[position][0]+":"+Timetable.lessonsBegin[position][1]);
        time_text2.setText(Timetable.lessonsEnd[position][0]+":"+Timetable.lessonsEnd[position][1]);
    }

}
*/