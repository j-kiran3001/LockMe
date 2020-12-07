import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFile {
	private static Scanner scanner = new Scanner(System.in);
	private static DirectoryOperation directoryOperation = new DirectoryOperation();

	public static void main(String[] args) {
		startApplication();
		mainMenu();
	}

	private static void mainMenu() {
		printActions();
		boolean quit = false;
		while (!quit) {
//			System.out.println("\n Enter action: (4 to show available actions)");
			try {
				int action = scanner.nextInt();
				scanner.nextLine();

				if (action > 0 && action < 5) {
					switch (action) {
					case 1:
						directoryOperation.printFileList();
						break;

					case 2:
						printUserOptions();
						int userAction = scanner.nextInt();
						scanner.nextLine();
						new MainFile().UserOptions(userAction);
						break;

					case 3:
						closeApplication();
						break;

					case 4:
						printActions();
						break;

					}
				} else {
					System.out.println("Please select valid option.");
					printActions();
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				System.out.println("Please select valid option.");
				printActions();
				scanner.nextLine();
			}
		}
	}

	private static void startApplication() {
		System.out.println("|==============   Welecome to LockMe.com   ==============|" + "\n"
				+ "| \t\t DOCUMENT MANAGEMENT SOFTWARE \t\t |" + "\n"
				+ "| \t  All Your Important Documents in One Place \t |" + "\n"
				+ "|--------------------------------------------------------|" + "\n"
				+ "| \t\t Developer Name: Kiran Jadhav \t\t |" + "\n"
				+ "| \t Developer Contact: jkiran3001@gmail.com \t |" + "\n"
				+ "|========================================================|");
		System.out.println();
		File file = new File("D:\\LockMe");
		boolean bool = file.mkdir();
		if (bool) {
			System.out.println("Root Directory created successfully");
			System.out.println("Current Working directory: D:\\LockMe");
		} else {
			System.out.println("Current Working directory: D:\\LockMe");
		}
	}

	private static void closeApplication() {
		System.out.println("\nClosing the application....");
		System.exit(0);
	}

	private static void printActions() {
		System.out.println("----------------------------------------------------------");
		System.out.println("Available Actions:");
		System.out.println("\t 1 - Display the lists of files in the directory\n"
				+ "\t 2 - Display the available options for user \n" + "\t 3 - Close the application\n");
		System.out.println("Enter your choice");
	}

	private void UserOptions(int userAction) {
		if (userAction > 0 && userAction < 5) {
			switch (userAction) {
			case 1:
				System.out.println("🛈 You can only add text file");
				System.out.println("Enter the file name that you want to add: \n");
				String newFileName = scanner.nextLine();
				directoryOperation.addNewFile(newFileName);
				break;

			case 2:
				System.out.println("Enter the file name that you want to delete: \n");
				String fileName = scanner.nextLine();
				directoryOperation.deleteFile(fileName);
				break;

			case 3:
				System.out.println("Enter the file name that you want to find: \n");
				String searchName = scanner.nextLine();
				directoryOperation.searchFile(searchName);
				break;

			case 4:
				System.out.println("Back to main menu \n");
				mainMenu();
				break;
			}

		} else {
			System.out.println("Please select valid option.");
			System.out.println("Returning to main menu");
			printActions();
		}
	}

	private static void printUserOptions() {
		System.out.println("Available Options for User:");
		System.out.println("\t1 - Add a file in the directory\n" + "\t2 - Delete a file from the directory\n"
				+ "\t3 - Search a file in the directory\n" + "\t4 - Return to main menu");
		System.out.println("Enter your choice");
	}

}
