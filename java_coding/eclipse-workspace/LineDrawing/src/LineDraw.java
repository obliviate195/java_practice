import java.awt.Graphics;
import javax.swing.JPanel;

public class LineDraw extends JPanel {
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width=getWidth();	//panel �ʺ�
		int height=getHeight();	//panel ����
		
		for(int i=0, j=10;(i<height)&&(j<width);i+=10,j+=10)
		{
			g.drawLine(0, i, j, height);	//�� ����ǥ�� �� ����ǥ ���� �ִ� ���� �׸���
		}

	}
}
