package com.gopenux.myanimelist.ui.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gopenux.myanimelist.databinding.ActivityMainBinding;
import com.gopenux.myanimelist.ui.recyclerviewanimelist.AnimeDescriptionAdapter;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    AnimeDescriptionAdapter animeDescriptionAdapter;
    ViewModelAnimeDescription viewModelAnimeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        initViewModelAnimeDescription();
        initRecyclerViewAnimeList();
        updateAnimeList();
    }

    @SuppressLint({"NotifyDataSetChanged", "SetTextI18n"})
    public void initRecyclerViewAnimeList() {
        animeDescriptionAdapter =
                new AnimeDescriptionAdapter();

        viewModelAnimeDescription.hideShowAnimeList
                .observeForever(hideShowAnimeList
                        -> binding.rvAnimeList.setVisibility(hideShowAnimeList));

        binding.rvAnimeList.setHasFixedSize(true);

        binding.rvAnimeList.setAdapter(animeDescriptionAdapter);
        animeDescriptionAdapter.notifyDataSetChanged();

        binding.rvAnimeList.setLayoutManager(
                new LinearLayoutManager(this));

        viewModelAnimeDescription.showRecyclerViewAnimeList();

        viewModelAnimeDescription.isLoadingAnimeList
                .observeForever(aBoolean -> binding.pbIsLoading.setVisibility(aBoolean));

        viewModelAnimeDescription.numberItemsAnimeList
                .observeForever(numberItemsAnimeList
                        -> binding.tvNumberItems.setText(numberItemsAnimeList.toString()));
    }

    private void initViewModelAnimeDescription() {
        viewModelAnimeDescription =
                new ViewModelProvider(this)
                        .get(ViewModelAnimeDescription.class);
    }

    private void updateAnimeList() {
        binding.ibUpdateMainActivity.setOnClickListener(
                view -> viewModelAnimeDescription.updateAnimeList());

        viewModelAnimeDescription.updateAnimeList.
                observeForever(updateAnimeList ->
                        binding.rvAnimeList.setVisibility(updateAnimeList));
    }
}