package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by lixin1 on 9/16/15.
 */
public class SadMood extends Mood {
    public SadMood(String mood, Date date) throws IOException {
        super(mood, date);
    }

    public SadMood(String mood) throws IOException {
        super(mood);
    }

    public String checkMood(){
        return ": <";
    }
}
