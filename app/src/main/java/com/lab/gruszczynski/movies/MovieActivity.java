package com.lab.gruszczynski.movies;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maciej on 20.04.17.
 */
public class MovieActivity extends AppCompatActivity {
    @BindView(R.id.posterImageView)
    ImageView posterImageView;
    @BindView(R.id.guideline)
    Guideline guideline;
    @BindView(R.id.titleTextView)
    TextView titleTextView;
    @BindView(R.id.rateTextView)
    TextView rateTextView;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.descriptionTextView)
    TextView descriptionTextView;
    private final String userRatingKey = "userRating";
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        Intent intent = this.getIntent();
        posterImageView.setImageDrawable(getDrawable(intent.getIntExtra("posterDrawable",R.mipmap.ic_launcher)));
        titleTextView.setText(intent.getStringExtra("title"));
        descriptionTextView.setText(intent.getStringExtra("description"));
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                saveUserRating();
            }
        });
        loadUserRating(titleTextView.getText().toString());
    }

    private void saveUserRating(){
        title=titleTextView.getText().toString();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(userRatingKey+titleTextView.getText().toString(), ratingBar.getRating());
        editor.commit();
    }

    private void loadUserRating(String title){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        Float userRating = sharedPreferences.getFloat(userRatingKey+title, 0f);
        ratingBar.setRating(userRating);
    }

}
