package com.gopenux.myanimelist.ui.recyclerviewanimelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gopenux.myanimelist.R;
import com.gopenux.myanimelist.data.model.AnimeModel;
import com.gopenux.myanimelist.data.provider.AnimeListProvider;
import com.gopenux.myanimelist.data.repository.AnimeDescriptionFromProvider;
import com.gopenux.myanimelist.domain.GetAnimeDescriptionUseCase;

import java.util.ArrayList;
import java.util.List;

public class AnimeDescriptionAdapter extends RecyclerView.Adapter<AnimeDescriptionViewHolder> {

    private Context context;
    private final List<AnimeModel> animeModel = new ArrayList<>();

    private final AnimeListProvider animeListProvider = new AnimeListProvider(animeModel);
    private final AnimeDescriptionFromProvider animeDescriptionFromProvider =
            new AnimeDescriptionFromProvider(animeListProvider);

    private final GetAnimeDescriptionUseCase getAnimeDescriptionUseCase =
            new GetAnimeDescriptionUseCase(animeDescriptionFromProvider);

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

        holder.bindAnimeDescriptionImage(
                    getAnimeDescriptionUseCase.getAnimeDescription().get(position).getAnimeImage());

        holder.bindAnimeTitle(
                    getAnimeDescriptionUseCase.getAnimeDescription().get(position).getAnimeName());

        holder.bindAnimeSynopsis(
                getAnimeDescriptionUseCase.getAnimeDescription().get(position).getAnimeSynopsis()
        );
    }

    @Override
    public int getItemCount() {
        return this.getAnimeDescriptionUseCase.getAnimeDescription().size();
    }
}
