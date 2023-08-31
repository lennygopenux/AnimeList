package com.gopenux.myanimelist.data.repository;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.provider.AnimeListProvider;

import java.util.List;

public class AnimeDescriptionFromProvider {
    private final AnimeListProvider animeListProvider;

    public AnimeDescriptionFromProvider(AnimeListProvider animeListProvider) {
        this.animeListProvider = animeListProvider;
    }

    public List<AnimeModel> getAnimeDescriptionFromProvider() {
        //this.animeListProvider.getAnimeList().clear();
        return this.animeListProvider.getAnimeList();
    }
}
