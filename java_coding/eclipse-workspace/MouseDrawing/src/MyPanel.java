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
			startP = e.getPoint(); // 클릭한부분을 시작점으로
		}
		public void mouseReleased(MouseEvent e){
			endP = e.getPoint(); // 드래그 한부분을 종료점으로
			Graphics g = getGraphics();
			g.drawLine(startP.x, startP.y, endP.x, endP.y);
		}
	}


}
