package com.student.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentID;
	private List<String> courses; // Please remember that a List is an interface therefore can't be instantiated
	// However, we can create an object of the class that implement a1 list which is
	// an Arraylist
	private boolean isStudentDataValid = true;

	public Student(String name, int age, String studentID) {
		super();
		courses = new ArrayList<String>();
		if (validateAge(age) && validateName(name) && validateStudentID(studentID)) {
			this.name = name;
			this.age = age;
			this.studentID = studentID;
		} else {
			isStudentDataValid = false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentID() {
		return studentID;
	}

	public void enrollCourse(String course) {
		String capitalizedCourse = Pattern.compile("^.").matcher(course).replaceFirst(m -> m.group().toUpperCase());
		if (isStudentDataValid) {
			if (validateCourseName(capitalizedCourse)) {

				if (!courses.contains(capitalizedCourse)) {

					courses.add(capitalizedCourse);
					System.out.println("*********** " + name + " is enrolled in " + capitalizedCourse
							+ " Successfully!! ***********");
				} else {
					System.out.println("Student already enrolled in " + capitalizedCourse + " .");
				}
			}

		} else {
			System.out.println("Enrollment failed. Invalid student information!!");
		}
	}

	public void printStudentInfo() {
		if (isStudentDataValid) {

			System.out.println("******** Student information ********");
			System.out.println(" Student name: " + name);
			System.out.println(" Student age: " + age);
			System.out.println(" Student Id: " + studentID);
			System.out.println("Enrolled for " + courses);
		} else {
			System.out.println("No data is available for this student " + ".");
		}
	}

	// Let us validate the creation of objects by constructor

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {

			System.err.println("Invalid age, student age must be between 19 and 35 years!!!");
			return false;
		}
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println(" Invalid name!!! Please enter alphabets only");
			return false;
		}
	}

	public boolean validateStudentID(String studentID) {
		String studentIDRegex = "s-[0-9]+$";
		Pattern studentIDPattern = Pattern.compile(studentIDRegex);
		Matcher studentIDMatcher = studentIDPattern.matcher(studentID);
		if (studentIDMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid studentID!!! please enter this pattern: s-123");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DevOps") || course.equalsIgnoreCase("Python")
				|| course.equalsIgnoreCase("Data Science") || course.equalsIgnoreCase("Dsa")) {
			return true;

		} else {
			System.err.println(
					"Invalid course entered!! Please select a course from the list[Java, Python, Devops, Data science]");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentID=" + studentID + ", courses=" + courses + "]";
	}
}
