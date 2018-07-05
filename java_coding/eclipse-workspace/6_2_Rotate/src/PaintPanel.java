
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.ImageIO;


public class PaintPanel extends JPanel
{
	private int pointCount = 0, howManyEraser = 0, howManyPen = 0, n = 0;
	private int toDraw = 0, thickness = 4, mode = 0, stack = 0, maxstack = 0;
	private int[] whichOpLast = new int[10000], eraserThickness = new int[10000], penThickness = new int[10000];
	private int[] shape = new int[10000];
	private Point[] startPt = new Point[10000], endPt = new Point[10000];
	private int[][][] erasePt = new int[100][10000][2], penPt = new int[100][10000][2];
	private int[] eraseCount = new int[10000], penCount = new int[10000];
	private Point startChange, endChange;
	private BufferedImage bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
	private Graphics2D g2d = bi.createGraphics();
	private Color color = Color.black;
	private Color[] colors = new Color[10000];

	public PaintPanel()
	{
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();
		super.addMouseListener(handler);
		super.addMouseMotionListener(handler);
	}
	public void setColor(Color color)
	{
		System.out.println(pointCount);
		this.color = color;
	}
	public void drawShape(int shape, int thickness)
	{
		this.toDraw = shape;
		this.thickness = thickness;
	}
	public void undo()
	{
		if (stack == 0) {}
		else
		{
			stack--;
			if (whichOpLast[stack] == 0)
			{
				pointCount--;
				n--;
			}
			else if (whichOpLast[stack] == 1)
			{
				howManyEraser--;
			}
			else
			{
				howManyPen--;
			}
		}
		repaint();
	}
	public void redo()
	{
		if (stack < maxstack)
		{
			stack++;
		}
		repaint();
	}
	public void shape()
	{
		if (mode != 0)
		{
			mode = 0;
		}
	}
	public void erase()
	{
		if (mode != 1)
		{
			mode = 1;
		}
		else
		{
			mode = 0;
		}
		repaint();
	}
	public void pen()
	{
		if (mode != 2)
		{
			mode = 2;
		}
		else
		{
		}
		repaint();
	}

