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

    private static final String JSON_RESPONSE = "{\"status\":\"ok\",\"source\":\"bbc-news\",\"sortBy\":\"top\",\"articles\":[{\"author\":\"BBC News\",\"title\":\"Madrid mass protest over Catalonia talks\",\"description\":\"Spain's right-wing opposition says the Socialist government is giving in to separatist pressure.\",\"url\":\"http://www.bbc.co.uk/news/world-europe-47190135\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/C935/production/_105590515_052223842-1.jpg\",\"publishedAt\":\"2019-02-10T11:34:07Z\"},{\"author\":\"BBC News\",\"title\":\"May to ask MPs for more time on Brexit\",\"description\":\"The PM is expected to promise MPs another vote if she has not secured a revised deal this month.\",\"url\":\"http://www.bbc.co.uk/news/uk-47187491\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/15D90/production/_105588498_4a7ae514-9955-4a7d-b5ae-ba6d36ded0c8.jpg\",\"publishedAt\":\"2019-02-10T08:26:58Z\"},{\"author\":\"BBC News\",\"title\":\"Shut detention camps, Turkey tells China\",\"description\":\"The statement follows the reported death in a camp of a prominent musician from the Uighur minority.\",\"url\":\"http://www.bbc.co.uk/news/world-asia-47187170\",\"urlToImage\":\"https://ichef.bbci.co.uk/images/ic/1024x576/p05wv9gj.jpg\",\"publishedAt\":\"2019-02-09T23:34:25Z\"},{\"author\":\"BBC News\",\"title\":\"'I went vegan to hide my eating disorder'\",\"description\":\"Veganism is definitely having a moment, and for Rebecca Hills, 20, it was a way of hiding in plain sight.\",\"url\":\"http://www.bbc.co.uk/news/stories-47176759\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/06FB/production/_105578710_p070cns1.jpg\",\"publishedAt\":\"2019-02-10T00:13:19Z\"},{\"author\":\"BBC News\",\"title\":\"In pictures: Heavy snow hits Seattle\",\"description\":\"Residents, more used to rain, joke that the city in the US Pacific Northwest faces #Snowmageddon.\",\"url\":\"http://www.bbc.co.uk/news/world-us-canada-47189161\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/DCBD/production/_105590565_gettyimages-1096704822.jpg\",\"publishedAt\":\"2019-02-10T13:01:51Z\"},{\"author\":\"BBC News\",\"title\":\"'Hitler paintings' fail to sell at auction\",\"description\":\"The auction goes ahead after prosecutors seize dozens of paintings over accusations of forgery.\",\"url\":\"http://www.bbc.co.uk/news/world-europe-47189155\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/112FE/production/_105589307_052170283.jpg\",\"publishedAt\":\"2019-02-10T11:02:57Z\"},{\"author\":\"BBC News\",\"title\":\"Was Ruskin the most important man of the last 200 years?\",\"description\":\"In the bicentenary of his birth, it’s time we looked again at the forward-thinking and influential ideas of the great Victorian, writes Daisy Dunn.\",\"url\":\"http://www.bbc.com/culture/story/20190207-was-ruskin-the-most-important-man-of-the-last-200-years\",\"urlToImage\":\"http://ichef.bbci.co.uk/wwfeatures/live/624_351/images/live/p0/70/81/p07081gb.jpg\",\"publishedAt\":null},{\"author\":\"BBC News\",\"title\":\"Thousands flee New Zealand wildfire\",\"description\":\"Thousands of people are evacuated as the blaze rages near Nelson in the country's South Island.\",\"url\":\"http://www.bbc.co.uk/news/world-asia-47187604\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/11AC4/production/_105588327_mediaitem105588326.jpg\",\"publishedAt\":\"2019-02-10T04:00:54Z\"},{\"author\":\"BBC News\",\"title\":\"IS resists 'final push' in eastern Syria\",\"description\":\"US-backed guerrillas target what they say is the last pocket of IS resistance near the Iraqi border.\",\"url\":\"http://www.bbc.co.uk/news/world-middle-east-47188355\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/132FC/production/_105588587_mediaitem105588585.jpg\",\"publishedAt\":\"2019-02-10T05:00:24Z\"},{\"author\":\"BBC News\",\"title\":\"Venezuela's Guaido vows to open aid routes\",\"description\":\"The opposition leader says he will \\\"do everything possible\\\", and calls for distribution volunteers.\",\"url\":\"http://www.bbc.co.uk/news/world-latin-america-47184755\",\"urlToImage\":\"https://ichef.bbci.co.uk/news/1024/branded_news/554E/production/_105583812_guaido.jpg\",\"publishedAt\":\"2019-02-10T09:00:44Z\"}]}";
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
    public static ArrayList<Article> extractArticles() {

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
            Log.e(TAG, "Problem parsing");
        }

        return articles;

    }

}
