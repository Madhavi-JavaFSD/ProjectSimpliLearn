package com.companylockers.fileop.main;

import java.io.IOException;
import java.util.Scanner;

import com.companylockers.fileop.display.DisplayFiles;
import com.companylockers.fileop.menu.fileOperations;

/*
 * FileOpMainOperations
 */
public class FileOpMainOperations {

	public static void main(String[] args) throws IOException {
		System.out.println("***Company Lockers Pvt. Ltd. -- LockedMe Application***");
		System.out.println("\n***You can perform file related operations here. The operation to add a file is\n case-insensitive while the search and delete file operations are case-sensitive.***\n");
		Scanner sc = new Scanner(System.in);		
		boolean continueLoop = true;
		while(continueLoop)
		{
			System.out.println("Press 1 to display all the files, Press 2 to perform file related operations, Press 3 to exit.");
			if(sc.hasNext()) {
				//System.out.println("in IF HasNext");
				while (!sc.hasNextInt()) {
					String input = sc.next();
					System.out.printf("\"%s\" is not a valid input.Please choose from the given three options.", input);
				}
				int optionChosen = sc.nextInt();
				switch(optionChosen) {
				case 1:
					System.out.println("You have chosen to display all the files-\n");
					DisplayFiles obj = new DisplayFiles();
					obj.displayAllFiles();
					break;
				case 2:
					System.out.println("You have chosen to perform file related operations.\n");
					fileOperations obj2 = new fileOperations();
					obj2.displayAllOptions(sc);
					break;
				case 3:
					System.out.println("You have chosen to close this application.\n");	
					continueLoop = false;
					break;
				default:
					System.out.println("Please enter any one of the 3 given options.\n");
				}
				//System.out.println("Outside switch");
			}
		}
	}

}
