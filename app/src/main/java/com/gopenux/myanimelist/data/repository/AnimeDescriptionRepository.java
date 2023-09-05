package com.gopenux.myanimelist.data.repository;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.provider.IAnimeListProvider;

import java.util.List;

public class AnimeDescriptionRepository {

    IAnimeListProvider animeListProvider ;

    List<AnimeModel> newListAnimeModel;
    public AnimeDescriptionRepository(IAnimeListProvider animeListProvider){
        this.animeListProvider = animeListProvider;
        this.newListAnimeModel = animeListProvider.getAnimeList();
    }

    public List<AnimeModel> getAnimeDescriptionFromProvider() {
        return newListAnimeModel;
    }
}
