package com.dio.womensfootballnews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.dio.womensfootballnews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class WomensNewsDb extends RoomDatabase {
    public abstract NewsDao newsDao();
}