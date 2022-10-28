package com.companylockers.fileop.display;

import java.io.File;
import java.util.Scanner;

public class DisplayFiles {

	public void displayAllFiles() {
		String path="C:\\Users\\shash\\eclipse-workspace\\LockedMe\\src\\files\\";
		File f=new File(path);
		File filenames[]=f.listFiles();
		if(filenames != null  && filenames.length > 0) {
			System.out.println("The files are:");
			for(File ff: filenames) {
				System.out.println(ff.getName());
			}
		} 
		else if(filenames != null  && filenames.length == 0) {
			System.out.println("No Files to be displayed in this location.\n");
		}
		else if(filenames == null) {
			System.out.println("No Files to be displayed in this location.\n");
		}
		
		
	}
}
