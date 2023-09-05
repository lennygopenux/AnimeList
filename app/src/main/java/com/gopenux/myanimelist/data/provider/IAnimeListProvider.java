package com.gopenux.myanimelist.data.provider;

import com.gopenux.myanimelist.data.model.AnimeModel;

import java.util.List;

public interface IAnimeListProvider {
    List<AnimeModel> getAnimeList();
}
