package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by lixin1 on 9/16/15.
 */
public abstract class Mood extends Object implements Moodable{
    private String text;
    protected Date date;

    public Mood(String mood, Date date) throws IOException{
        this.setText(mood);
        this.date = date;
    }

    public Mood(String mood) throws IOException{
        this.setText(mood);
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws IOException {
        if (text.length() <= 50) {
            this.text = text;
        } else {
            throw new IllegalArgumentException("Mood was too long!");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String checkMood();
}
