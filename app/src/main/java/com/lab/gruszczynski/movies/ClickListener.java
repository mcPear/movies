package com.lab.gruszczynski.movies;

import android.view.View;

/**
 * Created by maciej on 14.04.17.
 */
public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
