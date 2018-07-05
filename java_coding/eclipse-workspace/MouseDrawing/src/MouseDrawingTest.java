import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseDrawingTest extends JFrame {
	public MouseDrawingTest() {
		this.add(new MyPanel());
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new MouseDrawingTest();
	}
}
