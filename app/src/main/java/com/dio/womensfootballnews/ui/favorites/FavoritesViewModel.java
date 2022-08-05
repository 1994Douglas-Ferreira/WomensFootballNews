package com.dio.womensfootballnews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dio.womensfootballnews.data.WomensNewsRepository;
import com.dio.womensfootballnews.domain.News;

import java.util.List;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {

    }

    public LiveData<List<News>> loadFavoriteNews() {
        return WomensNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> WomensNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }
}