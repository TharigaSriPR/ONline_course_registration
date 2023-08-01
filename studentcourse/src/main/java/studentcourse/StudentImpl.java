package studentcourse;

public class StudentImpl extends Student{
	
	private int studentId;
	private String studentName;
    private int courseId;

	
    public StudentImpl() {
		
	}

	public StudentImpl(int studentId, String studentName, int courseId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public void studentdetials() {
		// TODO Auto-generated method stub
		
	}
    
	
}
