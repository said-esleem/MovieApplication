package com.blogapp.aws.movieuitemplate;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        // ini views
        iniViews();
    }

    void iniViews() {
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        tv_title = findViewById(R.id.detail_movie_title);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String image = intent.getStringExtra("image");

        tv_title.setText(title);

        Glide.with(this).load(image).into(MovieThumbnailImg);
        getSupportActionBar().setTitle(title);

        play_fab = findViewById(R.id.play_fab);

        tv_description = findViewById(R.id.detail_movie_desc);
        // setup animation
//        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }

}
