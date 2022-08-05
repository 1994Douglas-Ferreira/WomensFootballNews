package com.dio.womensfootballnews.data;

import androidx.room.Room;

import com.dio.womensfootballnews.App;
import com.dio.womensfootballnews.data.local.WomensNewsDb;
import com.dio.womensfootballnews.data.remote.WomensNewsAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WomensNewsRepository {
    //region Constantes
    private static final String REMOTE_API_URL = "https://1994douglas-ferreira.github.io/womens-football-news-api//";
    private static final String LOCAL_DB_NAME = "womens-news";
    //endregion

    //region Atributos: encapsulamento acesso a nossa API (Retrofit) e banco de dados local (Room).
    private final WomensNewsAPI remoteApi;
    private final WomensNewsDb localDb;

    public WomensNewsAPI getRemoteApi() {
        return remoteApi;
    }

    public WomensNewsDb getLocalDb() {
        return localDb;
    }
    //endregion

    //region Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
    private WomensNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WomensNewsAPI.class);

        localDb = Room.databaseBuilder(App.getInstance(), WomensNewsDb.class, LOCAL_DB_NAME)
                .build();
    }

    public static WomensNewsRepository getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final WomensNewsRepository INSTANCE = new WomensNewsRepository();
    }
    //endregion
}
