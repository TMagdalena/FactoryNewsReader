package com.example.android.factorynewsreader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * {@link Parser} is a public class which parses JSON response
 */
public class Parser {

    private static final String TAG = "Parser";

    /**
     * Private constructor because we should never create an instance of this class
     */
    private Parser() {
    }

    /**
     * Public method for extracting articles from a JSON response
     * @return an ArrayList of articles
     */
    public static ArrayList<Article> extractArticles(String JSON_RESPONSE) {

        ArrayList<Article> articles = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(JSON_RESPONSE);
            JSONArray articlesArray = baseJsonResponse.getJSONArray("articles");

            if(articlesArray.length() > 0) {
                for (int i = 0; i < articlesArray.length(); i++) {

                    JSONObject currentArticle = articlesArray.getJSONObject(i);

                    String author = currentArticle.getString("author");
                    String title = currentArticle.getString("title");
                    String description = currentArticle.getString("description");
                    String url = currentArticle.getString("url");
                    String urlToImage = currentArticle.getString("urlToImage");
                    String publishedAt = currentArticle.getString("publishedAt");

                    articles.add(new Article(author, title, description, url, urlToImage, publishedAt));
                }
            }
        }
        catch (JSONException e) {
            Log.e(TAG, "Problem with parsing");
        }

        return articles;

    }

}
