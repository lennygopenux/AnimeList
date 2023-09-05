package com.gopenux.myanimelist.ui.recyclerviewanimelist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gopenux.myanimelist.R;
import com.gopenux.myanimelist.databinding.ActivityVisualizeAnimeSynopsisBinding;
import com.gopenux.myanimelist.databinding.ItemAnimeBinding;
import com.gopenux.myanimelist.ui.view.animefulldescription.VisualizeAnimeSynopsis;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class AnimeDescriptionViewHolder extends RecyclerView.ViewHolder implements IAnimeDescriptionViewHolder {

    protected final ItemAnimeBinding bindingAnime = ItemAnimeBinding.bind(itemView);
    protected ActivityVisualizeAnimeSynopsisBinding visualizeAnimeSynopsisBinding;
    protected ImageView imageAnime;
    protected TextView textViewAnimeName;
    protected String animeSynopsis;
    protected Uri uriAnimeImage;

    private final Map<String, String> mapIntentAnimeDescription = new HashMap<>();

    public AnimeDescriptionViewHolder(@NonNull View itemView) {
        super(itemView);
        visualizeAnimeSynopsisBinding =
                ActivityVisualizeAnimeSynopsisBinding
                        .inflate(LayoutInflater
                                .from(itemView.getContext()));
        this.imageAnime = bindingAnime.ivAnime;
        this.textViewAnimeName = bindingAnime.tvAnimeName;
        this.uriAnimeImage = Uri.EMPTY;
        this.animeSynopsis = toString();
    }

    @Override
    public void setBindAnimeDescriptionImage(Uri uriImageAnime) {
        this.uriAnimeImage = uriImageAnime;

        Picasso.with(itemView.getContext())
                .load(uriImageAnime)
                .resize(800, 800)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageAnime);
    }

    @Override
    public void setBindAnimeTitle(String animeName) {
        textViewAnimeName.setText(animeName);
    }

    @Override
    public void setBindAnimeSynopsis(String animeSynopsis) {
        visualizeAnimeSynopsisBinding.tvAnimeSynopsis.setText(animeSynopsis);
    }

    //TODO: El método y función siguientes deben estar en otra clase para cumplir con el
    // principio de single responsability
    @Override
    public void navigateSynopsisAnimeScreen(Context context) {

        imageAnime.setOnClickListener(v -> {
            Intent intent = new Intent(context, VisualizeAnimeSynopsis.class);

            for (Map.Entry<String, String> animeFullDescription : mapAnimeDescriptionData().entrySet()) {
                intent.putExtra(animeFullDescription.getKey(), animeFullDescription.getValue());
            }

            context.startActivity(intent);
        });
    }

    private Map<String, String> mapAnimeDescriptionData() {

        mapIntentAnimeDescription.
                put("animeImage", uriAnimeImage.toString());
        mapIntentAnimeDescription.
                put("animeName", textViewAnimeName.getText().toString());
        mapIntentAnimeDescription.
                put("animeSynopsis", visualizeAnimeSynopsisBinding.tvAnimeSynopsis
                        .getText().toString());

        return mapIntentAnimeDescription;
    }
}
