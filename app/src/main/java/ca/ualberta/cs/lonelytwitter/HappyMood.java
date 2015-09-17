package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by lixin1 on 9/16/15.
 */
public class HappyMood extends Mood {
    public HappyMood(String mood, Date date) throws IOException {
        super(mood, date);
    }

    public HappyMood(String mood) throws IOException {
        super(mood);
    }

    public String checkMood(){
        return ": )";
    }
}
