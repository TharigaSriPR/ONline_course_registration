package studentcourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CourseDAO {
	public List<Course> getAllCourses() throws ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM courses";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("courseId"));
                course.setCourseName(resultSet.getString("courseName"));
                course.setInstructorName(resultSet.getString("instructorName"));
                course.setMaxStudents(resultSet.getInt("maxStudents"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
	public void addCourse(Course course) throws ClassNotFoundException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO courses (courseName, instructorName, maxStudents) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setString(2, course.getInstructorName());
            preparedStatement.setInt(3, course.getMaxStudents());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(Course course) throws ClassNotFoundException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE courses SET courseName = ?, instructorName = ?, maxStudents = ? WHERE courseId = ?")) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setString(2, course.getInstructorName());
            preparedStatement.setInt(3, course.getMaxStudents());
            preparedStatement.setInt(4, course.getCourseId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int courseId) throws ClassNotFoundException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM courses WHERE courseId = ?")) {
            preparedStatement.setInt(1, courseId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public Course getCourseById(int courseId) throws ClassNotFoundException {
		
	        Course course = null;
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM courses WHERE courseId = ?")) {
	            preparedStatement.setInt(1, courseId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                course = new Course();
	                course.setCourseId(resultSet.getInt("courseId"));
	                course.setCourseName(resultSet.getString("courseName"));
	                course.setInstructorName(resultSet.getString("instructorName"));
	                course.setMaxStudents(resultSet.getInt("maxStudents"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return course;
	    }


}


