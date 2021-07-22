package com.bignerdranch.android.mytimetable.refactor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
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

    private static final int DAYS = 7;
    private Context context;

    public RefactorAdapter(ArrayList<List<String>> lessonsCh, ArrayList<List<String>> lessonsZn,
                           ArrayList<List<String>> lessonsBegin, ArrayList<List<String>> lessonsEnd, Context context) {
        this.lessonsCh = lessonsCh;
        this.lessonsZn = lessonsZn;
        this.context = context;
        this.lessonsBegin = lessonsBegin;
        this.lessonsEnd = lessonsEnd;
    }

    public RefactorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.refactor__rv_card,
                null, false);
        return new RefactorViewHolder(relativeLayout);
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
        private RecyclerView recyclerViewElement;

        public void bind(int position) {

            ElementAdapter elementAdapter = new ElementAdapter(lessonsCh.get(position), lessonsBegin, lessonsEnd);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            recyclerViewElement.setLayoutManager(linearLayoutManager);
            recyclerViewElement.setAdapter(elementAdapter);
        }

        public RefactorViewHolder(View itemView) {
            super(itemView);
            recyclerViewElement = itemView.findViewById(R.id.refactor_rv_in_rv);
        }
    }
}
