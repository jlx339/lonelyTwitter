package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;


/**
 * Created by lixin1 on 9/30/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super (LonelyTwitterActivity.class);
    };

    public void testRemoveTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("lololololol");
        tweetList.addTweet(tweet);
        tweetList.removeTweet(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList tweetList= new TweetList();
        Tweet tweet = new NormalTweet("lololololol");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testAddTweet(){
        TweetList tweetList= new TweetList();
        Tweet tweet = new NormalTweet("lololololol");
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweetList= new TweetList();
        Tweet tweet = new NormalTweet("lololololol");
        tweetList.addTweet(tweet);
        Tweet returnedTweet = tweetList.getTweet(0);
        assertEquals((tweet.date.equals(returnedTweet.date)),
                (tweet.getText().equals(returnedTweet.getText())));
    }

    public void testDuplicateTweet(){
        TweetList tweetList = new TweetList ();
        Tweet tweet = new NormalTweet("lololololol");
        tweetList.addTweet(tweet);
        Boolean isDuplicate = false;
        try {
            tweetList.addTweet(tweet);
        } catch (IllegalArgumentException e) {
            isDuplicate = true;
        }

        if (isDuplicate == false) {
            assertFalse(true);
        }
    }

    public void testGetTweets(){
        TweetList tweetList = new TweetList ();
        Tweet tweet1 = new NormalTweet("lololololol");
        tweetList.addTweet(tweet1);
        Tweet tweet2 = new NormalTweet("lololololol222");
        tweetList.addTweet(tweet2);
        assertTrue(tweetList.getTweet(0).equals(tweet1));
    }

    public void getCount(){
        TweetList tweetList = new TweetList ();
        Tweet tweet1 = new NormalTweet("lololololol");
        tweetList.addTweet(tweet1);
        Tweet tweet2 = new NormalTweet("lololololol222");
        tweetList.addTweet(tweet2);

        assertTrue(tweetList.getCount() == (2));
    }
}