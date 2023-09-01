package com.gopenux.myanimelist.ui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.provider.AnimeListProvider;
import com.gopenux.myanimelist.data.repository.AnimeDescriptionFromProvider;
import com.gopenux.myanimelist.domain.GetAnimeDescriptionUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelAnimeDescription extends ViewModel {


    @SuppressLint("StaticFieldLeak")
    private final Activity activity = new Activity();
    private final GetAnimeDescriptionUseCase getAnimeDescriptionUseCase =
            new GetAnimeDescriptionUseCase();

    public MutableLiveData<List<AnimeModel>> animeList;

    public MutableLiveData<Integer> numberItemsAnimeList;

    public MutableLiveData<Integer> isLoadingAnimeList;

    public MutableLiveData<Integer> updateAnimeList;

    public MutableLiveData<Integer> hideShowAnimeList;

    @Inject
    public ViewModelAnimeDescription(
    ) {
        this.animeList = new MutableLiveData<>();
        this.numberItemsAnimeList = new MutableLiveData<>();
        this.isLoadingAnimeList = new MutableLiveData<>();
        this.updateAnimeList = new MutableLiveData<>();
        this.hideShowAnimeList = new MutableLiveData<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void showRecyclerViewAnimeList() {

        isLoadingAnimeList.setValue(View.VISIBLE);
        hideShowAnimeList.setValue(View.INVISIBLE);
        numberItemsAnimeList.setValue(0);

        Thread threadShowRecyclerViewAnimeList = new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                activity.runOnUiThread(() -> {
                    if (!getAnimeDescriptionUseCase.getAnimeDescription().isEmpty()) {
                        isLoadingAnimeList.setValue(View.INVISIBLE);
                        numberItemsAnimeList.setValue(
                                getAnimeDescriptionUseCase.getAnimeDescription().size()
                        );
                        hideShowAnimeList.setValue(View.VISIBLE);
                    }
                });
            }
        };
        threadShowRecyclerViewAnimeList.start();
    }

    public void updateAnimeList() {
        updateAnimeList.setValue(View.INVISIBLE);
        isLoadingAnimeList.setValue(View.VISIBLE);
        Thread threadHideShowAnimeList = new Thread() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                activity.runOnUiThread(() -> {
                    updateAnimeList.setValue(View.VISIBLE);
                    isLoadingAnimeList.setValue(View.INVISIBLE);
                });
            }
        };
        threadHideShowAnimeList.start();
    }
}
