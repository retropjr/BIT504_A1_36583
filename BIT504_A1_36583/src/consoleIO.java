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
		
		int option;
		
		do {
		System.out.println(prompt);
		option = scanner.nextInt();
		} while (option < minInt || option > maxInt);
		
		return option;
	}
	
	public static String getUserInputString(Scanner scanner, String prompt) {
		
		System.out.println(prompt);
		String answer = scanner.next();
		
		return answer;
	}
	
	
	public static void displayReportByMarks(LinkedList<Student> allStudents) {
		
		System.out.println("Name\t\t Math\t A1\t A2\t A3\t Math average\t English\t A1\t A2\t A3\t  English average");
		System.out.println("-----------------------------------------------------------------------------------------"
						  + "------------------------------------------------");
		
		for (Student s : allStudents) {
			System.out.println(s.getFullName() + "\t\t " + s.mathMarks.assignment1 + "\t " + s.mathMarks.assignment2 + "\t " +
								s.mathMarks.assignment3 + "\t      " + s.mathMarks.getAverageMark() + "\t\t\t " +
								s.englishMarks.assignment1 + "\t " + s.englishMarks.assignment2 + "\t " + 
								s.englishMarks.assignment3 + "\t         " + s.englishMarks.getAverageMark());
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


