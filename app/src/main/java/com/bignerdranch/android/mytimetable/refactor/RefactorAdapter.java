package com.bignerdranch.android.mytimetable.refactor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bignerdranch.android.mytimetable.R;

import java.util.List;

public class RefactorAdapter extends RecyclerView.Adapter<RefactorAdapter.RefactorViewHolder> {
    private List<RefactorListModel> refactorListModels;
    private static final int DAYS = 7;

    public RefactorAdapter(List<RefactorListModel> refactorListModels) {
        this.refactorListModels = refactorListModels;
    }

    public RefactorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.refactor__rv_card,
                null,false);
        return new RefactorViewHolder(constraintLayout);
    }

    @Override
    public int getItemCount() {
        return DAYS;
    }

    @Override
    public void onBindViewHolder(RefactorViewHolder holder, int position) {

    }

    class RefactorViewHolder extends RecyclerView.ViewHolder{

        public RefactorViewHolder(View itemView) {
            super(itemView);
        }
    }
}
