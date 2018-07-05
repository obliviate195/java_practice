import javax.swing.JFrame;

public class LineDrawing {
	public static void main(String[] args)
	{
		LineDraw panel=new LineDraw();
		
		JFrame application=new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		application.add(panel);
		application.setSize(250,250);
		application.setVisible(true);
	}
}
