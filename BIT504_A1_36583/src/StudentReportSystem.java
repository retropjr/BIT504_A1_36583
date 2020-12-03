import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentReportSystem {
	
	private final static String FILE_PATH = "C:/Temp/studentdata.txt";
	public static Scanner scanner = new Scanner(System.in);
	public static LinkedList<Student> allStudents;
	public final static int STUDENT_ID_MIN = 0;
	public final static int STUDENT_ID_MAX = 100000;
	
	
	public static void main(String[] args) {
		//Declare a LinkedList of Students
		 allStudents = new LinkedList<Student>();

		if (readFile(FILE_PATH)) {
			boolean exitProgram = false;
			while (!exitProgram) {
				//display menu
				consoleIO.displayMenu();
				
				//get user option
				
				int option = consoleIO.getUserInputInt(scanner, "Enter an option (1 to 5): ", 1, 5);
				//switch on option
				switch (option) {
				case 1 : {
					consoleIO.displayReportByMarks(allStudents);
					break;
				}
				case 2 : {
					consoleIO.displayReportByGrades(allStudents);
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
					scanner.close();
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
			Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNextLine()) {
				String[] words = fileScanner.nextLine().split(",");
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
			fileScanner.close();
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
	
	
	
	
	private static void addNewStudent() {
		// get student ID, name and marks from user and add new student to linked list.
		
		int id = consoleIO.getUserInputInt(scanner, "Enter new student ID (" + STUDENT_ID_MIN  + " to " + STUDENT_ID_MAX + "): ", STUDENT_ID_MIN, STUDENT_ID_MAX);
		
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
			String firstName = consoleIO.getUserInputString(scanner, "Enter new student first name: ");
			
			
			
			//******** as above, from here....
			String lastName = consoleIO.getUserInputString(scanner, "Enter new student last name: ");
			
			//create new student object
			Student s = new Student(id, firstName, lastName);
					
			//create new assignment mark object.  Name it Math. 
			AssignmentMarks math = new AssignmentMarks();
			math.setCourseName("Math");
			
			//get marks from user.
					
			math.setMark(1,  consoleIO.getUserInputInt(scanner, "Enter Math mark 1: ", 0, 100));
			math.setMark(2,  consoleIO.getUserInputInt(scanner, "Enter Math mark 2: ", 0, 100));
			math.setMark(3,  consoleIO.getUserInputInt(scanner, "Enter Math mark 3: ", 0, 100));
			
			
			//create new assignment mark object.  Name it English. 
			AssignmentMarks english = new AssignmentMarks();
			english.setCourseName("English");
			
			// get marks from user.	
			english.setMark(1,  consoleIO.getUserInputInt(scanner, "Enter English mark 1: ", 0, 100));
			english.setMark(2,  consoleIO.getUserInputInt(scanner, "Enter English mark 2: ", 0, 100));
			english.setMark(3,  consoleIO.getUserInputInt(scanner, "Enter English mark 3: ", 0, 100));
			
			
			// add mark assignment marks object to the new student
			s.mathMarks = math;
			s.englishMarks = english;
			
			// add the new student to the linked list
			allStudents.add(s);
		}
	}
	
	private static void removeStudent() {
		// get student ID from user.  Remove student from linked list.
		//Scanner scanner = new Scanner(System.in);
		
		int id = consoleIO.getUserInputInt(scanner, "Enter the Student ID (" + STUDENT_ID_MIN  + " to " + STUDENT_ID_MAX + "): ", STUDENT_ID_MIN, STUDENT_ID_MAX);
					
		
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

	

