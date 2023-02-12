package dev.stephenpearson.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class GameZone implements RenderObject {
	
	private Zone zone;
	private Rectangle zoneRect;
	private Color zoneColor;
	private Point zoneCenterPoint;
	
	private String zoneName;

	public GameZone(String zoneName) {
		
		this.zoneName = zoneName;
		zone = Zone.getZone(zoneName);
		
		zoneRect = new Rectangle(zone.x, zone.y, zone.w, zone.h);
		zoneColor = zone.color;
		zoneCenterPoint = new Point(zoneRect.x + zoneRect.width / 2, zoneRect.y + zoneRect.height / 2);
		//System.out.println(String.format("Zone %s", zoneName) + " " +  zoneCenterPoint.getLocation().toString());
		
	}
	
	public Rectangle getZoneRectangle() {
		return zoneRect;
	}
	
	public Color getZoneColor() {
		return zoneColor;
	}
	
	public void draw(Graphics g) {
		
		g.setColor(zoneColor);
		g.fillRect(zoneRect.x, zoneRect.y, zoneRect.width, zoneRect.height);
		g.setColor(Color.BLACK);
		g.drawString(zoneName, zoneRect.x + zoneRect.width /2, zoneRect.y + zoneRect.height /2);
	}
	
	public String getZoneName() {
		return zoneName;
	}
	
	public Zone getZone() {
		return zone;
	}
	
	public Point getZoneCenterPoint() {
		return zoneCenterPoint;
	}
	
	enum Zone {
		
		DEALER_HAND("dealerHandZone",0,0,600,200, new Color(86, 111, 119)),
		PLAYER_HAND("playerHandZone",0,600,600,200, new Color(238, 138, 118)),
		DECK("deckZone",600,0,200,200, new Color(225, 129, 73)),
		BURNT_CARDS("burntCards",600,200,200,200, new Color(172, 218, 106)),
		BET_STACK("betStack",600,400,200,200, new Color(223, 223, 133)),
		CHIP_STACK("chipStack",600,600,200,200, new Color(140, 186, 181)),
		GAME_ZONE("gameZone",0,200,600,400,new Color(153, 153, 255));
		
		private String zoneName;
		private int x, y, w, h;
		private Color color;
		
		
		
		private Zone(String zoneName, int x, int y, int w, int h, Color color) {
			this.zoneName = zoneName;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
			
		}
		
		public String getZoneName() {
			return zoneName;
		}
		
		
		
		public static Zone getZone(String zoneName) {
		      for (Zone z : Zone.values()) {
		          if (z.zoneName.equalsIgnoreCase(zoneName)) return z;
		      }
		      throw new IllegalArgumentException("Zone not found");
		   }
		
		
		
		
		
	}

}
