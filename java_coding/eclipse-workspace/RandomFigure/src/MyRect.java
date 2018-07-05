import java.awt.Color;
import java.awt.Graphics;

public class MyRect {
	private int x1;
	private int y1;
	private int width;
	private int height;
	private Color myColor;
	
	public MyRect(int x1, int y1, int width, int height, Color color)
	{
		this.x1=x1;
		this.y1=y1;
		this.width=width;
		this.height=height;
		myColor=color;
	}
	public void draw(Graphics g)
	{
		g.setColor(myColor);
		g.drawRect(x1, y1, width, height);
	}
	public void erase(Graphics g)
	{
		g.setColor(Color.white);
		g.drawRect(x1,y1,width,height);
	}
	public int getx1()
	{
		return x1;
	}
	public int gety1()
	{
		return y1;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
}
