package smarthome;

import android.content.Context;

public class DisplayUtil {
	
	private static float scale = 0;
	private static float frontScale = 0;
	
	public static void reset(Context context){
		scale = context.getResources().getDisplayMetrics().density;
		frontScale = context.getResources().getDisplayMetrics().scaledDensity;
	}
	
	public static int dp2px(int v){
		return (int)(v*scale + 0.5f);
	}

	public static int sp2px(int v){
		return (int)(v*frontScale + 0.5f);
	}
}
