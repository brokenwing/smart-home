package Parser;

import java.io.InputStream;
import java.util.Iterator; 
import java.util.List; 
import java.util.Vector;

import org.dom4j.Document; 
import org.dom4j.DocumentException; 
import org.dom4j.Element; 
import org.dom4j.io.SAXReader; 

public class XMLParser { 
	public static Vector<Device> listdev;	
	public static Vector<Room> listroom;
	public static Vector<Sceen> listsceen;	
	public static Vector<Board> listboard;	
	public static Vector<Net> listnet;
	private static List nodes;

	public static void initiate(InputStream file) throws DocumentException { 
		SAXReader reader = new SAXReader();  
		Document  document = reader.read(file);
		Element rootElm = document.getRootElement();  
		
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
	            else if(element.getName()=="room")d.room = element.getStringValue();
	            else if(element.getName()=="posX")d.posX = element.getStringValue();
	            else if(element.getName()=="posY")d.posY = element.getStringValue();
	            else if(element.getName()=="fun")d.fun = element.getStringValue();
	            else if(element.getName()=="img")d.img = element.getStringValue();
	        }
			listdev.add(d);		
		}
		
		nodes = rootElm.elements("room");
		listroom = new Vector<Room>();	
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			Room d = new Room();
			for(Iterator i = elm.elementIterator();i.hasNext();){
	            Element element = (Element) i.next();
	            if(element.getName()=="roomid")d.roomid = element.getStringValue();
	            else if(element.getName()=="floor")d.floor = element.getStringValue();
	            else if(element.getName()=="img")d.img = element.getStringValue();
	            else if(element.getName()=="name")d.name = element.getStringValue();
	        }
			listroom.add(d);		
		}
		
		nodes = rootElm.elements("sceen");
		listsceen = new Vector<Sceen>();	
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			Sceen d = new Sceen();
			for(Iterator i = elm.elementIterator();i.hasNext();){
	            Element element = (Element) i.next();
	            if(element.getName()=="roomid")d.roomid = element.getStringValue();
	            else if(element.getName()=="sceenid")d.sceenid = element.getStringValue();
	            else if(element.getName()=="img")d.img = element.getStringValue();
	            else if(element.getName()=="name")d.name = element.getStringValue();
	        }
			listsceen.add(d);		
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
	}
}