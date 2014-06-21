package course.examples.UI.ListLayout;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
		//		getResources().getStringArray(R.array.colors)));
		
		//ArrayAdapter <String>adapter = new ArrayAdapter<String> (this, R.layout.list_item, getResources().getStringArray(R.array.colors));
		ArrayAdapter <String>adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.colors));
		ListView lv = getListView();
		//ListView lv = (ListView) findViewById(R.layout.list_item);
		//try {
			lv.setAdapter(adapter);
		//} catch (Throwable any) {
		//	Log.e("MYAPP", "exception" + Log.getStackTraceString(any));
		//	return;
		//}
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}