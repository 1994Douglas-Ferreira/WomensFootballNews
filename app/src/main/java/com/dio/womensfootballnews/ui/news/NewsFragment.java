package com.dio.womensfootballnews.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.dio.womensfootballnews.MainActivity;
import com.dio.womensfootballnews.data.local.AppDatabase;
import com.dio.womensfootballnews.databinding.FragmentNewsBinding;
import com.dio.womensfootballnews.ui.adapter.NewsAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private AppDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel homeViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        homeViewModel.getNews().observe(getViewLifecycleOwner(), news -> {
            binding.rvNews.setAdapter(new NewsAdapter(news, updatedNews-> {
                MainActivity mActivity = (MainActivity) getActivity();
                if (mActivity != null) {
                    mActivity.getDb().newsDao().save(updatedNews);
                }
            }));
        });

        homeViewModel.getState().observe(getViewLifecycleOwner(), state -> {
            switch (state){
                case DOING:
                    //TODO iniciar SwipeRefreshLayout (loading)
                    break;
                case DONE:
                    //TODO finalizar SwipeRefreshLayout (loading)
                    break;
                case ERROR:
                    //TODO finalizar SwipeRefreshLayout (loading)
                    //TODO mostrar um erro generico
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}