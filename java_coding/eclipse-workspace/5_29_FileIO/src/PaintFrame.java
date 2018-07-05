
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;


public class PaintFrame extends JFrame 
{
	private static PaintPanel paintPanel;
	private int shape, color;
	private JButton UndoJButton;
	private ButtonGroup colorButtonGroup;
	private JRadioButtonMenuItem[][] colorItems;
	private static final String[] shapes =
		{"Rectangle", "Oval", "Line"};
	private static final String[] colors =
		{"red", "green", "blue", "black"};
	
	public PaintFrame()
	{
		super("Painting");
		setLayout(new FlowLayout());
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		bar.add(fileMenu);
		
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.setMnemonic('S');
		fileMenu.add(saveItem);
		JMenuItem loadItem = new JMenuItem("Load");
		loadItem.setMnemonic('L');
		fileMenu.add(loadItem);
		
		JMenu shapeMenu = new JMenu("Shape");
		shapeMenu.setMnemonic('h');
		bar.add(shapeMenu);
		
		JMenu rectMenu = new JMenu("Rectangle");
		rectMenu.setMnemonic('R');
		shapeMenu.add(rectMenu);
		JMenu ovalMenu = new JMenu("Oval");
		ovalMenu.setMnemonic('O');
		shapeMenu.add(ovalMenu);
		JMenu lineMenu = new JMenu("Line");
		lineMenu.setMnemonic('L');
		shapeMenu.add(lineMenu);
		
		JMenu FunctionMenu = new JMenu("Functions");
	    bar.add(FunctionMenu);
	    
	    JMenuItem Undo = new JMenuItem("Undo");
	    FunctionMenu.add(Undo);
	    JMenuItem Redo = new JMenuItem("Redo");
	    FunctionMenu.add(Redo);
		
		JMenu[] shapeMenuList = {rectMenu, ovalMenu, lineMenu};
		
		colorItems = new JRadioButtonMenuItem[shapes.length][colors.length];
		colorButtonGroup = new ButtonGroup();

		ItemHandler itemHandler= new ItemHandler();
				
		for (int shapeCount = 0; shapeCount < shapes.length; shapeCount++)
		{
			for (int colorCount = 0; colorCount < colors.length; colorCount++)
			{
				colorItems[shapeCount][colorCount] = new JRadioButtonMenuItem(colors[colorCount]);
				shapeMenuList[shapeCount].add(colorItems[shapeCount][colorCount]);
				colorButtonGroup.add(colorItems[shapeCount][colorCount]);
				colorItems[shapeCount][colorCount].addActionListener(itemHandler);
			}
		}
		
		colorItems[0][0].setSelected(true);
		
		paintPanel = new PaintPanel();
		add(paintPanel);
		ButtonHandler handler = new ButtonHandler();
		Undo.addActionListener(handler);
		Redo.addActionListener(handler);
		saveItem.addActionListener(handler);
		loadItem.addActionListener(handler);
		
		paintPanel.setPreferredSize(new Dimension(500, 500));		
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getActionCommand() == "Undo")
			{
				paintPanel.undo();
			}
			else if(event.getActionCommand() == "Redo")
			{
				paintPanel.redo();
			}
			else if(event.getActionCommand()=="Save")
			{
				try {
					conductSerializing();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(event.getActionCommand()=="Load")
			{
				try {
					paintPanel.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	private class ItemHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			label:
			for ( int shapeCount = 0; shapeCount < shapes.length; shapeCount++)
			{
		
				for ( int colorCount = 0; colorCount < colors.length; colorCount++)
				{
					if (colorItems[shapeCount][colorCount].isSelected())
					{
						shape = shapeCount;
						color = colorCount;
						paintPanel.drawShape(shape, color);
						break label;
					}
				}
			}
		}
	}
	public static void conductSerializing()  {
		 FileOutputStream fos;
		try {
			fos = new FileOutputStream("object.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
	        ObjectOutputStream out = new ObjectOutputStream(bos);
	        out.writeObject(paintPanel);
	        out.close();
	        System.out.println("저장 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
