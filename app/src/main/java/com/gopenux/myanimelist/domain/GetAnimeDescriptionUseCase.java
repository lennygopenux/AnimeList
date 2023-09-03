package com.gopenux.myanimelist.domain;

import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.repository.AnimeDescriptionRepository;

import java.util.ArrayList;
import java.util.List;

public class GetAnimeDescriptionUseCase {
    AnimeDescriptionRepository animeDescriptionRepository = new AnimeDescriptionRepository();
    List<AnimeModel> newListAnimeModel =
            new ArrayList<>(
                    animeDescriptionRepository.getAnimeDescriptionFromProvider()
            );

    public List<AnimeModel> getAnimeDescription() {
        return newListAnimeModel;
    }
}
