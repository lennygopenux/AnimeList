package com.gopenux.myanimelist.ui.recyclerviewanimelist;

import android.content.Context;
import android.net.Uri;

public interface IAnimeDescriptionViewHolder {
    void setBindAnimeDescriptionImage(Uri uriImageAnime);

    void setBindAnimeTitle(String animeName);

    void setBindAnimeSynopsis(String animeSynopsis);

    void navigateSynopsisAnimeScreen(Context context);
}
