import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	private Random randomNumbers=new Random();
	private MyLine[] lines;
	private MyRect[] rects;
	private MyCircle[] circles;
	
	private int choice;
	
	public DrawPanel(int choice)
	{
		this.choice=choice;
		setBackground(Color.white);
		if(choice==1) {
		
			lines=new MyLine[6+randomNumbers.nextInt(5)];
			
			for(int count=0;count<lines.length;count++)
			{
				int x1=randomNumbers.nextInt(500);
				int y1=randomNumbers.nextInt(500);
				int x2=randomNumbers.nextInt(500);
				int y2=randomNumbers.nextInt(500);
				
				//System.out.println(x1+" "+y1+" "+x2+" "+y2);
				Color color=new Color(randomNumbers.nextInt(256),
						randomNumbers.nextInt(256),randomNumbers.nextInt(256));
				
				lines[count]=new MyLine(x1, y1, x2, y2, color);
			}
		}
		else if(choice==2) {
			rects=new MyRect[6+randomNumbers.nextInt(5)];
			for(int count=0;count<rects.length;count++)
			{
				int x1=randomNumbers.nextInt(500);
				int y1=randomNumbers.nextInt(500);
				int width=randomNumbers.nextInt(100);
				int height=randomNumbers.nextInt(100);
				
				Color color=new Color(randomNumbers.nextInt(256),
						randomNumbers.nextInt(256),randomNumbers.nextInt(256));
				
				rects[count]=new MyRect(x1, y1, width, height, color);
			}
		}
		else if(choice==3) {
			circles=new MyCircle[6+randomNumbers.nextInt(5)];
			for(int count=0;count<circles.length;count++)
			{
				int x1=randomNumbers.nextInt(500);
				int y1=randomNumbers.nextInt(500);
				int diameter=randomNumbers.nextInt(100);
				
				Color color=new Color(randomNumbers.nextInt(256),
						randomNumbers.nextInt(256),randomNumbers.nextInt(256));
				
				circles[count]=new MyCircle(x1, y1, diameter, color);
			}
		}
	}
	public void erase(int value)
	{
		if(choice==1) {
			int a1=lines[value].getx1();
			int a2=lines[value].getx2();
			int b1=lines[value].gety1();
			int b2=lines[value].gety2();
			//System.out.println(a1+" "+b1+" "+a2+" "+b2);
			lines[value]=new MyLine(a1, b1, a2, b2, Color.white);
			
		}
		else if(choice==2) {
			int a1=rects[value].getx1();
			int a2=rects[value].getWidth();
			int b1=rects[value].gety1();
			int b2=rects[value].getHeight();
			//System.out.println(a1+" "+b1+" "+a2+" "+b2);
			rects[value]=new MyRect(a1, b1, a2, b2, Color.white);
		}
		else if(choice==3) {
			int a1=circles[value].getx1();
			int b1=circles[value].gety1();
			int dia=circles[value].getDia();
			//System.out.println(a1+" "+b1+" "+a2+" "+b2);
			circles[value]=new MyCircle(a1, b1, dia, Color.white);
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(choice==1)
		{	
			for(MyLine line:lines)
				line.draw(g);
		}
		else if(choice==2)
		{
			for(MyRect rect:rects)
				rect.draw(g);
		}
		else if(choice==3)
		{
			for(MyCircle circle:circles)
				circle.draw(g);
		}
	}
	
}
