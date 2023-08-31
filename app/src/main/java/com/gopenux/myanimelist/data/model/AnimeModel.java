package com.gopenux.myanimelist.data.model;

import android.net.Uri;

public class AnimeModel {

    private String animeName;
    private String animeSynopsis;
    private Uri animeImage;

    public AnimeModel(String animeName, String animeSynopsis, Uri animeImage) {
        this.animeName = animeName;
        this.animeSynopsis = animeSynopsis;
        this.animeImage = animeImage;
    }

    public AnimeModel() {
    }

    public String getAnimeName() {
        return animeName;
    }

    public String getAnimeSynopsis() {
        return animeSynopsis;
    }

    public Uri getAnimeImage() {
        return animeImage;
    }
}
