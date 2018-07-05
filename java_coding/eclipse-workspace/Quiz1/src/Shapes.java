import java.awt.Graphics;
import javax.swing.JPanel;


public class Shapes extends JPanel{
	private int choice;
	private static int count_rect=0, count_tri=0, count_cir=0;
	
	public Shapes(int userChoice) 
	{
		choice=userChoice;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		switch(choice)
		{
		case 1:
			g.drawRect(10, 10, 100, 50);
			count_rect=count_rect+1;
			break;
		case 2:
			g.drawLine(10+count_tri*50, 100, 10+count_tri*50, 150);
			g.drawLine(10+count_tri*50, 150, 60+count_tri*50, 150);
			g.drawLine(10+count_tri*50, 100, 60+count_tri*50, 150);
			count_tri=count_tri+1;
			break;
		case 3:
			g.drawOval(150+count_cir*10, 10+count_cir*10, 50, 50);
			count_cir=count_cir+1;
			break;
		}
	}
}
