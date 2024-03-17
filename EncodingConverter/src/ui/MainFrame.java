package ui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import control.Convert;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JList<File> inputList;
	private JLabel isNoFileList;
	private ButtonPanel buttonPanel;
	private Convert convert;
	private DefaultListModel<File> listModel;
	
	public MainFrame() {
		this.convert = new Convert(this);
		this.setLayout(new BorderLayout());
				
		this.setTitle("Java Encoding Converter");
		this.setSize(400, 500);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	
		
		JLabel title = new JLabel("Input File List");
		this.add(title, BorderLayout.NORTH);	
		
		this.isNoFileList = new JLabel("Please Upload Files");
		this.add(isNoFileList, BorderLayout.CENTER);
		this.listModel = new DefaultListModel<>();
		
		this.listModel.addElement(new File("Test.txt"));
		
		this.inputList = new JList<File>(listModel);
		
		
        JScrollPane scrollPane = new JScrollPane(this.inputList);
		this.add(scrollPane, BorderLayout.CENTER);
	
		updateDisplay();
		
		this.buttonPanel = new ButtonPanel(this.convert);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	private void updateDisplay() {
		
	}
}
