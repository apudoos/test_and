package course.examples.UI.Button;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Usefulaction implements OnClickListener {
	/**
	 * 
	 */
	//private final ButtonActivity buttonActivity;
	private final Button button;
	int count = 0; 

	public Usefulaction(Button button) {
		//this.buttonActivity = buttonActivity;
		this.button = button;
	}

	@Override
	public void onClick(View v) {
		button.setText("Got Pressed:" + ++count);
		}
}