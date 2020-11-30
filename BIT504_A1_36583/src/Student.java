public class Student {
		//attributes
		public int id;
		public String firstName;
		public String lastName;
		AssignmentMarks mathMarks;
		AssignmentMarks englishMarks;
		
		//constructor
		public Student(int id, String firstName, String lastName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}
			
		public Student() {
			// TODO Auto-generated constructor stub
		}

		//getter methods
		public String getFullName(){
			String fullName = firstName + " " + lastName;
			
			return fullName;
		}
			
		//setter methods
		public void setFirstName(String name) {
			firstName = name;
		}

	
			
		//other methods
		
	}
