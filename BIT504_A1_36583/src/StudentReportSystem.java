import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

//A console application that manages a student database.
//The Open Polytechnic of New Zealand BIT504 Assignment 1 submitted by Richard Porter 36583.
public class StudentReportSystem {
	
	//The location of the text file containing the student details.
	private final static String FILE_PATH = "C:/Temp/studentdata.txt";
	//Declaration of the Scanner object.  Closed at program exit.
	public static Scanner scanner = new Scanner(System.in);
	//A linked list of students.  The students from the text file are added on program start up. Users can add
	//and remove students from this list.  The text file is not modified.  In effect the text file is read only.
	public static LinkedList<Student> allStudents;
	//Student ID have been arbitrarily defined as any unique integer in the range 0 to 100000.  Can be modified here...
	public final static int STUDENT_ID_MIN = 0;	
	public final static int STUDENT_ID_MAX = 100000;
	
	
	public static void main(String[] args) {
		//Program entry point.
		//Declare the linked list of Students.
		 allStudents = new LinkedList<Student>();
		
		//Read the text file.  If the text file can't be found give the user a message.
		if (readFile(FILE_PATH)) {
			//Program runs until user enters 5.  As per the menu.  On entering 5, exitProgram becomes true.
			boolean exitProgram = false;
			while (!exitProgram) {
				//See the consoleIO Class for explanation of the console output/input methods.
				
				//Display menu
				consoleIO.displayMenu();
				
				//Get user option
				int option = consoleIO.getUserInputInt(scanner, "Enter an option (1 to 5): ", 1, 5);
				
				//Switch on user option
				switch (option) {
				case 1 : {
					//Display a report of all the student results by mark.
					consoleIO.displayReportByMarks(allStudents);
					break;
				}
				case 2 : {
					//Display a report of all student results by grade.
					consoleIO.displayReportByGrades(allStudents);
					break;
				}
				case 3 : {
					//Add a new student to the linked list.
					addNewStudent();
					break;
				}
				case 4 : {
					//Remove a student from the linked list.
					removeStudent();
					break;
				}
				case 5 : {
					//End the program, closing the Scanner.
					exitProgram = true;
					consoleIO.displayMessage("*** Student Report System has been exited. ***");
					scanner.close();
					break;
				}
				default : {
					//Handle the case of a user entering something other than integer from 1 to 5.
					consoleIO.displayMessage("Invalid input, please enter an option (1 to 5): ");
					break;
				}
				}
			} 
			}else {
			//Text file containing the student details coudn't be found.  Advise the user.
			consoleIO.displayMessage("Unable to find file at " + FILE_PATH);
		}
	}
	
	
	//Read the text file.
	public static boolean readFile(String filename) {
		File file = new File(filename);
		
		try {
			Scanner fileScanner = new Scanner(file);
			
			//Read each line in the text file and add the details to the linked list.
			while (fileScanner.hasNextLine()) {
				//The file is comma delimited. 
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
				
				//Add the student details received from the text file to the linked list.
				addStudent(id, firstName, lastName, 
						   mathMark1, mathMark2, mathMark3, 
						   englishMark1, englishMark2, englishMark3);
				
				//Go to start of loop and try to read the next line from the text file.	
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			return false;
		}
		
		return true;
	}
	
	
	//Adds the student details read from the text file to the linked list.
	public static void addStudent(int id, String firstName, String lastName, 
									int mathMark1, int mathMark2, int mathMark3,
									int englishMark1, int englishMark2, int englishMark3){
		
		Student aStudent = new Student(id, firstName, lastName);
		AssignmentMarks math = new AssignmentMarks("Math", mathMark1, mathMark2, mathMark3);
		AssignmentMarks english = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);
		aStudent.setMathMarks(math);
		aStudent.setEnglishMarks(english);
		
		allStudents.add(aStudent);
	}
	
	
	
