import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawFigureFrame extends JFrame {
	private JPanel mousePanel;
	private int x1=0, y1=0, x2=0, y2=0;
	private JRadioButton rectButton;
	private JRadioButton ovalButton;
	private JRadioButton lineButton;
	private ButtonGroup radioGroup;
	Graphics g=getGraphics();
	
	public DrawFigureFrame()
	{
		super("Demonstrating Mouse Events");
		
		mousePanel=new JPanel();
		rectButton=new JRadioButton("Rect", false);
		ovalButton=new JRadioButton("Oval", false);
		lineButton=new JRadioButton("Line", false);
		mousePanel.add(rectButton);
		mousePanel.add(lineButton);
		mousePanel.add(ovalButton);
		radioGroup=new ButtonGroup();
		radioGroup.add(rectButton);
		radioGroup.add(ovalButton);
		radioGroup.add(lineButton);
		mousePanel.setBackground(Color.white);
		add(mousePanel);
		MouseHandler handler=new MouseHandler();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener
	{
		public void mouseClicked(MouseEvent event)
		{
			
		}
		public void mousePressed(MouseEvent event)
		{
			x1=event.getX();
			y1=event.getY();
		}
		public void mouseReleased(MouseEvent event)
		{
			int width=0, height=0;
			x2=event.getX();
			y2=event.getY();
			if(x2>x1) width=x2-x1;
			else width=x1-x2;
			if(y2>y1) height=y2-y1;
			else height=y1-y2;
			
			g.setColor(Color.BLACK);
			g.fillOval(x1, y1, width, height);
		}
		public void mouseEntered(MouseEvent event)
		{
			
		}
		public void mouseExited(MouseEvent event)
		{
			
		}
		public void mouseDragged(MouseEvent event)
		{
			
		}
		public void mouseMoved(MouseEvent event)
		{
			
		}
	}
	public static void main(String[] args)
	{
		DrawFigureFrame drawFigureFrame=new DrawFigureFrame();
		drawFigureFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawFigureFrame.setSize(500,500);
		drawFigureFrame.setVisible(true);
	}
}
