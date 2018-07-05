
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintPanel extends JPanel
{
	private int pointCount = 0, pointCountErase = 0, pointCountRect = -1, pointCountOval = -1;
	private int toDraw;
	private Point[] points= new Point[10000], pointsErase = new Point[10000],
			startRect = new Point[1000], endRect = new Point[1000],
			startOval = new Point[1000], endOval = new Point[1000];
	
	public PaintPanel()
	{
		setBackground( Color.WHITE);
		MouseHandler handler = new MouseHandler();
		super.addMouseListener(handler);
		super.addMouseMotionListener(handler);
	}
	
	public void drawShape(ActionEvent event)
	{
		if(event.getActionCommand() == "Draw Rectangle") {
			toDraw = 1;
		}
		else if(event.getActionCommand() == "Draw Oval")
			toDraw = 2;
		else if(event.getActionCommand() == "Erase")
			toDraw = 3;
		else
			toDraw = 0;
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener
	{
		public void mouseClicked(MouseEvent event)
		{
		}
		
		public void mousePressed(MouseEvent event)
		{
			if(toDraw == 1)
			{
				pointCountRect++;
				startRect[pointCountRect] = event.getPoint();
				endRect[pointCountRect] = event.getPoint();
			}
			else if(toDraw == 2)
			{
				pointCountOval++;
				startOval[pointCountOval] = event.getPoint();
				endOval[pointCountOval] = event.getPoint();
			}
		}
		
		public void mouseReleased(MouseEvent event)
		{
			if(toDraw == 1) 
			{
				endRect[pointCountRect] = event.getPoint();
				repaint();
			}
			else if(toDraw == 2) 
			{
				endOval[pointCountOval] = event.getPoint();
				repaint();
			}
		}
		
		public void mouseEntered(MouseEvent event)
		{
		}
		
		public void mouseExited(MouseEvent event)
		{
		}
		
		public void mouseDragged(MouseEvent event)
		{
			if(toDraw == 1)
			{
				endRect[pointCountRect] = event.getPoint();
				repaint();
			}
			else if(toDraw == 2)
			{
				endOval[pointCountOval] = event.getPoint();
				repaint();
			}
			
			else if(toDraw == 3)
			{
				if(pointCountErase < pointsErase.length)
				{
					pointsErase[pointCountErase] = event.getPoint();
					pointCountErase++;
					repaint();
				}
			}
			else
			{
				if(pointCount < points.length)
				{
					points[pointCount] = event.getPoint();
					pointCount++;
					repaint();
				}
			}
		}
		
		public void mouseMoved(MouseEvent event)
		{
		}
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i = 0; i <= pointCountRect; i++) 
			g.drawRect(endRect[i].x - startRect[i].x > 0 ? startRect[i].x : endRect[i].x , 
					endRect[i].y - startRect[i].y > 0 ? startRect[i].y : endRect[i].y, 
					endRect[i].x - startRect[i].x > 0 ? endRect[i].x - startRect[i].x : startRect[i].x - endRect[i].x,
					endRect[i].y - startRect[i].y > 0 ? endRect[i].y - startRect[i].y : startRect[i].y - endRect[i].y);	
		for(int i = 0; i <= pointCountOval; i++)
			g.drawOval(endOval[i].x - startOval[i].x > 0 ? startOval[i].x : endOval[i].x , 
					endOval[i].y - startOval[i].y > 0 ? startOval[i].y : endOval[i].y, 
					endOval[i].x - startOval[i].x > 0 ? endOval[i].x - startOval[i].x : startOval[i].x - endOval[i].x,
					endOval[i].y - startOval[i].y > 0 ? endOval[i].y - startOval[i].y : startOval[i].y - endOval[i].y);	
		for(int i = 0; i < pointCount; i++)
			g.fillOval(points[i].x, points[i].y, 4, 4);
		for(int i = 0; i < pointCountErase; i++)
		{
			g.setColor(Color.WHITE);
			g.fillOval(pointsErase[i].x, pointsErase[i].y, 4, 4);
		}
	}
}
