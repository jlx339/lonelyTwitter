package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by lixin1 on 10/7/15.
 */
public interface MyObserverable {
    void addObserver(MyObserver o);
    void notifyOberservers();

}
