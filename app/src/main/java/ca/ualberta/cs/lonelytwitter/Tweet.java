package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lixin1 on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;
    protected ArrayList<Mood> moodList = new ArrayList<Mood>();

    // Code --> Generate --> Constructor
    public Tweet(String tweet, Date date) throws IOException{
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws IOException{
        this.setText(tweet);
        this.date = new Date();
    }

    // Code --> Generate --> Getter and setter
    public String getText() {
        return text;
    }

    public void setText(String text) throws IOException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IllegalArgumentException("Tweet was too long!");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();
}
