import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonTest {
	

	public static void main(String[] args)
	{
		JFrame application=new JFrame("GrimPan");
		JPanel panel=new JPanel();
		JButton[] btn=new JButton[2];
		for(int i=0;i<btn.length;i++)
		{
			btn[i]=new JButton();
		}	
		//JButton btn2=new JButton("qqq");
		panel.add(btn[0]);
		panel.add(btn[1]);
		application.add(panel);
		application.setSize(300,600);
		application.setVisible(true);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
