package LockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Directory {
	public void displayFiles(File[] f) {
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i].getName()); // getName for removal of pathname from filename
		}
	}

	public void searchFiles(File[] f, String name) {
		boolean check = true;
		for (int i = 0; i < f.length; i++) {
			if (f[i].getName().equalsIgnoreCase(name)) {
				System.out.println(name + " file found at position" + " " + i);
				check = true;
				break;
			} else
				check = false;

		}
		if (check == false)
			System.out.println("File not found");
	}

	public void deleteFile(File[] f, String x) {
		boolean flag = true;
		for (int i = 0; i < f.length; i++) {
			if (f[i].getName().equalsIgnoreCase(x)) {
				f[i].delete();
				System.out.println(f[i].getName() + " " + "successfully deleted!");
				flag = true;
				break;

			} else {
				flag = false;
			}

		}
		if (flag == false) {
			System.out.println("File name not found!");
		}
	}

	public void createFile(File f, String fname) {
		try {
			if (f.createNewFile())
				System.out.println(fname + " File has been created successfully!.");
			else
				System.out.println("File already present!");
		} catch (IOException e) {
			System.out.println("enter valid file name.");
			// e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InputMismatchException {
		String pathname = "C:\\Users\\sjagadal\\Desktop\\LockedMe";
		File dir = new File(pathname);

		File[] listOfFiles = dir.listFiles();
		Arrays.sort(listOfFiles);

		Directory d = new Directory();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome!..");
		System.out.println("Application : LockedMe.com");
		System.out.println("Developer   : Siddarudh Jagadal");
		System.out.println("--------------------------------------");
		System.out.println("Enter one of option below");
		System.out.println("1. List of all files");
		System.out.println("2. Add/delete/search file");
		System.out.println("3. Close Program");

		boolean flag = true;

		while (flag == true) {

			System.out.println("---------------------");
			System.out.print("Enter your main option: ");

			String option = sc.next();

			switch (option) {
			case "1":
				d.displayFiles(listOfFiles);
				break;
			case "2":
				System.out.println(" Enter option below");
				System.out.println("A.Create new file");
				System.out.println("B.Delete file");
				System.out.println("C.Search for file");
				System.out.println("D.Go back to main menu");
				boolean flag1 = true;
				while (flag1 == true) {
					System.out.println("---------------------");
					System.out.print("Enter your SubOption: ");
					String subOption = sc.next();
					switch (subOption) {
					case "A":
						System.out.println("enter the file name you want to create: ");
						String fAdd = sc.next();
						String pathname1 = pathname + "\\" + fAdd;
						File newFile = new File(pathname1);
						d.createFile(newFile, pathname1);

						break;
					case "B":
						System.out.println("enter the filename you want to delete: ");
						String fname = sc.next();
						d.deleteFile(listOfFiles, fname);
						break;
					case "C":
						System.out.println("enter the filename you want to search: ");
						
						String fname1 = sc.next();

						d.searchFiles(listOfFiles, fname1);
						break;
					case "D":
						System.out.println("Navigating back to Main menu");
						System.out.println("----------------------------");
						System.out.println("1. List of all files");
						System.out.println("2. Add/delete/search file");
						System.out.println("3. Close Program");
						flag1 = false;
						break;
					default:
						System.out.println("please enter valid Sub option!");
					}

				}
				break;
			case "3":
				System.out.print("Thank you!..You have been exited from Program.");
				flag = false;
				break;

			default:
				System.out.println("please enter valid option number!");

			}
		}

		sc.close();

	}
}
