import java.awt.Graphics;
import javax.swing.JPanel;

public class LineDraw extends JPanel {
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width=getWidth();	//panel 너비
		int height=getHeight();	//panel 높이
		
		for(int i=0, j=10;(i<height)&&(j<width);i+=10,j+=10)
		{
			g.drawLine(0, i, j, height);	//앞 두좌표와 뒤 두좌표 점을 있는 선분 그리기
		}

	}
}
