package studentcourse;

public class RegularCourse extends Course{
	public RegularCourse() {
		super();
		// TODO Auto-generated constructor stub
	}






	public RegularCourse(int courseId, String courseName, String instructorName, int maxStudents, int currentStudents,
			String schedule) {
		super(courseId, courseName, instructorName, maxStudents, currentStudents, schedule);
		// TODO Auto-generated constructor stub
	}






	public RegularCourse(String schedule) {
		super();
		this.schedule = schedule;
	}






	public String getSchedule() {
		return schedule;
	}






	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}






	private String schedule;



   


	@Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("  Schedule: " + schedule);
    }
}
