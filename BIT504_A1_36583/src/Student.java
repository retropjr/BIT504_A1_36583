
//Students are represented by the following class.  
public class Student {
		//Attributes
		private int id;
		private String firstName;
		private String lastName;
		private AssignmentMarks mathMarks; 
		private AssignmentMarks englishMarks;
		
		//Constructor
		public Student(int id, String firstName, String lastName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		//Getter methods
		public int getID() {
			return id;
		}
		
		public String getFullName(){
			String fullName = firstName + " " + lastName;
			
			return fullName;
		}
		
		public AssignmentMarks getMathMarks() {
			return mathMarks;
		}
		
		public AssignmentMarks getEnglishMarks() {
			return englishMarks;
		}
		
		//Setter methods
		public void setMathMarks(AssignmentMarks subject) {
			mathMarks = subject;
		}
		
		public void setEnglishMarks(AssignmentMarks subject) {
			englishMarks = subject;
		}
		
	}
