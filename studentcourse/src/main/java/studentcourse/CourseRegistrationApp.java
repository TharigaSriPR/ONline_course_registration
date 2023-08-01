package studentcourse;

import java.util.List;
import java.util.Scanner;
public class CourseRegistrationApp {

	    private static final Scanner scanner = new Scanner(System.in);
	    private static final CourseDAO courseDAO = new CourseDAO();
	    private static final StudentDAO studentDAO = new StudentDAO();

	    public static void main(String[] args) throws ClassNotFoundException {
	        showMenu();
	    }

	    private static void showMenu() throws ClassNotFoundException {
	        while (true) {
	            System.out.println("\n==== Course Registration System ====");
	            System.out.println("1. View All Courses");
	            System.out.println("2. View All Students");
	            System.out.println("3. Add New Course");
	            System.out.println("4. Update Course");
	            System.out.println("5. Register Student");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                    viewAllCourses();
	                    break;
	                case 2:
	                    viewAllStudents();
	                    break;
	                case 3:
	                    addNewCourse();
	                    break;
	                case 4:
	                    updateCourse();
	                    break;
	                case 5:
	                    registerStudent();
	                    break;
	                case 6:
	                    System.out.println("Exiting the application. Goodbye!");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void viewAllCourses() throws ClassNotFoundException {
	        List<Course> courses = courseDAO.getAllCourses();
	        System.out.println("\n==== All Courses ====");
	        for (Course course : courses) {
	            course.displayCourseDetails(); 
	            System.out.println(); 
	        }
	    }

	    private static void viewAllStudents() throws ClassNotFoundException {
	        List<Student> students = studentDAO.getAllStudents();
	        System.out.println("\n==== All Students ====");
	        for (Student student : students) {
	            System.out.println(student);
	        }
	    }

	    private static void addNewCourse() throws ClassNotFoundException {
	        System.out.println("\n==== Add New Course ====");
	
	        RegularCourse newCourse = new RegularCourse();

	        System.out.print("Enter Course Name: ");
	        newCourse.setCourseName(scanner.nextLine());

	        System.out.print("Enter Instructor Name: ");
	        newCourse.setInstructorName(scanner.nextLine());

	        System.out.print("Enter Max Students: ");
	        newCourse.setMaxStudents(scanner.nextInt());
	        scanner.nextLine(); 

	        System.out.print("Enter Schedule: ");
	        newCourse.setSchedule(scanner.nextLine());

	        newCourse.setCurrentStudents(0); 

	        courseDAO.addCourse(newCourse);
	        System.out.println("Course added successfully!");
	    }

	    private static void updateCourse() throws ClassNotFoundException {
	        System.out.println("\n==== Update Course ====");
	       
	        System.out.print("Enter Course ID to update: ");
	        int courseId = scanner.nextInt();
	        scanner.nextLine(); 

	        Course existingCourse = courseDAO.getCourseById(courseId);
	        if (existingCourse == null) {
	            System.out.println("Course with ID " + courseId + " not found.");
	            return;
	        }

	        
	        System.out.print("Enter Updated Course Name: ");
	        existingCourse.setCourseName(scanner.nextLine());

	        System.out.print("Enter Updated Instructor Name: ");
	        existingCourse.setInstructorName(scanner.nextLine());

	        System.out.print("Enter Updated Max Students: ");
	        existingCourse.setMaxStudents(scanner.nextInt());
	        scanner.nextLine(); 

	        courseDAO.updateCourse(existingCourse);
	        System.out.println("Course updated successfully!");
	    }

	    private static void registerStudent() throws ClassNotFoundException {
	        System.out.println("\n==== Register Student ====");
	       
	        StudentImpl newStudent = new StudentImpl();

	        System.out.print("Enter Student Name: ");
	        newStudent.setStudentName(scanner.nextLine());

	        System.out.print("Enter Course ID to register for: ");
	        int courseId = scanner.nextInt();
	        scanner.nextLine(); 

	   
	        Course course = courseDAO.getCourseById(courseId);
	        if (course == null) {
	            System.out.println("Course with ID " + courseId + " not found.");
	            return;
	        }

	        if (course.getCurrentStudents() >= course.getMaxStudents()) {
	            System.out.println("Course is already full. Cannot register for this course.");
	            return;
	        }


	        course.setCurrentStudents(course.getCurrentStudents() + 1);

	     
	        courseDAO.updateCourse(course);

	        newStudent.setCourseId(courseId);
	        studentDAO.addStudent(newStudent);
	        System.out.println("Student registered successfully for the course!");
	    }
	}





