package smarthome;

import com.example.smarthome.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LoadMainList();
	}

	public void ButtonClick_left(View v){
		LoadMainList();
	}
	
	public void ButtonClick_right(View v){
	}
	
	public void ButtonClick_return(View v){
		LoadMainList();
	}
	
	public void ButtonClick_main_1_1(View v){
		LoadDevice();
	}
	
	public void ButtonClick_main_1_2(View v){
		LoadScene();
	}
	
	public void ButtonClick_main_1_3(View v){
		
	}
	
	public void ButtonClick_main_2_1(View v){
		
	}
	
	public void ButtonClick_main_2_2(View v){
		
	}
	
	public void ButtonClick_main_2_3(View v){
		
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
	
	private void LoadScene(){
		LayoutInflater inflater=getLayoutInflater();
        LinearLayout tmp = (LinearLayout) inflater.inflate(R.layout.scene, null).findViewById(R.id.SceneLayout);        
        LinearLayout layoutMain = (LinearLayout)findViewById(R.id.ContentLayout);
        layoutMain.removeAllViews();
        layoutMain.addView(tmp);
        
        TextView title = (TextView) findViewById(R.id.textViewCenter);
        title.setText(R.string.scene_title);
	}
	
	private void LoadDevice(){
		LayoutInflater inflater=getLayoutInflater();
        LinearLayout tmp = (LinearLayout) inflater.inflate(R.layout.device, null).findViewById(R.id.DeviceLayout);        
        LinearLayout layoutMain = (LinearLayout)findViewById(R.id.ContentLayout);
        layoutMain.removeAllViews();
        layoutMain.addView(tmp);
        
        TextView title = (TextView) findViewById(R.id.textViewCenter);
        title.setText(R.string.device_title);
	}
}
