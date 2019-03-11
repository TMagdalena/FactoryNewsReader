package com.example.android.factorynewsreader;

import android.os.AsyncTask;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * {@link FetchData} is an {@link AsyncTask} that gets data from the given URL
 * and shows it inside main activity
 */
public class FetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    public static ArrayList<Article> articles;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://newsapi.org/v1/articles?apiKey=6946d0c07a1c4555a4186bfcade76398&sortBy=top&source=bbc-news");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            articles = Parser.extractArticles(data);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.loadingIndicator.setVisibility(View.GONE);

        MainActivity.adapter = new ArticleAdapter(NewsApp.getAppContext(), articles);
        MainActivity.listView.setAdapter(MainActivity.adapter);

        MainActivity.adapter.notifyDataSetChanged();
    }
}
