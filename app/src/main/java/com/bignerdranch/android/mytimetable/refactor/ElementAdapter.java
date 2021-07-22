package com.bignerdranch.android.mytimetable.refactor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.mytimetable.R;

import java.util.ArrayList;
import java.util.List;

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ElementViewHolder> {
    private List<String> lessons;
    private ArrayList<List<String>> lessonsBegin;
    private ArrayList<List<String>> lessonsEnd;

    public ElementAdapter(List<String> lessons, ArrayList<List<String>> lessonsBegin, ArrayList<List<String>> lessonsEnd) {
        this.lessons = lessons;
        this.lessonsBegin = lessonsBegin;
        this.lessonsEnd = lessonsEnd;
    }

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.refactor__rv_in_rv, null, false);
        return new ElementViewHolder(relativeLayout);
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    @Override
    public void onBindViewHolder(ElementViewHolder holder, int position) {
        holder.bind(position);
    }

    class ElementViewHolder extends RecyclerView.ViewHolder {
        private EditText editText;
        private TextView tvTimeBegin;
        private TextView tvTimeEnd;

        public void bind(int position) {
            editText.setText(lessons.get(position));
            tvTimeBegin.setText(lessonsBegin.get(position).get(0) + ":" + lessonsBegin.get(position).get(1));
            tvTimeEnd.setText(lessonsEnd.get(position).get(0) + ":" + lessonsEnd.get(position).get(1));
        }

        public ElementViewHolder(View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.refactor_et);
            tvTimeBegin = itemView.findViewById(R.id.refactor_tv_time_begin);
            tvTimeEnd = itemView.findViewById(R.id.refactor_tv_time_end);
        }
    }
}
