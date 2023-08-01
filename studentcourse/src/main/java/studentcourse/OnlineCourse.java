package studentcourse;

public class OnlineCourse extends Course{
	private String platform;

    

    



	public OnlineCourse() {
		super();

	}







	public OnlineCourse(int courseId, String courseName, String instructorName, int maxStudents, int currentStudents,
			String schedule) {
		super(courseId, courseName, instructorName, maxStudents, currentStudents, schedule);
	
	}







	public OnlineCourse(String platform) {
		super();
		this.platform = platform;
	}







	public String getPlatform() {
		return platform;
	}







	public void setPlatform(String platform) {
		this.platform = platform;
	}







	@Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("  Platform: " + platform);
    }
}
