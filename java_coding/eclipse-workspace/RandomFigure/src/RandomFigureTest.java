import javax.swing.JFrame;
import java.util.Scanner;

public class RandomFigureTest {
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int choice;
		int value;
		System.out.println("Choose figure: Lines(1) "
				+ "Rectangles(2) Circles(3)");
		choice=input.nextInt();
		DrawPanel panel=new DrawPanel(choice);
		JFrame application=new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		application.add(panel);
		application.setSize(500,500);
		application.setVisible(true);
		
		System.out.print("Erase figure: ");
		value=input.nextInt();
		
		panel.erase(value);
		
		panel.repaint();
	}
}
