package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by lixin1 on 9/30/15.
 */
public class TweetList implements  MyObserverable{
    private ArrayList<MyObserver> myObservers = new ArrayList<MyObserver>();
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet){
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException("");
        } else {
            tweets.add(tweet);
        }

        notifyOberservers();
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public ArrayList getTweets(){
        return tweets;
    }

    public int getCount(){
        return tweets.size();
    }



    public void addObserver(MyObserver observer) {
        myObservers.add(observer);
    }

    public void notifyOberservers(){
        for (MyObserver observer : myObservers){
            observer.myNotify();
        }
    }
}
