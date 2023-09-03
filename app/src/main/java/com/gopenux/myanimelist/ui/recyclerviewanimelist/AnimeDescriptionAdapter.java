package com.gopenux.myanimelist.ui.recyclerviewanimelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gopenux.myanimelist.R;
import com.gopenux.myanimelist.domain.GetAnimeDescriptionUseCase;

public class AnimeDescriptionAdapter extends RecyclerView.Adapter<AnimeDescriptionViewHolder> {

    private Context context;

    private final GetAnimeDescriptionUseCase getAnimeDescriptionUseCase =
            new GetAnimeDescriptionUseCase();

    @NonNull
    @Override
    public AnimeDescriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new AnimeDescriptionViewHolder(
                layoutInflater.inflate(
                        R.layout.item_anime,
                        parent,
                        false
                ));
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeDescriptionViewHolder holder, int position) {

        holder.navigateSynopsisAnimeScreen(context);

        holder.setBindAnimeDescriptionImage(
                getAnimeDescriptionUseCase.getAnimeDescription()
                        .get(position).getAnimeImage()
        );

        holder.setBindAnimeTitle(
                getAnimeDescriptionUseCase.getAnimeDescription()
                        .get(position).getAnimeName()
        );

        holder.setBindAnimeSynopsis(
                getAnimeDescriptionUseCase.getAnimeDescription()
                        .get(position).getAnimeSynopsis()
        );
    }

    @Override
    public int getItemCount() {
        return getAnimeDescriptionUseCase.getAnimeDescription().size();
    }
}
