package org.projectsHyr;

import java.io.FileReader;
import java.util.Iterator;

import com.opencsv.CSVReader;

public class csv2 {
	public static void main(String[] args) {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("C:\\\\Users\\\\DinnuBunny\\\\Downloads\\\\Book1.csv"));
//			System.out.println(reader.verifyReader());
			String[] nextLine;
//read one line at a time  
			Iterator<String[]> it = reader.iterator();
			String[] headerrow = it.next();
			while (it.hasNext()) {
//				System.out.println(nextLine);
				String[] nxt = it.next();
				for (String n : nxt) {
					System.out.print("| " + n + " ");
				}
				System.out.println("|");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
