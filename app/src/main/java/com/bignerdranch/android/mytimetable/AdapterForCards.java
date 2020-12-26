package com.bignerdranch.android.mytimetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterForCards extends RecyclerView.Adapter<AdapterForCards.CardViewHolder>{
    Time adapterTime;
    Context context;
    public AdapterForCards(Time time, Context context){
        adapterTime = time;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.time_card, parent, false);
        return new CardViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        if (adapterTime.getWeekType() == 0){
            return Timetable.lessonsCh[adapterTime.getDayOfWeekNum()].length;
        }else{
            return Timetable.lessonsZn[adapterTime.getDayOfWeekNum()].length;
        }
    }

    class CardViewHolder extends RecyclerView.ViewHolder{
        TextView lessonName;
        TextView time_text1;
        TextView time_text2;
        CardView cardViewInHolder;

        public CardViewHolder(View cardView) {
            super(cardView);

            lessonName = cardView.findViewById(R.id.lesson_text);
            time_text1 = cardView.findViewById(R.id.time_text1);
            time_text2 = cardView.findViewById(R.id.time_text2);
            cardViewInHolder = (CardView) cardView;
        }

        void bind(CardViewHolder holder, int position){
            SetCurrentLesson(position);//Setting with green color current lesson

            if (adapterTime.getWeekType() == 0){
                lessonName.setText(Timetable.lessonsCh[adapterTime.getDayOfWeekNum()][position]);
            }else{
                lessonName.setText(Timetable.lessonsZn[adapterTime.getDayOfWeekNum()][position]);
            }

            time_text1.setText(Timetable.lessonsBegin[position][0]+":"+Timetable.lessonsBegin[position][1]);
            time_text2.setText(Timetable.lessonsEnd[position][0]+":"+Timetable.lessonsEnd[position][1]);
        }

        private void SetCurrentLesson(int position){
            boolean isCurrentLesson = false;
            //вычисляем текущее время в минутах от начала дня и подсвечиваем зелёным текущий урок
            int curMin = adapterTime.MINUTE + adapterTime.HOUR * 60;
            if ((curMin > Timetable.lessonsBeginInMinute[position] - 10) &&
               (curMin <= Timetable.lessonsEndInMinute[position]) &&
               (adapterTime.getDayInTimetable() == adapterTime.TODAY)){
                isCurrentLesson = true;
            }

            if (isCurrentLesson){
                cardViewInHolder.setCardBackgroundColor(context.getResources().getColor(R.color.colorMarkLesson));
            }
        }

    }
}

