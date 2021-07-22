package com.bignerdranch.android.mytimetable.refactor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bignerdranch.android.mytimetable.R;

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ElementViewHolder> {

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.refactor__rv_in_rv, null, false);
        return new ElementViewHolder(linearLayout);
    }

    @Override
    public int getItemCount() {
        return 5;
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

        }

        public ElementViewHolder(View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.refactor_et);
            tvTimeBegin = itemView.findViewById(R.id.refactor_tv_time_begin);
            tvTimeEnd = itemView.findViewById(R.id.refactor_tv_time_end);
        }
    }
}
