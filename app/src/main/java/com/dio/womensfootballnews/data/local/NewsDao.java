package com.dio.womensfootballnews.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.dio.womensfootballnews.domain.News;

import java.util.List;

@Dao
public interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE  )
    void insertNews(News... news);

    @Query("SELECT * FROM News WHERE favorite = 1")
    List<News> loadFavoriteNews();
}
