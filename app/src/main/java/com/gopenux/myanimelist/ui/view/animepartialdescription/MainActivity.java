package com.gopenux.myanimelist.ui.view.animepartialdescription;

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
    ViewModelAnimePartialDescription viewModelAnimePartialDescription;

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

    private void initViewModelAnimeDescription() {
        viewModelAnimePartialDescription =
                new ViewModelProvider(this)
                        .get(ViewModelAnimePartialDescription.class);
    }
    @SuppressLint({"NotifyDataSetChanged", "SetTextI18n"})
    public void initRecyclerViewAnimeList() {
        animeDescriptionAdapter = new AnimeDescriptionAdapter();

        viewModelAnimePartialDescription.hideShowAnimeList
                .observeForever(hideShowAnimeList
                        -> binding.rvAnimeList.setVisibility(hideShowAnimeList));

        binding.rvAnimeList.setLayoutManager(
                new LinearLayoutManager(this)
        );
        binding.rvAnimeList.setHasFixedSize(true);
        binding.rvAnimeList.setAdapter(animeDescriptionAdapter);
        animeDescriptionAdapter.notifyDataSetChanged();

        viewModelAnimePartialDescription.showRecyclerViewAnimeList();
        viewModelAnimePartialDescription.isLoadingAnimeList
                .observeForever(aBoolean -> binding.pbIsLoading.setVisibility(aBoolean));
        viewModelAnimePartialDescription.numberItemsAnimeList
                .observeForever(numberItemsAnimeList
                        -> binding.tvNumberItems.setText(numberItemsAnimeList.toString()));
    }

    private void updateAnimeList() {
        binding.ibUpdateMainActivity.setOnClickListener(
                view -> viewModelAnimePartialDescription.updateAnimeList());

        viewModelAnimePartialDescription.updateAnimeList.
                observeForever(updateAnimeList ->
                        binding.rvAnimeList.setVisibility(updateAnimeList));
    }
}