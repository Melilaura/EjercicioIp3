import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import processing.core.PApplet;

public class Main extends PApplet{


	
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	private String compIP, phone1IP, phone2IP, phone3IP;
	private boolean phone1Connect, phone2Connect, phone3Connect;
	private int d1, d2, d3;
	private InetAddress inetAddress1, inetAddress2, inetAddress3, inetAddress4;
		
	
	@Override
	public void settings() {
		size(500, 500);
		
	}
	
	@Override
	public void setup() {
		//Small circle radius
		d1 = 80;
		d2 = 80;
		d3 = 80;
		
		try {
			//host ip
			inetAddress1 = InetAddress.getLocalHost();
			compIP = inetAddress1.getHostAddress();
			
			//Phone 1
			inetAddress2 = InetAddress.getByName("192.168.1.54");
			phone1Connect = inetAddress2.isReachable(2000);
			
			//Phone 2
			inetAddress3 = InetAddress.getByName("192.168.1.1");
			phone2Connect = inetAddress3.isReachable(2000);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Naming IP
		if (phone1Connect) {
			phone1IP = inetAddress2.getHostName();
		} else {
			phone1IP = "Sin conexión3";
		}
		
		if (phone2Connect) {
			phone2IP = inetAddress3.getHostName();
		} else {
			phone2IP = "Sin conexión";
		}
		
	}
	
	@Override
	public void draw() {
		background(255);
		noStroke();
		
		//Circle with computer IP
		fill(64, 63, 63);
		circle(250, 250, 180);
		fill(255);
		textAlign(CENTER);
		textSize(18);
		text(compIP, 250, 255);
		
		//Other circles
		fill(111, 220, 227);
		circle(250, 70, d1);
		fill(230, 56, 127);
		circle(100, 410, d2);
		fill(155, 213, 65);
		circle(400, 410, d3);
		
		//Hover
			//Circle 1
			if (dist(mouseX, mouseY, 250, 70) < d1/2) {
				d1 = 120;
				fill(255);
				textSize(14);
				text(phone1IP, 250, 75);
			} else {
				d1 = 80;
			}
			
			//Circle 2
			if (dist(mouseX, mouseY, 100, 410) < d2/2) {
				d2 = 120;
				fill(255);
				textSize(14);
				text(phone2IP, 100, 415);
			} else {
				d2 = 80;
			}
			
			//Circle 3
			if (dist(mouseX, mouseY, 400, 410) < d3/2) {
				d3 = 120;
			} else {
				d3 = 80;
			}
		
	}
}
