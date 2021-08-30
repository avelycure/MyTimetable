package com.bignerdranch.android.mytimetable.refactor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.mytimetable.R;

import java.util.ArrayList;
import java.util.List;

public class RefactorAdapter extends RecyclerView.Adapter<RefactorAdapter.RefactorViewHolder> {
    private ArrayList<List<String>> lessonsCh;
    private ArrayList<List<String>> lessonsZn;
    private ArrayList<List<String>> lessonsBegin;
    private ArrayList<List<String>> lessonsEnd;
    private ArrayList<String> days;

    private ElementAdapter elementAdapter;

    private static final int DAYS = 7;
    private Context context;
    private boolean chChecked;

    public void setChChecked(boolean chChecked) {
        this.chChecked = chChecked;
    }

    public RefactorAdapter(ArrayList<List<String>> lessonsCh, ArrayList<List<String>> lessonsZn,
                           ArrayList<List<String>> lessonsBegin, ArrayList<List<String>> lessonsEnd,
                           ArrayList<String> days, Context context) {
        this.lessonsCh = lessonsCh;
        this.lessonsZn = lessonsZn;
        this.context = context;
        this.lessonsBegin = lessonsBegin;
        this.lessonsEnd = lessonsEnd;
        this.days = days;
        chChecked = true;
    }

    public RefactorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.refactor__rv_card,
                null, false);
        elementAdapter = new ElementAdapter(lessonsBegin, lessonsEnd);
        return new RefactorViewHolder(cardView);
    }

    @Override
    public int getItemCount() {
        return DAYS;
    }

    @Override
    public void onBindViewHolder(RefactorViewHolder holder, int position) {
        holder.bind(position);
    }

    class RefactorViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private RecyclerView recyclerViewElement;

        public void bind(int position) {
            Log.d("tag", "pos: " + position + " " + lessonsCh.size());
            if (chChecked)
                elementAdapter.setLessons(lessonsCh.get(position));
            else
                elementAdapter.setLessons(lessonsZn.get(position));

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            recyclerViewElement.setLayoutManager(linearLayoutManager);
            recyclerViewElement.setAdapter(elementAdapter);

            tv.setText(days.get(position));
        }

        public RefactorViewHolder(View itemView) {
            super(itemView);
            recyclerViewElement = itemView.findViewById(R.id.refactor_rv_in_rv);
            tv = itemView.findViewById(R.id.refactor_tv_day_of_week);
        }
    }
}
