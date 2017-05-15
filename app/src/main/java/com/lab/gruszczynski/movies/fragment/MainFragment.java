package com.lab.gruszczynski.movies.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.lab.gruszczynski.movies.*;
import com.lab.gruszczynski.movies.adapter.MoviesAdapter;
import com.lab.gruszczynski.movies.listener.RecyclerTouchListener;
import com.lab.gruszczynski.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by maciej on 15.05.17.
 */


public class MainFragment extends Fragment{

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private  RecyclerView.ItemDecoration mDividerItemDecoration;
    private LinearLayoutManager mLayoutManager;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        context = getActivity();
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList, context);
        mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayoutManager.getOrientation());
        recyclerView.addItemDecoration(mDividerItemDecoration);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(context, recyclerView, new MovieTouchlistener()));

        setUpItemTouchHelper();
        prepareMovieData();
        super.onActivityCreated(savedInstanceState);
    }

    private class MovieTouchlistener implements RecyclerTouchListener.ClickListener{
        @Override
        public void onClick(View view, int position) {
                Movie movie = mAdapter.getMovie(position);
                Toast.makeText(context, movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MovieActivity.class);
                intent.putExtra("title", movie.getTitle());
                intent.putExtra("description", movie.getDescription());
                intent.putExtra("posterDrawable", movie.getPosterDrawable());
            startActivity(intent);
        }
        @Override
        public void onLongClick(View view, int position) {
            mAdapter.getMovie(position).setWatchedByUser(true);
            mAdapter.notifyItemChanged(position);
        }
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        Random random = new Random();

        for(Movie m:movieList) {
            m.setDescription(context.getString(R.string.description1));
            switch(random.nextInt(3) ){
                case 0:
                    m.setPosterDrawable(R.drawable.starwars);
                    break;
                case 1:
                    m.setPosterDrawable(R.drawable.ryan);
                    break;
                case 2:
                    m.setPosterDrawable(R.drawable.martian);
                    break;

            }
        }

        mAdapter.notifyDataSetChanged();
    }

    private void setUpItemTouchHelper() {

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int swipedPosition = viewHolder.getAdapterPosition();
                mAdapter.remove(swipedPosition);
                mAdapter.notifyDataSetChanged();
            }


        };
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }

}
