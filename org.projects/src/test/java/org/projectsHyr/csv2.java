package org.projectsHyr;

import java.io.FileReader;
import com.opencsv.CSVReader;

public class csv2 {
	public static void main(String[] args) {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("C:\\\\Users\\\\DinnuBunny\\\\Downloads\\\\Book1.csv"));
//			System.out.println(reader.verifyReader());
			String[] nextLine;
//read one line at a time  
			while ((nextLine = reader.readNext()) != null) {
//				System.out.println(nextLine);
				for (String each : nextLine) {
					System.out.print("| " + each + " ");
				}
				System.out.println("|");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
