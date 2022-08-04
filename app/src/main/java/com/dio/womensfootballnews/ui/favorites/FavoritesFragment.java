package com.dio.womensfootballnews.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.dio.womensfootballnews.MainActivity;
import com.dio.womensfootballnews.databinding.FragmentFavoritesBinding;
import com.dio.womensfootballnews.domain.News;
import com.dio.womensfootballnews.ui.adapter.NewsAdapter;

import java.util.List;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel dashboardViewModel =
                new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);



        loadFavoriteNews();
        return binding.getRoot();
    }


    private void loadFavoriteNews() {
        MainActivity mActivity = (MainActivity) getActivity();

        if (mActivity != null) {
            List<News> favoriteNews = mActivity.getDb().newsDao().loadFavoriteNews();
            binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvNews.setAdapter(new NewsAdapter(favoriteNews, updatedNews-> {
                mActivity.getDb().newsDao().save(updatedNews);
                loadFavoriteNews();
            }));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}