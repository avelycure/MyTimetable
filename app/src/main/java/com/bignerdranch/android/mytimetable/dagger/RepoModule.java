package com.bignerdranch.android.mytimetable.dagger;

import com.bignerdranch.android.mytimetable.data.TimetableData;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepoModule {
    @Provides
    @Singleton
    public TimetableData provideRepo(){
        return new TimetableData();
    }
}
