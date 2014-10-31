package Parser;

import java.io.File; 
import java.io.InputStream;
import java.util.Iterator; 
import java.util.List; 
import java.util.Vector;

import org.dom4j.Document; 
import org.dom4j.DocumentException; 
import org.dom4j.Element; 
import org.dom4j.io.SAXReader; 
public class XMLParser { 
		
	public static Vector<Floor> listfloor;
	public static Vector<Device> listdev;	
	public static Vector<Room> listroom;	
	public static Vector<Sceen> listsceen;	
	public static Vector<Sceen> listpublicsceen;
	public static Vector<Board> listboard;	
	public static Vector<Net> listnet;	
	private static List nodes;
		
	public static void initiate(InputStream file) throws Exception { 
		SAXReader reader = new SAXReader();  
		Document  document = reader.read(file);  
		Element rootElm = document.getRootElement();  
		
		nodes = rootElm.elements("room");
		listfloor = new Vector<Floor>();
		listroom = new Vector<Room>();	
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			Room d = new Room();
			for(Iterator i = elm.elementIterator();i.hasNext();){
	            Element element = (Element) i.next();
	            if(element.getName()=="roomid")d.roomid = element.getStringValue();
	            else if(element.getName()=="floor")
	            {
	            	d.floor = element.getStringValue();
	            	boolean flag = false;
	            	for (Iterator iter = listfloor.iterator(); iter.hasNext();) {
	            		Floor floor = (Floor) iter.next();
	            		if(floor.floorid.equals(d.floor))
	            		{
	            			floor.listroom.add(d);
	            			flag = true;
	            			break;
	            		}
	            	}
	            	if(!flag)
	            	{
	            		Floor f = new Floor();
	            		f.floorid = d.floor;
	            		f.listroom.add(d);
	            		listfloor.add(f);
	            	}
	            }
	            else if(element.getName()=="img")d.img = element.getStringValue();
	            else if(element.getName()=="name")d.name = element.getStringValue();
	        }
			listroom.add(d);		
		}
		
		nodes = rootElm.elements("dev");
		listdev = new Vector<Device>();	                                                                                    
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			Device d = new Device();
			for(Iterator i = elm.elementIterator();i.hasNext();){
	            Element element = (Element) i.next();
	            if(element.getName()=="board")d.board = element.getStringValue();
	            else if(element.getName()=="devid")d.devid = element.getStringValue();
	            else if(element.getName()=="port")d.port = element.getStringValue();
	            else if(element.getName()=="name")d.name = element.getStringValue();
	            else if(element.getName()=="room")
	            {
	            	d.room = element.getStringValue();
	            	boolean flag = false;
	            	for (Iterator iter = listroom.iterator(); iter.hasNext();) {
	            		Room room = (Room) iter.next();
	            		if(room.roomid.equals(d.room))
	            		{
	            			room.listdevice.add(d);
	            			flag = true;
	            			break;
	            		}
	            	}
	            	if(!flag)
	            	{
	            		throw new Exception();
	            	}
	            }
	            else if(element.getName()=="posX")d.posX = element.getStringValue();
	            else if(element.getName()=="posY")d.posY = element.getStringValue();
	            else if(element.getName()=="fun")d.fun = element.getStringValue();
	            else if(element.getName()=="img")d.img = element.getStringValue();
	        }
			listdev.add(d);		
		}
		
		
		nodes = rootElm.elements("sceen");
		listsceen = new Vector<Sceen>();	
		listpublicsceen = new Vector<Sceen>();	
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			Sceen d = new Sceen();
			boolean ispublic = false;
			for(Iterator i = elm.elementIterator();i.hasNext();){
	            Element element = (Element) i.next();
	            if(element.getName()=="roomid")
	            {
	            	d.roomid = element.getStringValue();
	                boolean flag = false;
	                for (Iterator iter = listroom.iterator(); iter.hasNext();) {
	                	Room room = (Room) iter.next();
	                	if(room.roomid.equals(d.roomid))
	                	{
	                		room.listsceen.add(d);
	                		flag = true;
	                		break;
	                	}
	                }
	                if(!flag)
	                {
	                	if(d.roomid.equals("255"))ispublic = true;
	                	else throw new Exception();
	                }
	            }
	            else if(element.getName()=="sceenid")d.sceenid = element.getStringValue();
	            else if(element.getName()=="img")d.img = element.getStringValue();
	            else if(element.getName()=="name")d.name = element.getStringValue();
	        }
			listsceen.add(d);
			if(ispublic)listpublicsceen.add(d);
		}
		
		nodes = rootElm.elements("board");
		listboard = new Vector<Board>();	
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			Board d = new Board();
			for(Iterator i = elm.elementIterator();i.hasNext();){
	            Element element = (Element) i.next();
	            if(element.getName()=="boardid")d.boardid = element.getStringValue();
	            else if(element.getName()=="netid")d.netid = element.getStringValue();
	            else if(element.getName()=="addr")d.addr = element.getStringValue();
	            else if(element.getName()=="fun")d.fun = element.getStringValue();
	        }
			listboard.add(d);		
		}
		
		nodes = rootElm.elements("net");
		listnet = new Vector<Net>();	
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			Net d = new Net();
			for(Iterator i = elm.elementIterator();i.hasNext();){
	            Element element = (Element) i.next();
	            if(element.getName()=="netid")d.netid = element.getStringValue();
	            else if(element.getName()=="addr")d.addr = element.getStringValue();
	        }
			listnet.add(d);		
		}
		
		
		//   for test
		
		/*for (Iterator iter = listfloor.iterator(); iter.hasNext();) {
			Floor floor = (Floor) iter.next();
			System.out.print("floor: ");
			System.out.println(floor.floorid);
			for (Iterator iter2 = floor.listroom.iterator(); iter2.hasNext();) {
	    		Room room = (Room) iter2.next();
	    		System.out.print("room: ");
	    		System.out.println(room.name);
	    		for (Iterator iter3 = room.listdevice.iterator(); iter3.hasNext();) {
	        		Device device = (Device) iter3.next();
	        		System.out.print("device: ");
	        		System.out.println(device.name);
	        	}
	    		for (Iterator iter4 = room.listsceen.iterator(); iter4.hasNext();) {
	    			Sceen sceen = (Sceen) iter4.next();
	        		System.out.print("sceen: ");
	        		System.out.println(sceen.name);
	        	}
	    	}
			
		}*/
	}
}