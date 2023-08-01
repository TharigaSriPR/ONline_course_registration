package studentcourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {
	    public List<Student> getAllStudents() throws ClassNotFoundException {
	        List<Student> students = new ArrayList<>();
	        try (Connection connection = DBUtil.getConnection();
	             Statement statement = connection.createStatement()) {
	            String query = "SELECT * FROM students";
	            ResultSet resultSet = statement.executeQuery(query);
	            while (resultSet.next()) {
	                int studentId = resultSet.getInt("studentId");
	                String studentName = resultSet.getString("studentName");
	                int courseId = resultSet.getInt("courseId");

	                // Assuming you have a StudentImpl constructor that takes studentId, studentName, and courseId
	                StudentImpl student = new StudentImpl(studentId, studentName, courseId);
	                
	                students.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return students;
	    }

	    public void addStudent(StudentImpl student) throws ClassNotFoundException {
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (studentName, courseId) VALUES (?, ?)")) {
	            preparedStatement.setString(1, student.getStudentName());
	            preparedStatement.setInt(2, student.getCourseId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public void updateStudent(StudentImpl student) throws ClassNotFoundException {
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET studentName = ?, courseId = ? WHERE studentId = ?")) {
	            preparedStatement.setString(1, student.getStudentName());
	            preparedStatement.setInt(2, student.getCourseId());
	            preparedStatement.setInt(3, student.getStudentId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteStudent(int studentId) throws ClassNotFoundException {
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE studentId = ?")) {
	            preparedStatement.setInt(1, studentId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
}
}







