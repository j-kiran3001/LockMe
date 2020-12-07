import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DirectoryOperation {

	public void printFileList() {
		File fileDir = new File("D:\\LockMe");
		List<File> listFile = Arrays.asList(fileDir.listFiles());
		if (listFile.isEmpty()) {
			System.out.println("Directory is Empty");
		} else {
			Collections.sort(listFile);
			System.out.println("\n----------------------------------------------------------");
			int count = 0;
			for (File s : listFile) {
				if (s.isFile()) {
					System.out.println(s.getName());
					count++;
				}
			}
			if (count == 0) {
				System.out.println("This directory does not contain any text file.");
			}
			System.out.println("----------------------------------------------------------\n");
		}
		System.out.println("\nEnter action: (4 to show available actions)");
	}

	public void addNewFile(String newFileName) {
		try {
			if (newFileName.contains("\\") || newFileName.contains("/") || newFileName.contains(":")
					|| newFileName.contains("*") || newFileName.contains("?") || newFileName.contains("\"")
					|| newFileName.contains("<") || newFileName.contains(">") || newFileName.contains("|")) {
				System.out.println(
						"A file name can't contain any of the following characters:\r\n" + "\\ / : *? \" < > |");
				return;
			}

			if (newFileName.length() > 250) {
				System.out.println("File name is too long...");
				return;
			}

			File file = new File("D:\\LockMe\\" + newFileName + ".txt"); // this is used to create the file
			if (file.createNewFile()) {
				System.out.println("New File is created...!");
			} else {
				if (file.exists()) {
					System.out.println("File already exists.");
					System.out.println("File path: " + file.getAbsolutePath());
					System.out.println("File name:  " + file.getName());
					System.out.println("File space allocated:  " + file.getUsableSpace());
					System.out.println("File length: " + file.length());

				} else {
					System.out.println("File does not exists.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\nEnter action: (4 to show available actions)");
	}

	public void deleteFile(String fileName) {
		File file = new File("D:\\LockMe\\" + fileName + ".txt");
		boolean b = file.delete();
		if (b == true) {
			System.out.println("File deleted..!!");
		} else {
			System.out.println("File not found.");
			System.out.println("File not deleted");
		}

		System.out.println("\nEnter action: (4 to show available actions)");
	}

	public void searchFile(String searchName) {
		List<String> listFile = Arrays.asList(new File("D:\\LockMe").list());
		System.out.println("Seraching file by filename....");
		System.out.println("----------------------------------------------------------\n");
		int count = 0;
		for (int i = 0; i < listFile.size(); i++) {
			if (listFile.get(i).equals(searchName + ".txt")) {
				File dir = new File("D:\\LockMe" + searchName);
				System.out.println("File path:" + dir.getAbsolutePath());
				System.out.println("File name:  " + dir.getName());
				System.out.println("File parent:  " + dir.getParent());
				System.out.println("File space allocated:  " + dir.getUsableSpace());
				System.out.println("File length: " + dir.length());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("File not found");
		}
		System.out.println("\nEnter action: (4 to show available actions)");
	}
}
