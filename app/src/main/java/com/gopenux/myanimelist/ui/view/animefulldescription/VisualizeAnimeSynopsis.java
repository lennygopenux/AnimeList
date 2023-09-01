package com.gopenux.myanimelist.ui.view.animefulldescription;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.gopenux.myanimelist.R;
import com.gopenux.myanimelist.databinding.ActivityVisualizeAnimeSynopsisBinding;
import com.squareup.picasso.Picasso;

public class VisualizeAnimeSynopsis extends AppCompatActivity {

    public ActivityVisualizeAnimeSynopsisBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisualizeAnimeSynopsisBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ImageView imageAnime = binding.ivAnimeSynopsis;
        Bundle bundleAnimeDescription = getIntent().getExtras();

        Picasso.with(this)
                .load(bundleAnimeDescription.getString("animeImage"))
                .resize(800, 800)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageAnime);

        binding.tvAnimeName.setText(
                bundleAnimeDescription.getString("animeName")
        );
        binding.tvAnimeSynopsis.setText(
                bundleAnimeDescription.getString("animeSynopsis")
        );
    }
}