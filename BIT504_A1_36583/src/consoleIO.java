import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Formatter;


//This Class deals with the console input and output requirements.
public class consoleIO {
	
	//Display a menu on the console.
	public static void displayMenu() {
		System.out.println("Student Report System");
		System.out.println("---------------------");
		System.out.println();
		System.out.println("1) Display student marks.");
		System.out.println("2) Display student grades.");
		System.out.println("3) Add new student.");;
		System.out.println("4) Remove student.");
		System.out.println("5) Exit.");
	}
	
	//Display a user prompt on the console, and given a range of acceptable integers, returns the users response.
	public static int getUserInputInt(Scanner scanner, String prompt, int minInt, int maxInt) {
		
		int option = -1;
		
		do {
			//Prompt is a string passed when calling this method.
			System.out.println(prompt);
			try {
				//Read the next integer on the console.
				option = scanner.nextInt();
			}
			//If an integer is not entered, catch the exception, and inform the user.
			catch(InputMismatchException e) {
				//Checks that only an integer is entered.
				System.err.println("Please enter an integer number.");
				//The following line is required because otherwise the newline character produced when the user hits enter is read and the 
				//program enters an infinite loop... 
				scanner.nextLine();
			}
		//Keep prompting for an integer from minInt to maxInt.
		} while (option < minInt || option > maxInt);
				
		return option;
	}
	
	
	
	//Displays a user prompt on the console and returns the string entered by the user.
	public static String getUserInputString(Scanner scanner, String prompt) {
		
		System.out.println(prompt);
		String answer = scanner.next();
		
		return answer;
	}
	
	//Checks for either a 'y' or 'Y' from the user.  All other entries return false.
	public static boolean affirmativeResponse(Scanner scanner) {
		char response = scanner.next().charAt(0);
		if (response == 'y' || response == 'Y') {
		return true;
		} else {
			return false;
		}
	}
	
	//Displays a message on the console.
	public static void displayMessage(String message) {
		System.out.println(message);
	}
	
	//Displays a list of all the students with their marks, on the console.
	public static void displayReportByMarks(LinkedList<Student> allStudents) {
		
		System.out.println("Student Report by Marks");
		System.out.println("-----------------------");
		System.out.format("%-32s%9s%4s%4s%4s%8s%19s%4s%4s%4s%8s%n", "Name", "Math", "A1", "A2", "A3", "Avg", "English", "A1", "A2", "A3", "Avg");
		System.out.println("----------------------------------------------------------------------------------------------------");
						  
		for (Student s1 : allStudents) {
			System.out.format("%-41s%4d%4d%4d%8d%19s%4d%4d%4d%8d%n", s1.getFullName(), s1.getMathMarks().getMark(1), 
						s1.getMathMarks().getMark(2), s1.getMathMarks().getMark(3), s1.getMathMarks().getAverageMark(), " ",							
									s1.getEnglishMarks().getMark(1), s1.getEnglishMarks().getMark(2), s1.getEnglishMarks().getMark(3), 
									s1.getEnglishMarks().getAverageMark());
			}
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	//Displays a list of all the students with their grades, on the console.
	public static void displayReportByGrades(LinkedList<Student> allStudents) {
		
		
		System.out.println("Student Report by Grades");
		System.out.println("------------------------");
		System.out.format("%-32s%-9s%-4s%-4s%-4s%-16s%-10s%-4s%-4s%-4s%-8s%n", "Name", "Math", "A1", "A2", "A3", "Avg", "English", "A1", "A2", "A3", "Avg");
		System.out.println("----------------------------------------------------------------------------------------------------");
						  
		for (Student s1 : allStudents) {
			System.out.format("%-41s%-4s%-4s%-4s%-8s%-18s%-4s%-4s%-4s%-8s%n", s1.getFullName(), s1.getMathMarks().getGrade(1), 
						s1.getMathMarks().getGrade(2), s1.getMathMarks().getGrade(3), s1.getMathMarks().getAverageGrade(), " ",							
									s1.getEnglishMarks().getGrade(1), s1.getEnglishMarks().getGrade(2), s1.getEnglishMarks().getGrade(3), 
									s1.getEnglishMarks().getAverageGrade());
			}
		System.out.println("----------------------------------------------------------------------------------------------------");	
	}
	
}


