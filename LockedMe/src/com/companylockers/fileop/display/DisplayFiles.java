package com.companylockers.fileop.display;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DisplayFiles {

	public void displayAllFiles() {
		String path="C:\\Project\\ProjectSimpliLearn\\LockedMe\\src\\files\\";
		File f = new File(path);
		/*File filenames[]=f.listFiles();
		if(filenames != null  && filenames.length > 0) {
			System.out.println("The files are:");
			for(File ff: filenames) {
				System.out.println(ff.getName());
			}
		} */
		
		List<String> filenames = Arrays.asList(f.list());
		if(filenames != null  && filenames.size() > 0)
		{
			Collections.sort(filenames);
			for(String s:filenames){
				System.out.println(s);
			}
			System.out.println();
		}
		else if(filenames != null  && filenames.size() == 0) {
			System.out.println("No Files to be displayed in this location.\n");
		}
		else if(filenames == null) {
			System.out.println("No Files to be displayed in this location.\n");
		}
		
		
	}
}
