package com.lab.gruszczynski.movies.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import com.lab.gruszczynski.movies.MovieActorsActivity;
import com.lab.gruszczynski.movies.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by maciej on 15.05.17.
 */
public class MovieFragment extends Fragment {

    ImageView posterImageView;
    TextView titleTextView;
    RatingBar ratingBar;
    TextView descriptionTextView;
    private final String userRatingKey = "userRating";
    private Context context;
    private final String sharedPrefsString = "prefs";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        posterImageView = (ImageView) getActivity().findViewById(R.id.posterImageView);
        titleTextView = (TextView) getActivity().findViewById(R.id.titleTextView);
        ratingBar = (RatingBar) getActivity().findViewById(R.id.ratingBar);
        descriptionTextView = (TextView) getActivity().findViewById(R.id.descriptionTextView);
        context=getActivity();

        Intent intent = getActivity().getIntent();
        posterImageView.setImageDrawable(context.getDrawable(intent.getIntExtra("posterDrawable",R.mipmap.ic_launcher)));
        posterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MovieActorsActivity.class);
                startActivity(intent);
            }
        });
        titleTextView.setText(intent.getStringExtra("title"));
        descriptionTextView.setText(intent.getStringExtra("description"));
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                saveUserRating();
            }
        });
        loadUserRating(titleTextView.getText().toString());
        super.onActivityCreated(savedInstanceState);
    }

    private void saveUserRating(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPrefsString,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(userRatingKey+titleTextView.getText().toString(), ratingBar.getRating());
        editor.commit();
    }

    private void loadUserRating(String title){
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPrefsString,MODE_PRIVATE);
        Float userRating = sharedPreferences.getFloat(userRatingKey+title, 0f);
        ratingBar.setRating(userRating);
    }
}
