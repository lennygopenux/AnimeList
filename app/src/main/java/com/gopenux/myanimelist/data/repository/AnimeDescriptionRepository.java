package com.gopenux.myanimelist.data.repository;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.provider.AnimeListProvider;

import java.util.ArrayList;
import java.util.List;

public class AnimeDescriptionRepository {
    private final AnimeListProvider animeListProvider = new AnimeListProvider();

    List<AnimeModel> newListAnimeModel =
            new ArrayList<>(
                    animeListProvider.getAnimeList()
            );
    public List<AnimeModel> getAnimeDescriptionFromProvider() {
        return newListAnimeModel;
    }
}
