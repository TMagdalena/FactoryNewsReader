package com.example.android.factorynewsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String REQUEST_URL = "https://newsapi.org/v1/articles?apiKey=6946d0c07a1c4555a4186bfcade76398&sortBy=top&source=bbc-news";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Article> articles = Parser.extractArticles();
        ArticleAdapter adapter = new ArticleAdapter(this, articles);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }




}
