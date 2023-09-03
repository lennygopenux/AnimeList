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

public class AnimeDescriptionViewHolder extends RecyclerView.ViewHolder {

    protected final ItemAnimeBinding bindingAnime = ItemAnimeBinding.bind(itemView);
    protected ActivityVisualizeAnimeSynopsisBinding visualizeAnimeSynopsisBinding;
    protected ImageView imageAnime;
    protected TextView textViewAnimeName;
    protected String animeSynopsis;
    protected Uri uriAnimeImage;

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

    protected void setBindAnimeDescriptionImage(Uri uriImageAnime) {
        this.uriAnimeImage = uriImageAnime;

        Picasso.with(itemView.getContext())
                .load(uriImageAnime)
                .resize(800, 800)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageAnime);
    }

    protected String bindGetAnimeDescriptionImage(){
        return this.uriAnimeImage.toString();
    }

    protected void setBindAnimeTitle(String animeName) {
        textViewAnimeName.setText(animeName);
    }

    protected String getBindAnimeTitle(){
        return textViewAnimeName.getText().toString();
    }

    protected void setBindAnimeSynopsis(String animeSynopsis) {
        visualizeAnimeSynopsisBinding.tvAnimeSynopsis.setText(animeSynopsis);
    }

    protected String getBindAnimeSynopsis(){
        return visualizeAnimeSynopsisBinding.tvAnimeSynopsis.getText().toString();
    }
    protected void navigateSynopsisAnimeScreen(Context context) {
        imageAnime.setOnClickListener(v -> {
            Intent intent = new Intent(context, VisualizeAnimeSynopsis.class);
            intent.putExtra("animeImage", bindGetAnimeDescriptionImage());
            intent.putExtra("animeName", getBindAnimeTitle());
            intent.putExtra("animeSynopsis", getBindAnimeSynopsis());
            context.startActivity(intent);
        });
    }
}
