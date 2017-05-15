package com.lab.gruszczynski.movies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lab.gruszczynski.movies.R;
import com.lab.gruszczynski.movies.model.Movie;

import java.util.List;

import static com.lab.gruszczynski.movies.R.id.posterImageView;

/**
 * Created by maciej on 14.04.17.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;
    private Context appContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView poster, eye;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            poster = (ImageView) view.findViewById(posterImageView);
            eye = (ImageView) view.findViewById(R.id.watchedByUser);
        }
    }


    public MoviesAdapter(List<Movie> moviesList, Context appContext) {
        this.moviesList = moviesList;
        this.appContext=appContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row_v2, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.poster.setImageDrawable(appContext.getDrawable(movie.getPosterDrawable()));

        if(movie.getWatchedByUser()) holder.eye.setVisibility(View.VISIBLE);
        else holder.eye.setVisibility(View.GONE);

    }

    public void remove(int position){
        Movie movie = moviesList.get(position);
        if (movie!=null)
            moviesList.remove(position);
    }

    public Movie getMovie(int position){
        return moviesList.get(position);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
