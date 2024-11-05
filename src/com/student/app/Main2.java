package com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("******************* Student Management System *******************");
		System.out.println("******************* Welcome *******************");

		studentList = new ArrayList<Student>();
		Student s1 = new Student("Dafe Akpan Vincent", 21, "s-34");
		s1.enrollCourse("Java");
		s1.enrollCourse("Python");
		s1.enrollCourse("Data science");
		s1.enrollCourse("Data science");
		s1.enrollCourse("Data science");

		System.out.println(s1);

		System.out.println();

		Student s2 = new Student("Kelvin", 27, "s-02");
		s2.enrollCourse("Dsa");
		s2.enrollCourse("Computer 101");
		s2.enrollCourse("Data science");

		s2.printStudentInfo();
		System.out.println();

		Student s3 = new Student("Akpos Godstime", 30, "s-13");
		s3.enrollCourse("Java");
		s3.enrollCourse("Devops processes");
		s3.enrollCourse("Data science");
		s3.enrollCourse("Data science");

		System.out.println(s3);

		Student s4 = new Student("Debora", 19, "s-134");
		s4.enrollCourse("Java for developers 101");
		s4.enrollCourse("Devops processes");
		s4.enrollCourse("Data science");
		s4.enrollCourse("Data science");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);

		Student student1 = findStudentById("s-02");
		System.out.println("Result " + student1);
		sortStudentByName();

	}

	public static void sortStudentByName() {
//		Comparator<Student> studentNameComparator = new Comparator<Student>() {
//
//			@Override
//			public int compare(Student o1, Student o2) {
//
//				return o1.getName().compareTo(o2.getName());
//			}
//		};
//		Collections.sort(studentList, studentNameComparator);
//		System.out.println(studentList);

		// We can still implement the sortStudentByName method via a lambda function
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);

	}

	public static Student findStudentById(String studentID) {
		Student student = null;
		try {
			student = studentList.stream().filter(x -> x.getStudentID().equalsIgnoreCase(studentID)).findFirst()
					.orElseThrow(() -> new RuntimeException("No student data found!!"));

		} catch (RuntimeException e) {
			System.out.println("Student with ID " + studentID + "" + " is not In the list!!");
		}
		return student;
	}

}
