package com.gopenux.myanimelist.ui.recyclerviewanimelist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gopenux.myanimelist.R;
import com.gopenux.myanimelist.databinding.ItemAnimeBinding;
import com.gopenux.myanimelist.ui.view.VisualizeAnimeSynopsis;
import com.squareup.picasso.Picasso;

public class AnimeDescriptionViewHolder extends RecyclerView.ViewHolder {

    protected final ItemAnimeBinding bindingAnime = ItemAnimeBinding.bind(itemView);
    protected ImageView imageAnime;
    protected TextView textViewAnimeName;
    protected TextView textViewAnimeSynopsis;
    protected String animeSynopsis;
    protected Uri uriAnimeImage;

    public AnimeDescriptionViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageAnime = bindingAnime.ivAnime;
        this.textViewAnimeName = bindingAnime.tvAnimeName;
        this.textViewAnimeSynopsis = bindingAnime.tvAnimeSynopsisInvisible;
        this.uriAnimeImage = Uri.EMPTY;
        this.animeSynopsis = "";
    }

    protected String bindAnimeDescriptionImage(Uri uriImageAnime) {
       this.uriAnimeImage = uriImageAnime;

        Picasso.with(itemView.getContext())
                .load(uriImageAnime)
                .resize(800, 800)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageAnime);

        return uriImageAnime.toString();
    }

    protected void bindAnimeTitle(String titleAnime) {
        this.animeSynopsis = titleAnime;
        textViewAnimeName.setText(titleAnime);
    }

    protected String bindAnimeSynopsis(String animeSynopsis){
        this.animeSynopsis = animeSynopsis;
        textViewAnimeSynopsis.setText(animeSynopsis);
        return animeSynopsis;
    }

    protected void navigateSynopsisAnimeScreen(Context context) {
        imageAnime.setOnClickListener(v -> {
            Intent intent = new Intent(context, VisualizeAnimeSynopsis.class);
            intent.putExtra("animeImage", bindAnimeDescriptionImage(uriAnimeImage));
            intent.putExtra("animeName", textViewAnimeName.getText().toString());
            intent.putExtra("animeSynopsis", bindAnimeSynopsis(animeSynopsis));
            context.startActivity(intent);
        });
    }
}
