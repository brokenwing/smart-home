package smarthome;

import com.example.smarthome.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class SceneActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//set title
		TextView title = (TextView) findViewById(R.id.textViewCenter);
        title.setText(R.string.scene_title);
        //create layout
        LinearLayout layout = (LinearLayout)findViewById(R.id.ContentLayout);
        layout.removeAllViews();
		buildLayout(layout);
	}
	
	void buildLayout(LinearLayout layoutMain){
		DisplayUtil.reset(layoutMain.getContext());
		LinearLayout statebar = new LinearLayout(layoutMain.getContext());
		ImageButton bt_return = new ImageButton(layoutMain.getContext());
		/*
		 * state bar
		 */
		statebar.setOrientation(LinearLayout.HORIZONTAL);
		statebar.setPadding(DisplayUtil.dp2px(20), DisplayUtil.dp2px(5), DisplayUtil.dp2px(20), DisplayUtil.dp2px(5));
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
		
		statebar.addView(bt_return);
		
		layoutMain.addView(statebar);
		layoutMain.addView(buildList(layoutMain.getContext()));
	}
	
	/*
	 * build list
	 */
	ScrollView buildList(Context context){
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
			//button on the left with image
			ImageButton bt1 = new ImageButton(context);
			bt1.setBackgroundResource(R.drawable.ic_launcher);
			bt1.setLayoutParams(new LayoutParams(DisplayUtil.dp2px(50),DisplayUtil.dp2px(50)));
			//text
			TextView str = new TextView(context);
			str.setText("scene: "+i);
			str.setTextSize(DisplayUtil.sp2px(15));
			str.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1.0f));
			str.setGravity(Gravity.CENTER_HORIZONTAL);
			//button on the right
			Button bt2 = new Button(context);
			bt2.setText(R.string.scene_apply_button);
			//add element
			tmp.addView(bt1);
			tmp.addView(str);
			tmp.addView(bt2);
			box.addView(tmp);
		}
		return ret;
	}
	
	public void ButtonClick_left(View v){
		finish();
	}
}