	public void ChangeSize() {
		if ((whichOpLast[stack - 1] == 0) && (stack != 0))
		{
			mode = 3;
		}
	}
	public void ChangeLocation() {
		if ((whichOpLast[stack - 1] == 0) && (stack != 0))
		{
			mode = 4;
		}
	}
	private class MouseHandler implements MouseListener,
		MouseMotionListener
	{
		public void mouseClicked(MouseEvent event)
		{
		}
		public void mousePressed(MouseEvent event)
		{
			colors[stack] = color;
			if (maxstack == stack)
			{
				maxstack++;
			}
			if (mode == 0)
			{
				whichOpLast[stack++] = 0;
				startPt[pointCount] = event.getPoint();
				endPt[pointCount] = event.getPoint();
				shape[pointCount] = toDraw;
			}
			else if (mode == 1)
			{
				eraserThickness[howManyEraser] = thickness;
				whichOpLast[stack++] = 1;
				eraseCount[howManyEraser] = 0;
				erasePt[howManyEraser][eraseCount[howManyEraser]][0] = event.getPoint().x;
				erasePt[howManyEraser][eraseCount[howManyEraser]++][1] = event.getPoint().y;
			}
			else if (mode == 2)
			{
				penThickness[howManyPen] = thickness;
				whichOpLast[stack++] = 2;
				penCount[howManyPen] = 0;
				penPt[howManyPen][penCount[howManyPen]][0] = event.getPoint().x;
				penPt[howManyPen][penCount[howManyPen]++][1] = event.getPoint().y;
			}
			else if (mode == 3) {
				endPt[pointCount - 1] = event.getPoint();
			}
			else if (mode == 4) {
				startChange = event.getPoint();
			}
		}
		public void mouseReleased(MouseEvent event)
		{
			if (mode == 0)
			{
				endPt[pointCount++] = event.getPoint();

			}
			else if (mode == 1)
			{
				erasePt[howManyEraser][eraseCount[howManyEraser]][0] = event.getPoint().x;
				erasePt[howManyEraser][eraseCount[howManyEraser]++][1] = event.getPoint().y;
				howManyEraser++;
			}
			else if (mode == 2)
			{
				penPt[howManyPen][penCount[howManyPen]][0] = event.getPoint().x;
				penPt[howManyPen][penCount[howManyPen]++][1] = event.getPoint().y;
				howManyPen++;

			}
			else if (mode == 3) {
				endPt[pointCount - 1] = event.getPoint();
			}
			else if (mode == 4) {
				endChange = event.getPoint();
				startPt[pointCount - 1].setLocation(startPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
					startPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
				endPt[pointCount - 1].setLocation(endPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
					endPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
			}
			repaint();
		}

		public void mouseEntered(MouseEvent event)
		{
		}

		public void mouseExited(MouseEvent event)
		{
		}

		public void mouseDragged(MouseEvent event)
		{
			if (mode == 0)
			{
				endPt[pointCount] = event.getPoint();
			}
			else if (mode == 1)
			{
				erasePt[howManyEraser][eraseCount[howManyEraser]][0] = event.getPoint().x;
				erasePt[howManyEraser][eraseCount[howManyEraser]++][1] = event.getPoint().y;
			}
			else if (mode == 2)
			{
				penPt[howManyPen][penCount[howManyPen]][0] = event.getPoint().x;
				penPt[howManyPen][penCount[howManyPen]++][1] = event.getPoint().y;
			}
			else if (mode == 3) {
				endPt[pointCount - 1] = event.getPoint();
			}
			else if (mode == 4) {
				endChange = event.getPoint();
				startPt[pointCount - 1].setLocation(startPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
					startPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
				endPt[pointCount - 1].setLocation(endPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
					endPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
				startChange = event.getPoint();
			}
			repaint();
		}

		public void mouseMoved(MouseEvent event)
		{
		}
	}


	public void paintComponent(Graphics g)
	{
		int j = 0, k = 0, l = 0;
		super.paintComponent(g);
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, 500, 500);
		for (int i = 0; i < stack; i++)
		{
			if (whichOpLast[i] == 0)
			{
				g.setColor(colors[i]);
				g2d.setColor(colors[i]);
				if (shape[j] == 0) {
					g.drawRect(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
						endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
					g2d.drawRect(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
						endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
				}
				else if (shape[j] == 1) {
					g.drawOval(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
						endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
					g2d.drawOval(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
						endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
				}
				else if (shape[j] == 2) {
					g.drawLine(endPt[j].x, endPt[j].y, startPt[j].x, startPt[j].y);
					g2d.drawLine(endPt[j].x, endPt[j].y, startPt[j].x, startPt[j].y);
				}
				else if (shape[j] == 3) {
					g.fillRect(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
						endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
					g2d.fillRect(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
						endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
				}
				else if (shape[j] == 4) {
					g.fillOval(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
						endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
					g2d.fillOval(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
						endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
						endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
				}
				j++;
			}
			else if (whichOpLast[i] == 1)
			{
				g.setColor(Color.white);
				for (int count = 0; count < eraseCount[k]; count++)
				{
					g.fillOval(erasePt[k][count][0] - eraserThickness[k], erasePt[k][count][1] - eraserThickness[k], eraserThickness[k] * 2, eraserThickness[k] * 2);
				}
				k++;
			}
			else
			{
				g.setColor(colors[i]);
				for (int count = 0; count < penCount[l]; count++)
				{
					g.fillOval(penPt[l][count][0] - penThickness[l], penPt[l][count][1] - penThickness[l], penThickness[l] * 2, penThickness[l] * 2);
				}
				l++;
			}
		}
		g2d.drawImage(bi, 0, 0, this);
	}
	public void save() throws IOException
	{
		ImageIO.write(bi, "PNG", new File("filename.png"));
	}

	public void load() throws IOException
	{
		bi = ImageIO.read(new File("filename.png"));
		repaint();
	}
}