package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Convert {

	public void convert() {
		String inputFilePath = "data/input";
		String outputFilePath = "data/output";

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(inputFilePath), "MS949"));
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
			System.out.println("Finish");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
