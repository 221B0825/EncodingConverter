package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import ui.MainFrame;

public class Convert {
	private MainFrame mainFrame;

	public Convert(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void upload() {
		DefaultListModel<File> selectedFiles = this.mainFrame.getListModel();
		
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(null);

        // if user choose "OPEN"
        if (result == JFileChooser.APPROVE_OPTION) {
        	File[] files = fileChooser.getSelectedFiles();
            for (File file : files) {
                selectedFiles.addElement(file);   
            }
        }
        this.mainFrame.setListModel(selectedFiles);
        this.mainFrame.updateDisplay();
	}

	public void convert() {
	    DefaultListModel<File> selectedFiles = this.mainFrame.getListModel();
	    
	    for(int i = 0; i < selectedFiles.size(); i++) {
	    	boolean firstLine = true;
	    	
	    	File inputFile = selectedFiles.get(i);
	        String outputFilePath = "output\\" + inputFile.getName() + ".txt";
	        
	        try (BufferedReader reader = new BufferedReader(
	                new InputStreamReader(new FileInputStream(inputFile), "MS949"));
	             BufferedWriter writer = new BufferedWriter(
	                     new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"))) {
	            
	            String line;
	            while ((line = reader.readLine()) != null) {
	                if (!firstLine) {
	                    writer.newLine();
	                } else {
	                    firstLine = false;
	                }
	                writer.write(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }           
	    }       
	}


	public void delete() {

	}

}
