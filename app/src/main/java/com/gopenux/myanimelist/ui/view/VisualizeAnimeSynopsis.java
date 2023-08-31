package com.gopenux.myanimelist.ui.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gopenux.myanimelist.R;
import com.gopenux.myanimelist.databinding.ActivityVisualizeAnimeSynopsisBinding;
import com.squareup.picasso.Picasso;

public class VisualizeAnimeSynopsis extends AppCompatActivity {

    public ActivityVisualizeAnimeSynopsisBinding binding;

    //public TextView textSynopsisAnime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisualizeAnimeSynopsisBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //textSynopsisAnime = binding.tvAnimeSynopsis;

        ImageView imageAnime = binding.ivAnimeSynopsis;
        Bundle bundle = getIntent().getExtras();

        Picasso.with(this)
                .load(bundle.getString("animeImage"))
                .resize(800, 800)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageAnime);

        binding.tvAnimeName.setText(bundle.getString("animeName"));
        binding.tvAnimeSynopsis.setText(bundle.getString("animeSynopsis"));
    }
}