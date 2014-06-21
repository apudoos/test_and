package com.sam.biblequiz;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BibleQuizActivity extends Activity {
	
	private Button mYes;
	private Button mNo;
	private Button mNext;
	private TextView textview;
	private QuizProcessor [] quizprocessor;
	private int quiznumber = 0;

	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bible_quiz);
		
		quizprocessor = new QuizProcessor[] {
			new QuizProcessor(R.string.q1, R.string.a1),
			new QuizProcessor(R.string.q2, R.string.a2),
			new QuizProcessor(R.string.q3, R.string.a3),
			new QuizProcessor(R.string.q4, R.string.a4),
			new QuizProcessor(R.string.q5, R.string.a5)
		};

		
		mYes = (Button) findViewById(R.id.button1);
		mNo = (Button) findViewById(R.id.button2);
		mNext = (Button) findViewById(R.id.button3);
		textview = (TextView) findViewById(R.id.textView1);

		updateQuestion();
		
		mYes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				checkAnswer(mYes, mNo);
			}

		});
		
		mNo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				checkAnswer(mNo, mYes);
			}
		});
		
		mNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				quiznumber = (quiznumber + 1) % quizprocessor.length;
				updateQuestion();
				mNo.setEnabled(true);
				mYes.setEnabled(true);
			}
		});
		
		
	}

	private void updateQuestion() {
		int question = quizprocessor[quiznumber].getmQuestion();
		textview.setText(question);		
	}
	
	private void checkAnswer(Button a, Button b) {
		Log.i(getApplicationContext().toString(), "a.getText().toString()" + a.getText().toString());
		Log.i(getApplicationContext().toString(), "getString(quizprocessor[quiznumber].getmAnswer())" + getString(quizprocessor[quiznumber].getmAnswer()));
		if(a.getText().toString() == getString(quizprocessor[quiznumber].getmAnswer())) {
			Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
		}
		
		a.setEnabled(false);
		b.setEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bible_quiz, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_bible_quiz,
					container, false);
			return rootView;
		}
	}

}
