package com.companylockers.fileop.menu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class fileOperations {

	public void displayAllOptions(Scanner sc) throws IOException {

		while(true){
			System.out.println("Press 1 to add a file, Press 2 to delete a file, Press 3 to search a file, Press 4 to go back to the main menu.\n");
			int optionChosen = 0;

			while (!sc.hasNextInt()) {
				String input = sc.next();
				System.out.printf("\"%s\" is not a valid input.Please choose from the given four options.", input);
			}
			optionChosen = sc.nextInt();

			//System.out.println("optionChosen-- " + optionChosen);
			switch(optionChosen) {
			case 1:
				System.out.println("You have chosen to add a file.\n");
				addFile(sc);
				break;
			case 2:
				System.out.println("You have chosen to delete a file.\n");
				deleteFile(sc);
				break;
			case 3:
				System.out.println("You have chosen to search a file.\n");
				searchFile(sc);
				break;	
			case 4:
				System.out.println("You have chosen to go back to the main menu.\n");
				return;	
			default:
				System.out.println("Please enter any one of the 4 given options.\n");				
			}

		}
	}
	public void addFile(Scanner sc) throws IOException {
		String path="C:\\Project\\ProjectSimpliLearn\\LockedMe\\src\\files\\";
		
		System.out.println("enter the file in the directory of "+path);
		String filename=sc.next();
		File f = new File(path+filename);
		System.out.println("File name- " + (path+filename));
		//create a new file
		boolean b = f.createNewFile();
		if(b!=true) {
			System.out.println("file not created");
		}
		else {
			System.out.println("file created in the path" +path);
		}

	}
	public void deleteFile(Scanner sc) {
		String path="C:\\Project\\ProjectSimpliLearn\\LockedMe\\src\\files\\";
		System.out.println("enter the file in the directory of " + path);
		String filename=sc.next();
		//File
		File f=new File(path+filename);
		//delete a file
		boolean b=f.delete();
		if(b==true) {
			System.out.println("file has been deleted");
		}
		else {
			System.out.println("file is not found/ cannot be deleted  ");
		}

	}	
	public void searchFile(Scanner sc) {
		String path="C:\\Project\\ProjectSimpliLearn\\LockedMe\\src\\files\\";
		System.out.println("enter the file in the directory of "+path);
		String filename=sc.next();
		File f=new File(path);
		File filenames[]=f.listFiles();
		int flag=0;
		if(filenames != null && filenames.length>0)
		{
			for(File ff: filenames) {
				if(ff.getName().equals(filename)) {
					flag=1;
					break;
				}
				else {
					flag=0;
				}
			}		
			if(flag==1) {
				System.out.println("The file is found.");
			}
			else {
				System.out.println("The file is not found.");
			}
		}
		else 
			System.out.println("No files found in the directory- " +path);
	}
}
