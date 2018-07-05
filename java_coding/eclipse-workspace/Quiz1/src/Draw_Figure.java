import javax.swing.JFrame;
import java.util.Scanner;

public class Draw_Figure {

	public static void main(String[] args)
	{
		
		java.util.Scanner input = new Scanner(System.in);
		int choice=0;
		while(true)
		{
			System.out.printf("Enter 1 to draw rectangles\nEnter 2 to draw triangles\nEnter 3 to draw circles\n");
			choice=input.nextInt();
			if (choice==-1) break;
			Shapes panel=new Shapes(choice);
			
			JFrame application=new JFrame();
			
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			application.add(panel);
			application.setSize(300,300);
			application.setVisible(true);
		}
	}
}
