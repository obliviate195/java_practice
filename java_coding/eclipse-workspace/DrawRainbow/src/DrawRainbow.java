
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class DrawRainbow extends JPanel
{
	private final static Color VIOLET=new Color(128,0,128);
	private final static Color INDIGO=new Color(75,0,130);
	private BufferedImage bi=new BufferedImage(400,250,BufferedImage.TYPE_INT_RGB);
	Graphics2D gc=bi.createGraphics();
	private Color[] colors=
		{	Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
			Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};
	
	public DrawRainbow()
	{
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		
		gc.setColor(Color.WHITE);
		gc.fillRect(0, 0, 400, 250);
		int radius=20;
		
		int centerX=getWidth()/2;
		int centerY=getHeight()-10;
	
		for(int counter=colors.length;counter>0;counter--)
		{
			//g2d.setColor(colors[counter-1]);
			gc.setColor(colors[counter-1]);
			//g2d.fillArc(centerX-counter*radius, centerY-counter*radius, counter*radius*2,counter*radius*2,0,180);
			gc.fillArc(centerX-counter*radius, centerY-counter*radius, counter*radius*2,counter*radius*2,0,180);
		}
		g2d.drawImage(bi,0,0,this);
	}
	
	public void save() throws IOException
	{
		 File file1 = new File("pororo2.png");
	     ImageIO.write(bi, "png", file1);
	}
	
}
