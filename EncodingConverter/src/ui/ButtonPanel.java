package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.Convert;

public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton uploadButton;
	private JButton deleteButton;
	private JButton convertButton;
	private ButtonActionHandler buttonActionHandler;
	
	private MainFrame mainFrame;
	private Convert convert;
	
	public ButtonPanel(Convert convert) {
		this.convert = convert;
		this.buttonActionHandler = new ButtonActionHandler();
		
		this.uploadButton = new JButton("upload");
		this.uploadButton.setActionCommand(uploadButton.getText());
		this.uploadButton.addActionListener(buttonActionHandler);
		this.add(this.uploadButton);
	
		this.deleteButton = new JButton("delete");
		this.deleteButton.setActionCommand(deleteButton.getText());
		this.deleteButton.addActionListener(buttonActionHandler);
		this.add(this.deleteButton);
		
		
		this.convertButton = new JButton("convert");
		this.convertButton.setActionCommand(convertButton.getText());
		this.convertButton.addActionListener(buttonActionHandler);
		this.add(this.convertButton);
	}
	
	private class ButtonActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(uploadButton.getText())) {
				convert.upload();
			}else if(e.getActionCommand().equals(deleteButton.getText())) {
				convert.delete();
			}else if(e.getActionCommand().equals(convertButton.getText())) {
				// message frame
				convert.convert();
			}
		}
	}
}
