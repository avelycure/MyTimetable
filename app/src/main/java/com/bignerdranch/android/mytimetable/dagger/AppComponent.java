package com.bignerdranch.android.mytimetable.dagger;

import com.bignerdranch.android.mytimetable.data.TimetableData;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RepoModule.class)
public interface AppComponent {
    TimetableData getTimetableData();
}
