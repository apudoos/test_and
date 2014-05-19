package course.examples.UI.Button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ButtonActivity extends Activity {
	int count = 0; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button button = (Button) findViewById(R.id.button);
        Usefulaction a = new Usefulaction(button);
        
        button.setOnClickListener(a);
        
        /*button.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		button.setText("Got Pressed:" + ++count);
        	}
        	
        });*/
    }
}