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
			
			switch(optionChosen) {
			case 1:
				System.out.println("You have chosen to add a file.\n");
				addFile(sc);
				break;
			case 2:
				System.out.println("You have chosen to delete a file.\nPlease remember delete operations are case-sensitive.\nKindly enter the exact file name.\n");
				deleteFile(sc);
				break;
			case 3:
				System.out.println("You have chosen to search a file.\nPlease remember search operations are case-sensitive.\nKindly enter the exact file name.\n");
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
		System.out.println("Please enter the name of the file to be added in this directory - " + path);
		String filename=sc.next();
		File f = new File(path+filename);

		//create a new file
		
		boolean b = f.createNewFile();
		if(b) {
			System.out.println("A file has been created - " + path+filename + ".\n");
		}
		else {
			System.out.println("A file with this name- "+ filename +" already exists.\n");
		}
	}
	public void deleteFile(Scanner sc) {
		String path="C:\\Project\\ProjectSimpliLearn\\LockedMe\\src\\files\\";
		System.out.println("enter the file in the directory of " + path);
		String fileName = sc.next();
		//File
		File f = new File(path+fileName);
		//delete a file
		File allFiles = new File(path);
		File[] allFileObjects = allFiles.listFiles();
		if(allFileObjects != null && allFileObjects.length>0)
		{
			if(searchExactFile(allFileObjects,fileName))
			{
				boolean b = f.delete();
				if(b==true) {
					System.out.println("The file- " + f.getName() + " has been deleted.");
				}
				else {
					System.out.println("The file is not found/ cannot be deleted  ");
				}
			}
			else {
				System.out.println("File- " + f.getName()+ " was not found in the directory.\n");
			}	
		}
		else
		{
			System.out.println("No files found in the directory- " + path +"\n");
		}
	}	
	public void searchFile(Scanner sc) {

		String path = "C:\\Project\\ProjectSimpliLearn\\LockedMe\\src\\files\\";
		System.out.println("Enter the name of the file be searched in this directory - " + path);
		String fileName = sc.next();
		File allFiles = new File(path);
		File[] allFileObjects = allFiles.listFiles();
		if(allFileObjects != null && allFileObjects.length>0){

			if(searchExactFile(allFileObjects,fileName)) 
			{
				System.out.println("The file- " + fileName + " is present in the directory.\n");
			}
			else {
				System.out.println("The file- " + fileName + " is not found in the directory.\n");
			}
		}
		else 
			System.out.println("No files found in the directory- " + path +"\n");
	}

	public boolean searchExactFile(File[] allFileObjects, String fileToBeSearched) {

		boolean flag = false;
		if(allFileObjects.length > 0)
		{
			for(File ff: allFileObjects) {
				if(ff.getName().equals(fileToBeSearched)) {
					flag=true;
					break;
				}
				else {
					flag=false;
				}
			}
		}
		return flag;
	}
}
