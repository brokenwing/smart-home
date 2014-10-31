package Parser;

import java.util.Vector;

public class Room{
	public String roomid;
	public String floor;
	public String name;
	public String img;
	public Vector<Device> listdevice;
	public Vector<Sceen> listsceen;
	public Room()
	{
		listdevice = new Vector<Device>();
		listsceen = new Vector<Sceen>();
	}
}