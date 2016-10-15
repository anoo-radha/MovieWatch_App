package com.anuradha.moviewatch.adapters;


import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anuradha.moviewatch.NotificationsActivity;
import com.anuradha.moviewatch.R;
import com.anuradha.moviewatch.Utility;
import com.squareup.picasso.Picasso;

public class NotificationsListAdapter extends CursorAdapter{

    public NotificationsListAdapter(Context context, Cursor cursor, int flags){
        super(context, cursor, flags);

    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imageView = (ImageView) view.findViewById(R.id.notifications_poster);
        TextView releaseDateView = (TextView) view.findViewById(R.id.notifications_release_date);
        TextView voteView = (TextView) view.findViewById(R.id.notifications_rating);
        TextView titleView = (TextView) view.findViewById(R.id.notifications_movie_title);
        TextView runtimeView = (TextView) view.findViewById(R.id.notifications_runtime);
        TextView genreView = (TextView) view.findViewById(R.id.notifications_genre);
        TextView certificateView = (TextView) view.findViewById(R.id.notifications_certification);
        TextView plotView = (TextView) view.findViewById(R.id.notifications_plot);
        TextView directorView = (TextView) view.findViewById(R.id.notifications_director);
        TextView homepageView = (TextView) view.findViewById(R.id.notifications_webpage);

        String releaseDate = cursor.getString(NotificationsActivity.COLUMN_RELEASE_DATE);
        if(!releaseDate.equals(context.getString(R.string.not_available_sign))) {
//            String year = (releaseDate).substring(0, 4);
//            String month = (releaseDate).substring(4, 2);
//            String day = (releaseDate).substring(6, 2);
            String year = TextUtils.substring(releaseDate,0,4);
            String month = TextUtils.substring(releaseDate,4,6);
            String day = TextUtils.substring(releaseDate,6,8);
            releaseDateView.setText(Utility.getMonthName(month) + day + ", " + year);
        }
//        releaseDateView.setText(cursor.getString(NotificationsActivity.COLUMN_RELEASE_DATE));
        voteView.setText(cursor.getString(NotificationsActivity.COLUMN_RATING));
        titleView.setText(cursor.getString(NotificationsActivity.COLUMN_TITLE));
        runtimeView.setText(cursor.getString(NotificationsActivity.COLUMN_RUNTIME));
        genreView.setText(cursor.getString(NotificationsActivity.COLUMN_GENRE));
//        certificateView.setText(cursor.getString(NotificationsActivity.COLUMN_));
        plotView.setText(cursor.getString(NotificationsActivity.COLUMN_SYNOPSIS));
        directorView.setText(cursor.getString(NotificationsActivity.COLUMN_DIRECTOR));
        homepageView.setText(cursor.getString(NotificationsActivity.COLUMN_HOMEPAGE));
        Picasso.with(context).load(cursor.getString(NotificationsActivity.COLUMN_POSTER_PATH))
                .error(R.drawable.unavailable_poster_black)
                .into(imageView);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.notfications_list_item, parent, false);
    }
}
