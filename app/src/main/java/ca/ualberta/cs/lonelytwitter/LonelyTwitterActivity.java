package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";    // model
	private LonelyTwitterActivity activity = this;

	public Button getSaveButton() {
		return saveButton;
	}

	private Button saveButton;

	public EditText getBodyText() {
		return bodyText;
	}

	private EditText bodyText;    // view

	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();    // model

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	private ListView oldTweetsList;    // view
	private ArrayAdapter<Tweet> adapter;    // view

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {    // model

		super.onCreate(savedInstanceState);    // model
		setContentView(R.layout.main);    // view

		bodyText = (EditText) findViewById(R.id.body);    // view
		saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);    // view
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);    // view

		saveButton.setOnClickListener(new View.OnClickListener() {    // controller

			public void onClick(View v) {    // model
				setResult(RESULT_OK);    // controller
				String text = bodyText.getText().toString();    // view
				tweets.add(new NormalTweet(text));    // controller
				saveInFile();    // model
				adapter.notifyDataSetChanged();    // view

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {    // controller
				setResult(RESULT_OK);    // controller
				tweets.clear();    // controller
				saveInFile();    // model
				adapter.notifyDataSetChanged();    // view

			}
		});
		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(activity, EditTweetActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onStart() {    // model
		// TODO Auto-generated method stub
		super.onStart();    // model
		loadFromFile();    // model
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);    // model
		oldTweetsList.setAdapter(adapter);    // controller
		adapter.notifyDataSetChanged();    // view
	}

	private void loadFromFile() {    // model
		try {
			FileInputStream fis = openFileInput(FILENAME);    // model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));    // model
			Gson gson = new Gson();    // model
			// https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com
			Type arrayListType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();    // model
			tweets = gson.fromJson(in,arrayListType);    // model

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();    // model
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);    // controller
		}
	}
	
	private void saveInFile() {    // model
		try {
			FileOutputStream fos = openFileOutput(FILENAME,0);    // model
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));    // model
			Gson gson = new Gson();    // model
			gson.toJson(tweets, out);    // model
			out.flush();    // model
			fos.close();    // model
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);    // controller
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);    // controller
		}
	}

}