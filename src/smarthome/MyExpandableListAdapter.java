package smarthome;

import java.util.Iterator;
import java.util.Vector;
import com.example.smarthome.R;

import Parser.Floor;
import Parser.Room;
import Parser.XMLParser;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class MyExpandableListAdapter extends BaseExpandableListAdapter {
	
	private Context context;
	//floor number
	private Vector<String> groupName = new Vector<String>();
	//room in each floor
	private Vector<Vector<String>> itemName = new Vector<Vector<String>>();

	MyExpandableListAdapter(Context c){
		context = c;
		/*
		 * set original list string
		 */
		for (Iterator<Floor> i = XMLParser.listfloor.iterator(); i.hasNext(); ){
			Floor flr = i.next();
			groupName.add("Floor: "+flr.floorid);
			Vector<String> vet = new Vector<String>();
			for (Iterator<Room> j = flr.listroom.iterator(); j.hasNext(); ){
				Room rm = j.next();
				vet.add(rm.name);
			}
			itemName.add(vet);
		}
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		//layout
		LinearLayout ret = new LinearLayout(context);
		ret.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		ret.setOrientation(LinearLayout.HORIZONTAL);
		ret.setGravity(Gravity.CENTER);
		//text
		TextView text = new TextView(context);
		text.setText(itemName.get(groupPosition).get(childPosition));
		text.setTextSize(DisplayUtil.sp2px(10));
		//image
		ImageView img = new ImageView(context);
		img.setBackgroundResource(R.drawable.ic_launcher);
		
		ret.addView(img);
		ret.addView(text);
		return ret;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,	View convertView, ViewGroup parent) {
		//layout
		LinearLayout ret = new LinearLayout(context);
		ret.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		ret.setPadding(DisplayUtil.dp2px(20), DisplayUtil.dp2px(5), DisplayUtil.dp2px(20), DisplayUtil.dp2px(5));
		ret.setOrientation(LinearLayout.HORIZONTAL);
		ret.setGravity(Gravity.CENTER);
		//text
		TextView text = new TextView(context);
		text.setText(groupName.get(groupPosition));
		text.setTextSize(DisplayUtil.sp2px(10));
			
		ret.addView(text);
		return ret;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return itemName.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return itemName.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupName.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return groupName.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
