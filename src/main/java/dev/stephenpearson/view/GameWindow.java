package dev.stephenpearson.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import dev.stephenpearson.model.GameZone;
import dev.stephenpearson.model.RenderObject;


public class GameWindow extends JPanel{
	
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 800;
	
	private static List<RenderObject> renderObjects = new ArrayList<>();

	
	public GameWindow() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}
	
	public void render() {
		repaint();
	}
	
	public void addRenderObject(RenderObject r) {
		if(!renderObjects.contains(r)) {
			renderObjects.add(r);
		}
	}
	
	public void passRenderObjects(List<RenderObject> r) {

		for(RenderObject renderObjectToAdd : r) {
			if(!renderObjects.contains(renderObjectToAdd)) {
				renderObjects.add(renderObjectToAdd);
			}
		}
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(78, 115, 96));
		//Graphics2D g2d = (Graphics2D) g;
		
		//Color[] colors = {new Color(78, 115, 96), new Color(36, 41, 39)};
		//Point2D point = new Point2D.Float(300,400);
		//float[] dist = {0.0f, 0.2f, 1.0f};
		//RadialGradientPaint rgp1 = new RadialGradientPaint(point,0.5f * 300,dist,colors);
		//GradientPaint gp1 = new GradientPaint(0, 0, new Color(78, 115, 96), 600, 800, new Color(36, 41, 39));  
		 //g2d.setPaint(gp1);  
		//g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
		
		//card color
//		g.setColor(new Color(233, 237, 245));
		
		
		//drop shadow color
//		g.setColor(new Color(34, 35, 36));
		for(RenderObject r : renderObjects) {
			
			
			//turn off printing gamezones
//			if(r.getClass() != GameZone.class) {
//				r.draw(g); 
//			}
			
			r.draw(g); 
		}
	}

	

}
