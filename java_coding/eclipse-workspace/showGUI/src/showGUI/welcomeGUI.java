package showGUI;

//JOptionPane: 알림메시지 클래스
import javax.swing.JOptionPane;

public class welcomeGUI {
	public static void main(String[] args)
	{
		String name=
				JOptionPane.showInputDialog("What is your name?");
		
		String message=
				String.format("Welcome, %s, to Java Programming!", name);
		
		JOptionPane.showMessageDialog(null,message);
	}
}
