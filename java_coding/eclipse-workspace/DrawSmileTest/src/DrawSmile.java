import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


public class DrawSmile extends JPanel {
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Color col1=new Color(255,0,0);
		g.setColor(Color.yellow);
		g.fillArc(10,10,300,300,0,-180);
		
		g.setColor(Color.black);
		g.fillOval(55,65,30,30);
		g.fillOval(135,65,30,30);
		
		g.fillOval(50,110,120,60);
		
		g.setColor(Color.yellow);
		g.fillRect(50,110,120,30);
		g.fillOval(50,120,120,40);
		
	}
}
