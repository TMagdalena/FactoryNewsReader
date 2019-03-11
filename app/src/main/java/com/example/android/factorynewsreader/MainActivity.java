package com.example.android.factorynewsreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity

    {
        public static ArticleAdapter adapter;
        public static ListView listView;
        public static View loadingIndicator;
        public static int articleNumber;


        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingIndicator = findViewById(R.id.loading_indicator);

        listView = (ListView) findViewById(R.id.list);

        FetchData fetchData = new FetchData();
        fetchData.execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                articleNumber = position;
                Intent intent = new Intent(NewsApp.getAppContext(), SingleArticle.class);
                startActivity(intent);
            }
        });
    }





}
