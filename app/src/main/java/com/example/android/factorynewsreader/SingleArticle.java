package com.example.android.factorynewsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * {@link SingleArticle} is an activity that opens when a user clicks on any list item.
 * It shows article which was clicked on in a web view.
 */
public class SingleArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_article);
        View loadingIndicatorIntent = findViewById(R.id.loading_indicator_intent);

        WebView webView = (WebView)findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        loadingIndicatorIntent.setVisibility(View.GONE);
        webView.loadUrl(FetchData.articles.get(MainActivity.articleNumber).getUrl().toString());


    }
}
