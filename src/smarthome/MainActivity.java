package smarthome;

import com.example.smarthome.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		LoadMainList();
	}

	public void ButtonClick_left(View v){
		LoadMainList();
	}
	
	public void ButtonClick_right(View v){
	}
	
	public void ButtonClick_main_1_1(View v){
		//erase layout
		LinearLayout layoutMain = (LinearLayout)findViewById(R.id.ContentLayout);
        layoutMain.removeAllViews();
        //show activity
		Intent in = new Intent(this,DeviceActivity.class);
		startActivity(in);
	}
	
	public void ButtonClick_main_1_2(View v){
		//erase layout
		LinearLayout layoutMain = (LinearLayout)findViewById(R.id.ContentLayout);
        layoutMain.removeAllViews();
        //show activity
		Intent in = new Intent(this,SceneActivity.class);
		startActivity(in);
	}
	
	public void ButtonClick_main_1_3(View v){
		
	}
	
	private void LoadMainList(){
		LayoutInflater inflater=getLayoutInflater();
        LinearLayout tmp = (LinearLayout) inflater.inflate(R.layout.main_list, null).findViewById(R.id.MainLayout);        
        LinearLayout layoutMain = (LinearLayout)findViewById(R.id.ContentLayout);
        layoutMain.removeAllViews();
        layoutMain.addView(tmp);
        
        TextView title = (TextView) findViewById(R.id.textViewCenter);
        title.setText(R.string.main_title);
	}
}
