
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame
{
	private JButton ovalJButton;
	private JButton rectJButton;
	private JButton paintJButton;
	private PaintPanel paintPanel;
	private JButton eraseJButton;
	private JPanel testPanel;
	
	public ButtonFrame()
	{
		super("PaintTest");
		testPanel=new JPanel();
		ovalJButton = new JButton( "Draw Oval" );
		testPanel.add(ovalJButton,BorderLayout.NORTH);
		add(testPanel,BorderLayout.WEST);
		//add(ovalJButton, BorderLayout.WEST);

		rectJButton = new JButton("Draw Rectangle");
		testPanel.add(rectJButton);
		
		//paintJButton = new JButton("Paint");
		//add(paintJButton, BorderLayout.EAST);
		
		//eraseJButton = new JButton("Erase");
		//add(eraseJButton, BorderLayout.SOUTH);
		
		paintPanel = new PaintPanel();
		add(paintPanel, BorderLayout.CENTER);
		
		ButtonHandler handler = new ButtonHandler();
		ovalJButton.addActionListener(handler);
		//rectJButton.addActionListener(handler);
		//eraseJButton.addActionListener(handler);
		//paintJButton.addActionListener(handler);
		
	}
	
	private class ButtonHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
					"You pressed: %s", event.getActionCommand()));
			paintPanel.drawShape(event);
		}
	}
}

