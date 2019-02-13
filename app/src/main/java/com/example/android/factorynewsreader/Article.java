package com.example.android.factorynewsreader;

/**
 * {@link Article} represents a news article
 * It contains author, title, description, url, image and when was article published
 */

public class Article {

    /** Author of the article */
    private String author;

    /** Title of the article */
    private String title;

    /** Description of the article */
    private String description;

    /** URL of the article */
    private String url;

    /** Image URL of the article */
    private String imageURL;

    /** Time when the article was published */
    private String timeOfPublishing;

    /**
     * Public constructor
     */
    public Article(String authorOfArticle, String titleOfArticle, String descriptionOfArticle, String urlOfArticle, String imageOfArticle, String timeOfArticle) {
        author = authorOfArticle;
        title = titleOfArticle;
        description = descriptionOfArticle;
        url = urlOfArticle;
        imageURL = imageOfArticle;
        timeOfPublishing = timeOfArticle;
    }

    /**
     * Get methods for author, title, description, URL, image URL and time of publishing
     */

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTimeOfPublishing() {
        return timeOfPublishing;
    }

}
