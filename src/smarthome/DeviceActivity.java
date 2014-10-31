package smarthome;

import com.example.smarthome.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeviceActivity extends Activity{
	
	private final static int WAIT_RESULT = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//set title
		TextView title = (TextView) findViewById(R.id.textViewCenter);
		title.setText(R.string.device_title);
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
		 * draw state bar
		 */
		statebar.setOrientation(LinearLayout.HORIZONTAL);
		statebar.setPadding(DisplayUtil.dp2px(20), DisplayUtil.dp2px(5), DisplayUtil.dp2px(20), DisplayUtil.dp2px(5));
		statebar.setBackgroundColor(0x50FFB000);
		/*
		 * draw return button
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
		/*
		 * draw list
		 */
		final ExpandableListAdapter adapter = new MyExpandableListAdapter(layoutMain.getContext());
		ExpandableListView floor = new ExpandableListView(layoutMain.getContext());
		floor.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		floor.setCacheColorHint(0x00000000);
		floor.setAdapter(adapter);
		//child click function
		floor.setOnChildClickListener(new OnChildClickListener(){
			public boolean onChildClick(ExpandableListView parent, View v,	int groupPosition, int childPosition, long id) {
				Intent intent = new Intent();  
	            intent.setClass(DeviceActivity.this, RoomActivity.class);  
	            Bundle bundle = new Bundle();
	            bundle.putString(StaticValue.title, (String)adapter.getGroup(groupPosition));
	            bundle.putInt(StaticValue.groupid, groupPosition);
	            bundle.putInt(StaticValue.childid, childPosition);
	            intent.putExtras(bundle);  
	            startActivityForResult(intent, WAIT_RESULT);  
				return true;
			}
		});
		//open the floor if there's only one
		if (floor.getCount() == 1) floor.expandGroup(0);
		/*
		 * add element
		 */
		layoutMain.addView(statebar);
		layoutMain.addView(floor);
	}
	
	@Override  
    protected void onActivityResult(int requestCode, int resultCode, Intent data)  
    {  
        if (requestCode == WAIT_RESULT){  
            if (resultCode == RoomActivity.RETURN_RESULT){  
                Bundle bundle = data.getExtras();  
                String str = bundle.getString(StaticValue.result);  
                if (str.equals(StaticValue.home)){
                	finish();
                }
            }  
        }  
    }  
	
	public void ButtonClick_left(View v){
		finish();
	}
}
