
public class AssignmentMarks {
	
	//attributes
	private String courseName;
	private int assignment1;
	private int assignment2;
	private int assignment3;
	
	//constructor
	public AssignmentMarks(String name, int mark1, int mark2, int mark3) {
		courseName = name;
		assignment1 = mark1;
		assignment2 = mark2;
		assignment3 = mark3;
	}
	
	public AssignmentMarks() {
		// TODO Auto-generated constructor stub
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