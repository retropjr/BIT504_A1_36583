import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentReportSystem {
	
	private final static String FILE_PATH = "C:/Temp/studentdata.txt";
	public static LinkedList<Student> allStudents;
	
	public static class AssignmentMarks {
		
		//attributes
		private String courseName;
		private int assignment1;
		private int assignment2;
		private int assignment3;
		
		//constructor
		public AssignmentMarks(String name, int mark1, int mark2, int mark3) {
			this.courseName = name;
			this.assignment1 = mark1;
			this.assignment2 = mark2;
			this.assignment3 = mark3;
		}
		
		//getter methods
		public String getCourseName() {
			return courseName;
		}
		
		public int getMark(int assignmentNumber) {
			//returns the mark for an assignment
			int mark = -1;
			
			if (assignmentNumber == 1) {
				mark = assignment1;
			} else if (assignmentNumber == 2) {
				mark = assignment2;
			} else if (assignmentNumber == 3) {
				mark = assignment3;
			}
			return mark;
		}
		
		public int getAverageMark() {
			int averageMark;
			
			averageMark = (( assignment1 + assignment2 + assignment3) / 3);
			
			return averageMark;
		}
		
		public String getGrade(int assignmentNumber) {
			String grade = markToGrade(getMark(assignmentNumber));
			
			return grade;
		}
		
		public String getAverageGrade() {
			String grade = markToGrade(getAverageMark());
			
			return grade;
		}
		
		
		
		
		//setter methods
		
		public void setCourseName(String name) {
			courseName = name;
		}
		
		public void setMark(int assignmentNumber, int mark) {
			//used to set the value of the assignment.
			if (assignmentNumber == 1) {
				assignment1 = mark;
			} else if (assignmentNumber == 2) {
				assignment2 = mark;
			} else if (assignmentNumber == 3) {
				assignment3 = mark;
			}
			
		}
		
		//other methods
		private String markToGrade(int mark) {
			String grade = null;
			
			if (mark >= 0 && mark <= 39) {
				grade = "D";
			} else if (mark >= 40 && mark <= 49) {
				grade = "C-";
			} else if (mark >= 50 && mark <= 59) {
				grade = "C";
			} else if (mark >= 60 && mark <= 69) {
				grade = "C+";
			} else if (mark >= 70 && mark <= 74) {
				grade = "B-";
			} else if (mark >= 75 && mark <= 79) {
				grade = "B";
			} else if (mark >= 80 && mark <= 84) {
				grade = "B+";
			} else if (mark >= 85 && mark <= 89) {
				grade = "A-";
			} else if (mark >= 90 && mark <= 94) {
				grade = "A";
			} else if (mark >= 95 && mark <= 100) {
				grade = "A+";
			}
			return grade;
		}
		
	}
	
	public static class Student {
		//attributes
		private int id;
		private String firstName;
		private String lastName;
		private AssignmentMarks mathMarks;
		private AssignmentMarks englishMarks;
		
		//constructor
		public Student(int id, String firstName, String lastName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}
			
		//getter methods
		public String getFullName(){
			String fullName = firstName + " " + lastName;
			
			return fullName;
		}
			
		//setter methods
			
		//other methods
		
	}
	
	

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
		System.out.println("Name\t\t Math\t A1\t A2\t A3\t Math average\t English\t A1\t A2\t A3\t  English average");
		System.out.println("-----------------------------------------------------------------------------------------"
						  + "------------------------------------------------");
		
		for (Student s : allStudents) {
			System.out.println(s.getFullName() + "\t\t " + s.mathMarks.getGrade(1) + "\t " + s.mathMarks.getGrade(2) + "\t " +
								s.mathMarks.getGrade(3) + "\t      " + s.mathMarks.getAverageGrade() + "\t\t\t " +
								s.englishMarks.getGrade(1) + "\t " + s.englishMarks.getGrade(2) + "\t " + 
								s.englishMarks.getGrade(3) + "\t         " + s.englishMarks.getAverageGrade());
			System.out.println();
		}
	}
	
	private static void addNewStudent() {
		// get student ID, name and marks from user and add new student to linked list.
	}
	
	private static void	removeStudent() {
		// get student ID from user.  Remove student from linked list.
	}
	
}