	//Adds the student details entered by the user to the linked list.
	private static void addNewStudent() {
		
		//Get student ID, name and marks from user and add new student to linked list.
		int id = consoleIO.getUserInputInt(scanner, "Enter new student ID (" + STUDENT_ID_MIN  + " to " + STUDENT_ID_MAX + "): ", STUDENT_ID_MIN, STUDENT_ID_MAX);
		
		//Check for student ID duplication.  Student ID has to be an unique integer.
		boolean duplicateID = false;
		
		for (Student s : allStudents) {
			if(s.getID() == id) {
					System.out.println("Student " + s.getID() + " " + s.getFullName()  + " already exist.  Student not added.\n");
			duplicateID = true;
			}
		}
		
		//If the student ID is valid get the student first and last names.
		if (!duplicateID) {		
			String firstName = consoleIO.getUserInputString(scanner, "Enter new student first name: ");
			String lastName = consoleIO.getUserInputString(scanner, "Enter new student last name: ");
			
			//Create a new student object
			Student s = new Student(id, firstName, lastName);
					
			//Create new assignment mark object.  Name it Math.  
			AssignmentMarks math = new AssignmentMarks();
			math.setCourseName("Math");
			
			//Get Math marks from user.		
			math.setMark(1,  consoleIO.getUserInputInt(scanner, "Enter Math mark 1: ", 0, 100));
			math.setMark(2,  consoleIO.getUserInputInt(scanner, "Enter Math mark 2: ", 0, 100));
			math.setMark(3,  consoleIO.getUserInputInt(scanner, "Enter Math mark 3: ", 0, 100));
			
			//Create new assignment mark object.  Name it English. 
			AssignmentMarks english = new AssignmentMarks();
			english.setCourseName("English");
			
			//Get English marks from user.	
			english.setMark(1,  consoleIO.getUserInputInt(scanner, "Enter English mark 1: ", 0, 100));
			english.setMark(2,  consoleIO.getUserInputInt(scanner, "Enter English mark 2: ", 0, 100));
			english.setMark(3,  consoleIO.getUserInputInt(scanner, "Enter English mark 3: ", 0, 100));
			
			//Add both assignment mark objects to the new student object.
			s.setMathMarks(math);
			s.setEnglishMarks(english);
			
			//Add the new student to the linked list
			allStudents.add(s);
		}
	}
	
	//Get the student ID of the student to be removed.  Calls the removeThisStudent method.
	private static void removeStudent() {
		
		//Get student ID from user. 
		int id = consoleIO.getUserInputInt(scanner, "Enter the Student ID (" + STUDENT_ID_MIN  + " to " + STUDENT_ID_MAX + "): " ,STUDENT_ID_MIN, STUDENT_ID_MAX);
		
		//Calls the method to remove the student from the linked list.  If the student is not in the linked list, let the user know.
		if (!removeThisStudent(id)) {
			consoleIO.displayMessage("Student " + id + " not found.\n");
		}
	}
	
	//Removes the student from the linked list.  After checking that the user is sure they want to remove the student.
	private static boolean removeThisStudent(int id) {
		int index = -1;
		
		//Starts at the beginning of the list and steps through it looking for the student ID.
		for (Student s : allStudents) {
			//A linked list index starts at 0.
			index++;
			if(s.getID() == id) {
				//Check that user really wants to remove the student.  Provide them with the student's full name to help them decide.
				consoleIO.displayMessage("Are you sure you want to remove student \n" +	s.getID() + " " + s.getFullName() + "? (y/n): ");
				if (consoleIO.affirmativeResponse(scanner)) {
				//Note that index is not the same as ID.  i.e. Index 0 could contain any ID from STUDENT_ID_MIN to STUDENT_ID_MAX.
				allStudents.remove(index);
				consoleIO.displayMessage("Student " + id + " removed successfully.\n");
				return true;
				} else {
					//User didn't really want to remove the student.
					consoleIO.displayMessage("Student " + id + " not removed.\n");
					return true;
				}
			} 
		}
		return false;
	}
}

	

