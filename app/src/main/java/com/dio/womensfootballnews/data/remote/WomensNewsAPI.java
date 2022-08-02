package com.dio.womensfootballnews.data.remote;

import com.dio.womensfootballnews.domain.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WomensNewsAPI {
    @GET("news.json")
    Call<List<News>> getNews();
}
