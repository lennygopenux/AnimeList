package com.gopenux.myanimelist.domain;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.repository.AnimeDescriptionRepository;

import java.util.List;

public class GetAnimeDescriptionUseCase {

    AnimeDescriptionRepository animeDescriptionRepository;
    List<AnimeModel> newListAnimeModel;

    public GetAnimeDescriptionUseCase(AnimeDescriptionRepository animeDescriptionRepository){
        this.animeDescriptionRepository = animeDescriptionRepository;
        this.newListAnimeModel = animeDescriptionRepository.getAnimeDescriptionFromProvider();
    }

    public List<AnimeModel> getAnimeDescription() {
        return newListAnimeModel;
    }
}


