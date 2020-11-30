import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentReportSystem {
	
	private final static String FILE_PATH = "C:/Temp/studentdata.txt";
	public static LinkedList<Student> allStudents;
	
	public static void main(String[] args) {
		//Declare a LinkedList of Students
		 allStudents = new LinkedList<Student>();

		if (readFile(FILE_PATH)) {
			boolean exitProgram = false;
			while (!exitProgram) {
				//display menu
				displayMenu();
				
				//get user option
				int option = getUserOption();
				//switch on option
				switch (option) {
				case 1 : {
					displayReportByMarks();
					break;
				}
				case 2 : {
					displayReportByGrades();
					break;
				}
				case 3 : {
					addNewStudent();
					break;
				}
				case 4 : {
					removeStudent();
					break;
				}
				case 5 : {
					exitProgram = true;
					break;
				}
				default : {
					System.out.println("Invalid input, please enter an option from 1 to 5.");
					break;
				}
				}
			} 
			}else {
			System.out.println("Unable to find file at " + FILE_PATH);
		}
	}
	
	public static boolean readFile(String filename) {
		File file = new File(filename);
		
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String[] words = scanner.nextLine().split(",");
				int id = Integer.parseInt(words[0]);
				String firstName = words[1];
				String lastName = words[2];
				int mathMark1 = Integer.parseInt(words[3]);
				int mathMark2 = Integer.parseInt(words[4]);
				int mathMark3 = Integer.parseInt(words[5]);
				int englishMark1 = Integer.parseInt(words[6]);
				int englishMark2 = Integer.parseInt(words[7]);
				int englishMark3 = Integer.parseInt(words[8]);
				
				addStudent(id, firstName, lastName, 
						   mathMark1, mathMark2, mathMark3, 
						   englishMark1, englishMark2, englishMark3);
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			return false;
		}
		
		return true;
	}
	
	public static void addStudent(int id, String firstName, String lastName, 
									int mathMark1, int mathMark2, int mathMark3,
									int englishMark1, int englishMark2, int englishMark3){
		
		Student aStudent = new Student(id, firstName, lastName);
		AssignmentMarks math = new AssignmentMarks("Math", mathMark1, mathMark2, mathMark3);
		AssignmentMarks english = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);
		aStudent.mathMarks = math;
		aStudent.englishMarks = english;
		
		allStudents.add(aStudent);
		
	}
	
	
	public static void displayMenu() {
		System.out.println("Student Report System");
		System.out.println("---------------------");
		System.out.println();
		System.out.println("1) Display student marks.");
		System.out.println("2) Display student grades.");
		System.out.println("3) Add new student.");
		System.out.println("4) Remove student.");
		System.out.println("5) Exit.");
	}
	
	
	public static int getUserOption() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter an option (1 to 5) :");
		int option = scanner.nextInt();
		
		
		return option;
	}
	
	
	private static void displayReportByMarks() {
		
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
	
	
	private static void displayReportByGrades() {
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
	
	private static void addNewStudent() {
		// get student ID, name and marks from user and add new student to linked list.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter new student ID: ");
		int id = scanner.nextInt();
		
		//check for student ID duplication.
		boolean duplicateID = false;
		
		for (Student s : allStudents) {
			if(s.id == id) {
					System.out.println("Student \n" +
									s.id + " " + s.getFullName() + "\n" +
									"already exist.  Student not added.\n");
			duplicateID = true;
			}
		}
		
		if (!duplicateID) {		
			System.out.println("Enter new student first name: ");
			String firstName = scanner.next();
			System.out.println("Enter new student last name: ");
			String lastName = scanner.next();
			
			//create new student object
			Student s = new Student(id, firstName, lastName);
					
			//create new assignment mark object.  Name it Math. 
			AssignmentMarks math = new AssignmentMarks();
			math.setCourseName("Math");
			
			//get marks from user.
			int mark;
			System.out.println("Enter Math mark 1: ");
			mark = scanner.nextInt();
			math.setMark(1,  mark);
			System.out.println("Enter Math mark 2: ");
			mark = scanner.nextInt();
			math.setMark(2,  mark);
			System.out.println("Enter Math mark 3: ");
			mark = scanner.nextInt();
			math.setMark(3,  mark);
			
			//create new assignment mark object.  Name it English. 
			AssignmentMarks english = new AssignmentMarks();
			english.setCourseName("English");
			
			// get marks from user.	
			System.out.println("Enter English mark 1: ");
			mark = scanner.nextInt();
			english.setMark(1,  mark);
			System.out.println("Enter English mark 2: ");
			mark = scanner.nextInt();
			english.setMark(2,  mark);
			System.out.println("Enter English mark 3: ");
			mark = scanner.nextInt();
			english.setMark(3,  mark);
			
			// add mark assignment marks object to the new student
			s.mathMarks = math;
			s.englishMarks = english;
			
			// add the new student to the linked list
			allStudents.add(s);
		}
	}
	
	private static void removeStudent() {
		// get student ID from user.  Remove student from linked list.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Student ID :");
		
		int id = scanner.nextInt();
			
		
		if (removeThisStudent(id)) {
			System.out.println("Student " + id + " removed successfully.\n");
		} else {
			System.out.println("Student " + id + " not found.\n");
		}
	}
		
	private static boolean removeThisStudent(int id) {
		int index = -1;
			
		for (Student s : allStudents) {
			index++;
			if(s.id == id) {
				System.out.println("Are you sure you want to remove student \n" +
									s.id + " " + s.getFullName() + "? (y/n): ");
				Scanner scanner = new Scanner(System.in);
				char response = scanner.next().charAt(0);
				if (response == 'y' || response == 'Y') {
				allStudents.remove(index);
				} 
				return true;
			} 
		}
		return false;
	}
}

	

