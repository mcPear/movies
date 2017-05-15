package com.lab.gruszczynski.movies.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lab.gruszczynski.movies.R;

/**
 * Created by maciej on 15.05.17.
 */
public class ActorsFragment extends Fragment {

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_actors, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        context=getActivity();
        ImageView actor1ImageV = (ImageView) getView().findViewById(R.id.actorpic1);
        ImageView actor2ImageV = (ImageView) getView().findViewById(R.id.actorpic2);
        ImageView actor3ImageV = (ImageView) getView().findViewById(R.id.actorpic3);
        TextView actor1TextV = (TextView) getView().findViewById(R.id.aktor1);
        TextView actor2TextV = (TextView) getView().findViewById(R.id.aktor2);
        TextView actor3TextV = (TextView) getView().findViewById(R.id.aktor3);
        actor1ImageV.setImageDrawable(context.getDrawable(R.drawable.dicaprio));
        actor2ImageV.setImageDrawable(context.getDrawable(R.drawable.jolie));
        actor3ImageV.setImageDrawable(context.getDrawable(R.drawable.depp));
        actor1TextV.setText("Loenardo DiCaprio");
        actor2TextV.setText("Angelina Jolie");
        actor3TextV.setText("Johny Depp");
        //GridView gridview = (GridView) getView().findViewById(R.id.gridview);
        //gridview.setAdapter(new PicsFragment.ImageAdapter(context));
        super.onActivityCreated(savedInstanceState);
    }
}
