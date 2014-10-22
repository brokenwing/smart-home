package smarthome;

import com.example.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * An activity representing a list of Items. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link ItemDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ItemListFragment} and the item details (if present) is a
 * {@link ItemDetailFragment}.
 * <p>
 * This activity also implements the required {@link ItemListFragment.Callbacks}
 * interface to listen for item selections.
 */
public class MainActivity extends Activity {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// TODO: If exposing deep links into your app, handle intents here.
	}

	public void ButtonClick_left(View v){
		
	}
	
	public void ButtonClick_right(View v){
		
	}
	
	public void ButtonClick_1_1(View v){
		
	}
	
	public void ButtonClick_1_2(View v){
		
	}
	
	public void ButtonClick_1_3(View v){
		
	}
	
	public void ButtonClick_2_1(View v){
		
	}
	
	public void ButtonClick_2_2(View v){
		
	}
	
	public void ButtonClick_2_3(View v){
		
	}
}
