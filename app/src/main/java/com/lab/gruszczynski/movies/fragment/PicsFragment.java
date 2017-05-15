package com.lab.gruszczynski.movies.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.lab.gruszczynski.movies.R;

/**
 * Created by maciej on 15.05.17.
 */


public class PicsFragment extends Fragment {

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pics, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        context=getActivity();
        GridView gridview = (GridView) getView().findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(context));
        super.onActivityCreated(savedInstanceState);
    }

    private class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public Integer[] mThumbIds = {R.drawable.piraci, R.drawable.piraci2, R.drawable.piraci3, R.drawable.piraci4, R.drawable.piraci5, R.drawable.piraci6};


        public ImageAdapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setAdjustViewBounds(true);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
    }

}
