import java.awt.Color;
import java.awt.Graphics;

public class MyCircle {
	private int x1;
	private int y1;
	private int diameter;
	private Color myColor;
	
	public MyCircle(int x1, int y1, int diameter, Color color)
	{
		this.x1=x1;
		this.y1=y1;
		this.diameter=diameter;
		myColor=color;
	}
	public void draw(Graphics g)
	{
		g.setColor(myColor);
		g.drawOval(x1, y1, diameter, diameter);
	}
	public int getx1()
	{
		return x1;
	}
	public int gety1()
	{
		return y1;
	}
	public int getDia()
	{
		return diameter;
	}
}
