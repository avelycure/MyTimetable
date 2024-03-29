package com.bignerdranch.android.mytimetable.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.mytimetable.R;

import java.util.List;


public class AdapterForCards extends RecyclerView.Adapter<AdapterForCards.CardViewHolder> {
    private Context context;
    private List<LessonModel> lessonModelsList;

    public AdapterForCards(Context context, List<LessonModel> lessonModels) {
        lessonModelsList = lessonModels;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home__rv_card, parent, false);
        return new CardViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return lessonModelsList.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
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

        void bind(int position) {
            if (lessonModelsList.get(position).isCurrentLesson())
                cardViewInHolder.setCardBackgroundColor(context.getResources().getColor(R.color.colorMarkLesson));
            else
                cardViewInHolder.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));

            lessonName.setText(lessonModelsList.get(position).getLessonName());
            time_text1.setText(lessonModelsList.get(position).getBeginTime());
            time_text2.setText(lessonModelsList.get(position).getEndTime());

            RecyclerView.LayoutParams param = (RecyclerView.LayoutParams) itemView.getLayoutParams();
            if (!lessonModelsList.get(position).getLessonName().equals("")) {
                param.height = CardView.LayoutParams.WRAP_CONTENT;
                param.width = CardView.LayoutParams.MATCH_PARENT;
                itemView.setVisibility(View.VISIBLE);
            } else {
                itemView.setVisibility(View.GONE);
                param.height = 0;
                param.width = 0;
            }
            itemView.setLayoutParams(param);
        }
    }
}

