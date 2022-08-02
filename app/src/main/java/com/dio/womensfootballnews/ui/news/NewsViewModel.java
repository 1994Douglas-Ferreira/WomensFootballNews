package com.dio.womensfootballnews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dio.womensfootballnews.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        //TODO Remover mock de notices

        List<News> news = new ArrayList<>();
        news.add(new News("Pronunciamento do clube","Sport repudia \"qualquer ato de racismo\" e diz que está apurando caso relatado por jogadora na Ilha"));
        news.add(new News("Novas responsabilidades","Pia distribui liderança na Seleção com ausência da capitã Marta na Copa América"));
        news.add(new News("Brasil campeão!","Seleção sofre, mas Debinha resolve e garante título da Copa América Feminina com recordes"));

        this.news.setValue(news);

    }

    public LiveData<List<News>> getNews() {return news;}
}