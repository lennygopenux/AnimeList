package com.gopenux.myanimelist.ui.view.animepartialdescription;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.provider.AnimeListProvider;
import com.gopenux.myanimelist.data.provider.IAnimeListProvider;
import com.gopenux.myanimelist.data.repository.AnimeDescriptionRepository;
import com.gopenux.myanimelist.domain.GetAnimeDescriptionUseCase;

import java.util.List;

public class ViewModelAnimePartialDescription extends ViewModel {

    @SuppressLint("StaticFieldLeak")
    private final Activity activity = new Activity();
    private final IAnimeListProvider animeListProvider = new AnimeListProvider();
    private final AnimeDescriptionRepository animeDescriptionRepository =
            new AnimeDescriptionRepository(animeListProvider);

    private final GetAnimeDescriptionUseCase getAnimeDescriptionUseCase =
            new GetAnimeDescriptionUseCase(animeDescriptionRepository);

    private final MutableLiveData<List<AnimeModel>> _animeList = new MutableLiveData<>();
    public LiveData<List<AnimeModel>> animeList = _animeList;

    private final MutableLiveData<Integer> _numberItemsAnimeList = new MutableLiveData<>();
    public LiveData<Integer> numberItemsAnimeList = _numberItemsAnimeList;

    private final MutableLiveData<Integer> _isLoadingAnimeList = new MutableLiveData<>();
    public LiveData<Integer> isLoadingAnimeList = _isLoadingAnimeList;

    private final MutableLiveData<Integer> _updateAnimeList = new MutableLiveData<>();

    public LiveData<Integer> updateAnimeList = _updateAnimeList;

    private final MutableLiveData<Integer> _hideShowAnimeList = new MutableLiveData<>();
    public MutableLiveData<Integer>  hideShowAnimeList = _hideShowAnimeList;

    @SuppressLint("NotifyDataSetChanged")
    public void showRecyclerViewAnimeList() {

        _isLoadingAnimeList.setValue(View.VISIBLE);
        _hideShowAnimeList.setValue(View.INVISIBLE);
        _numberItemsAnimeList.setValue(0);

        Thread threadShowRecyclerViewAnimeList = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                activity.runOnUiThread(() -> {
                    if (!getAnimeDescriptionUseCase.getAnimeDescription().isEmpty()) {
                        _isLoadingAnimeList.setValue(View.INVISIBLE);
                        _numberItemsAnimeList.setValue(
                                getAnimeDescriptionUseCase.getAnimeDescription().size()
                        );
                        _hideShowAnimeList.setValue(View.VISIBLE);
                    }
                });
            }
        };
        threadShowRecyclerViewAnimeList.start();
    }

    public void updateAnimeList() {

        _updateAnimeList.setValue(View.INVISIBLE);
        _isLoadingAnimeList.setValue(View.VISIBLE);

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
                    _updateAnimeList.setValue(View.VISIBLE);
                    _isLoadingAnimeList.setValue(View.INVISIBLE);
                });
            }
        };
        threadHideShowAnimeList.start();
    }
}
