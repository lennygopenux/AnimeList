package com.gopenux.myanimelist.domain;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.repository.AnimeDescriptionFromProvider;

import java.util.ArrayList;
import java.util.List;

public class GetAnimeDescriptionUseCase {
    AnimeDescriptionFromProvider animeDescriptionFromProvider =
            new AnimeDescriptionFromProvider();
    List<AnimeModel> newListAnimeModel =
            new ArrayList<>(
                    animeDescriptionFromProvider.getAnimeDescriptionFromProvider()
            );

    public List<AnimeModel> getAnimeDescription() {
        return newListAnimeModel;
    }
}
