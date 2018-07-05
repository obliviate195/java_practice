import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;


import javax.imageio.*;
import java.awt.image.*;

public class BITest{
	static public void main(String[] args) {
		System.out.println("hello, world!");
		JFrame application=new JFrame();
		MyPanel mypanel = new MyPanel();
		application.add(mypanel);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400,200);
		application.setVisible(true);
	}
}
class MyPanel extends JPanel{
	private BufferedImage bi;
	private Graphics2D g2d,gc;
	private int pointCount=0;
	private Point[] points=new Point[1000];
	
	public MyPanel() {
		setBackground( Color.WHITE);
		MouseHandler handler = new MouseHandler();
		super.addMouseListener(handler);
		super.addMouseMotionListener(handler);
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener
	{
		public void mouseClicked(MouseEvent event)
		{
		}
		
		public void mousePressed(MouseEvent event)
		{
			
		}
		
		public void mouseReleased(MouseEvent event)
		{
			
		}
		
		public void mouseEntered(MouseEvent event)
		{
		}
		
		public void mouseExited(MouseEvent event)
		{
		}
		
		public void mouseDragged(MouseEvent event)
		{
			points[pointCount]=event.getPoint();
			pointCount++;
			repaint();
		}
		
		public void mouseMoved(MouseEvent event)
		{
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2d=(Graphics2D)g;
		/*for(int i=0;i<pointCount;i++)
		{
			g.fillOval(points[i].x, points[i].y,4, 4);
		}*/
		
		//gc=bi.createGraphics();
		if(bi==null) {
            int w = this.getWidth();
            int h = this.getHeight();
            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            gc = bi.createGraphics();
            
            //for (int x=0; x<w; x+=10) {gc.drawLine(x, 0, x, h);}
            //for (int y=0; y<h; y+=10) {gc.drawLine(0, y, w, y);}
		}
		for(int i=0;i<pointCount;i++)
		{
			gc.fillOval(points[i].x, points[i].y,4, 4);
		}
		g2d.drawImage(bi,0,0,this);
	}
}

