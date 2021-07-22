package com.bignerdranch.android.mytimetable.refactor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.bignerdranch.android.mytimetable.R;

import java.util.ArrayList;
import java.util.List;

public class RefactorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refactor__activity);

        recyclerView = findViewById(R.id.refactor_rv);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        List<RefactorListModel> refactorListModelList = new ArrayList<>();
        RefactorAdapter refactorAdapter = new RefactorAdapter(refactorListModelList, this);

        recyclerView.setAdapter(refactorAdapter);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        toolbar = findViewById(R.id.refactor_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}