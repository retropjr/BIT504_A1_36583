//Assignment marks are represented by the following class.
public class AssignmentMarks {
	
	//Attributes
	private String courseName;
	private int assignment1;
	private int assignment2;
	private int assignment3;
	
	//Constructors
	
	//When reading the text file.
	public AssignmentMarks(String name, int mark1, int mark2, int mark3) {
		courseName = name;
		assignment1 = mark1;
		assignment2 = mark2;
		assignment3 = mark3;
	}
	
	//When getting user input.
	public AssignmentMarks() {
	}

	//Getter methods
	public String getCourseName() {
		return courseName;
	}
	
	//Given an assignment number, returns the mark obtained.
	public int getMark(int assignmentNumber) {
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
	
	//Returns the average mark of all assignments.
	public int getAverageMark() {
		int averageMark;
		
		averageMark = (( assignment1 +  assignment2 + assignment3) / 3);
		
		return averageMark;
	}
	
	//Returns the grade for an assignment.
	public String getGrade(int assignmentNumber) {
		//Gets the mark for the assignment and converts this to a grade by calling markToGrade method, see below.
		String grade = markToGrade(getMark(assignmentNumber));
		
		return grade;
	}
	
	//Returns the average grade of all the assignments.
	public String getAverageGrade() {
		//Gets the average mark for all the assignments and converts this to a grade by calling markToGrade, see below. 
		String grade = markToGrade(getAverageMark());
		
		return grade;
	}
	
	
	
	
	//Setter methods
	public void setCourseName(String name) {
		courseName = name;
	}
	
	public void setMark(int assignmentNumber, int mark) {
		//Sets the mark obtained for the assignment.
		if (assignmentNumber == 1) {
			assignment1 = mark;
		} else if (assignmentNumber == 2) {
			assignment2 = mark;
		} else if (assignmentNumber == 3) {
			assignment3 = mark;
		}
		
	}
	
	//Other methods
	
	//Takes a mark and converts it to a letter grade.
	private static String markToGrade(int mark) {
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