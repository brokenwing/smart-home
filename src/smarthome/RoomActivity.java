package smarthome;

import com.example.smarthome.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

public class RoomActivity extends Activity {
	
	public final static int RETURN_RESULT = 1;
	
	private String title = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//get title
		Intent intent = getIntent();  
        Bundle bundle = intent.getExtras();  
        title = bundle.getString(StaticValue.data); 
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		//set title
		TextView text = (TextView) findViewById(R.id.textViewCenter);
        text.setText(R.string.device_title);
        //create layout
		buildLayout((LinearLayout)findViewById(R.id.ContentLayout));
	}
	
	void buildLayout(LinearLayout layoutMain){
		DisplayUtil.reset(layoutMain.getContext());
		LinearLayout statebar = new LinearLayout(layoutMain.getContext());
		ImageButton bt_return = new ImageButton(layoutMain.getContext());
		/*
		 * state bar
		 */
		statebar.setOrientation(LinearLayout.HORIZONTAL);
		statebar.setPadding(DisplayUtil.dp2px(20), DisplayUtil.dp2px(5), DisplayUtil.dp2px(50), DisplayUtil.dp2px(5));
		statebar.setBackgroundColor(0x50FFB000);
		/*
		 * return button
		 */
		bt_return.setBackgroundResource(R.drawable.left_arrow);
		bt_return.setLayoutParams(new LayoutParams(DisplayUtil.dp2px(30),DisplayUtil.dp2px(30)));
		bt_return.setOnClickListener(
				new OnClickListener(){
					public void onClick(View v){
						finish();
					}
				}
		 );
		//text
		TextView str = new TextView(layoutMain.getContext());
		str.setText(title);
		str.setTextSize(DisplayUtil.sp2px(10));
		str.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f));
		str.setGravity(Gravity.CENTER_HORIZONTAL);
		
		statebar.addView(bt_return);
		statebar.addView(str);
		
		layoutMain.addView(statebar);
		layoutMain.addView(buildList(layoutMain.getContext()));
	}
	
	View buildList(Context context){
		//scroll view
		ScrollView ret = new ScrollView(context);
		ret.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		//layout->scroll view
		LinearLayout box = new LinearLayout(context);
		box.setOrientation(LinearLayout.VERTICAL);
		box.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		ret.addView(box);
		/*
		 * add item
		 */
		for (int i=0; i<15; i++){
			//layout
			LinearLayout tmp = new LinearLayout(context);
			tmp.setOrientation(LinearLayout.HORIZONTAL);
			tmp.setPadding(DisplayUtil.dp2px(10), 0, DisplayUtil.dp2px(10), 0);
			tmp.setGravity(Gravity.CENTER_HORIZONTAL);
			//text
			TextView str = new TextView(context);
			str.setText("device: "+i);
			str.setTextSize(DisplayUtil.sp2px(15));
			str.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			str.setGravity(Gravity.CENTER_HORIZONTAL);
			//button
			Button bt = new Button(context);
			bt.setText("On");
			//seekbar
			SeekBar sb = new SeekBar(context);
			sb.setMax(100);
			sb.setProgress(50);
			sb.setLayoutParams(new LinearLayout.LayoutParams(DisplayUtil.dp2px(100), LayoutParams.WRAP_CONTENT));
			
			//add element
			tmp.addView(str);
			tmp.addView(bt);
			tmp.addView(sb);
			box.addView(tmp);
		}
		return ret;
	}
	
	public void ButtonClick_left(View v){
		Intent intent=new Intent();  
        intent.putExtra(StaticValue.result, StaticValue.home);  
        setResult(RETURN_RESULT, intent);  
		finish();
	}
}
