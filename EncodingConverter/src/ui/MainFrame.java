package ui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.Convert;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private DefaultListModel<File> listModel;
	private JList<File> inputList;
	private JScrollPane scrollPane;
	private JLabel isNoFileList;
	private ButtonPanel buttonPanel;
	private Convert convert;
	
	public MainFrame() {
		this.convert = new Convert(this);
		this.setLayout(new BorderLayout());
				
		this.setTitle("Java Encoding Converter");
		this.setSize(400, 500);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	
		
		JLabel title = new JLabel("Input File List");
		this.add(title, BorderLayout.NORTH);	
		
		// Create centerPanel to contain label and scroll pane
		// ----- centerPanel -----
        JPanel centerPanel = new JPanel(new BorderLayout());

        this.isNoFileList = new JLabel("Please Upload Files");
        centerPanel.add(isNoFileList, BorderLayout.NORTH);

        this.listModel = new DefaultListModel<>();
        this.inputList = new JList<File>(listModel);
        this.scrollPane = new JScrollPane(this.inputList);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        // ----- End -----
        
        this.add(centerPanel, BorderLayout.CENTER);
		this.buttonPanel = new ButtonPanel(this.convert);
		this.add(buttonPanel, BorderLayout.SOUTH);
	
		// display update
		updateDisplay();
	}
	
	public void updateDisplay() {
		if(this.listModel.isEmpty()) {
			this.scrollPane.setVisible(false);
			this.isNoFileList.setVisible(true);
		}else {
			this.scrollPane.setVisible(true);
			this.isNoFileList.setVisible(false);
		}
	}
	
	

	public void setListModel(DefaultListModel<File> selectedFiles) {
		this.listModel = selectedFiles;
	}

	public DefaultListModel<File> getListModel() {
		return this.listModel;
	}

}
