package com.gopenux.myanimelist.domain;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.repository.AnimeDescriptionFromProvider;

import java.util.List;

public class GetAnimeDescriptionUseCase {
    AnimeDescriptionFromProvider animeDescriptionFromProvider;

    public GetAnimeDescriptionUseCase(AnimeDescriptionFromProvider animeDescriptionFromProvider){
        this.animeDescriptionFromProvider = animeDescriptionFromProvider;
    }

    public List<AnimeModel> getAnimeDescription(){
        return animeDescriptionFromProvider.getAnimeDescriptionFromProvider();
    }
}
