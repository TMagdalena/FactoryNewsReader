package com.example.android.factorynewsreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link ArticleAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Article} objects
 */
public class ArticleAdapter extends ArrayAdapter<Article> {
    /**
     * Create a new {@link ArticleAdapter} object
     *
     * @param context is the current context that the adapter is being created in
     * @param articles is the list of {@link Article}s to be displayed
     */
    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Article currentArticle = getItem(position);

        new DownloadImage((ImageView) listItemView.findViewById(R.id.image))
                .execute(currentArticle.getImageURL());

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentArticle.getTitle());

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        descriptionTextView.setText(currentArticle.getDescription());

        return listItemView;

    }


}
