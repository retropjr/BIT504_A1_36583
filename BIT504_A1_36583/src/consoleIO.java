import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class consoleIO {
	
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
	
	
	public static int getUserInputInt(Scanner scanner, String prompt, int minInt, int maxInt) {
		
		int option = -1;
		
		do {
			System.out.println(prompt);
			try {
				option = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.err.println("Please enter an integer number.");
				scanner.nextLine();
			}
		} while (option < minInt || option > maxInt);
				
		return option;
	}
	
	
	
	
	public static String getUserInputString(Scanner scanner, String prompt) {
		
		System.out.println(prompt);
		String answer = scanner.next();
		
		return answer;
	}
	
	public static boolean affirmativeResponse(Scanner scanner) {
		char response = scanner.next().charAt(0);
		if (response == 'y' || response == 'Y') {
		return true;
		} else {
			return false;
		}
	}
	
	public static void displayMessage(String message) {
		System.out.println(message);
	}
	
	
	public static void displayReportByMarks(LinkedList<Student> allStudents) {
		
		System.out.println("Name\t\t Math\t A1\t A2\t A3\t Math average\t English\t A1\t A2\t A3\t  English average");
		System.out.println("-----------------------------------------------------------------------------------------"
						  + "------------------------------------------------");
		
		for (Student s : allStudents) {
			System.out.println(s.getFullName() + "\t\t " + s.mathMarks.getMark(1) + "\t " + s.mathMarks.getMark(2) + "\t " +
								s.mathMarks.getMark(3) + "\t      " + s.mathMarks.getAverageMark() + "\t\t\t " +
								s.englishMarks.getMark(1) + "\t " + s.englishMarks.getMark(2) + "\t " + 
								s.englishMarks.getMark(3) + "\t         " + s.englishMarks.getAverageMark());
			System.out.println();
		}
	}
	
	
	public static void displayReportByGrades(LinkedList<Student> allStudents) {
		System.out.println("Name\t\t Math\t A1 \t A2 \t A3 \t Math average\t\t English\t A1 \t A2 \t A3 \t  English average");
		System.out.println("-----------------------------------------------------------------------------------------"
						  + "------------------------------------------------");
		
		for (Student s : allStudents) {
			System.out.println(s.getFullName() + "\t\t " + s.mathMarks.getGrade(1) + "\t " + s.mathMarks.getGrade(2) + "\t " +
								s.mathMarks.getGrade(3) + "\t      " + s.mathMarks.getAverageGrade() + "    \t\t\t\t " +
								s.englishMarks.getGrade(1) + "\t " + s.englishMarks.getGrade(2) + "\t " + 
								s.englishMarks.getGrade(3) + "\t         " + s.englishMarks.getAverageGrade());
			System.out.println();
		}
	}
	
}


