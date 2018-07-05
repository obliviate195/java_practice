import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel{
	Point startP = null;
	Point endP = null;
	
	public MyPanel(){
		this.addMouseListener(new MyMouseListener());
	}
	
	class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			startP = e.getPoint(); // Ŭ���Ѻκ��� ����������
		}
		public void mouseReleased(MouseEvent e){
			endP = e.getPoint(); // �巡�� �Ѻκ��� ����������
			Graphics g = getGraphics();
			g.drawLine(startP.x, startP.y, endP.x, endP.y);
		}
	}


}
