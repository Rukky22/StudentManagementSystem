package com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentList;
	static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("******************* Student Management System *******************");

		studentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);
		System.out.println();
		while (true) {
			System.out.println("******************* Welcome *******************");
			System.out.println("Please select an option from 1 to 5");
			System.out.println("1. Registration a student");
			System.out.println("2. Find a student with studentID");
			System.out.println("3. List all student information");
			System.out.println("4. List student information in sorted order");
			System.out.println("5. Exit");
			int option = getValidIntegerFromConsole(scanner);

			switch (option) {
			case 1:
				enrollStudent(scanner);

				break;
			case 2:
				findStudentById(scanner);
				break;

			case 3:
				printAllStudentData(scanner);
				break;

			case 4:
				printAllStudentDataInSortedOrder(scanner);
				break;

			case 5:
				exitTheProgram(scanner);
				break;

			default:
				System.out.println("Invalid option! Please option from 1 to 5");
				break;
			}
		}

	}

	public static int getValidIntegerFromConsole(Scanner scanner2) {
		while (true) {
			try {
				return scanner2.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input!! Please enter an Integer only!!");
				scanner2.next();
			}
		}

	}

	private static void exitTheProgram(Scanner scanner2) {
		System.out.println("Good bye friend!!");
		System.exit(0);

	}

	private static void printAllStudentDataInSortedOrder(Scanner scanner2) {
		sortStudentByName();
	}

	private static void printAllStudentData(Scanner scanner2) {
		System.out.println("*************** Printing Student Info ***************");
		if (studentList.size() > 0) {

			for (Student student : studentList) {
				student.printStudentInfo();
			}

			System.out.println("---------------------------------------------------");
		} else {
			System.err.println("Student list is empty!! No student record found.");
		}

	}

	private static void findStudentById(Scanner scanner2) {
		Student studentFound = null;
		System.out.println("Please enter student ID: ");
		String studentID = scanner2.next();
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentID().equalsIgnoreCase(studentID))
					.findFirst().orElseThrow(() -> new RuntimeException("No student data found!!"));

		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentID + "" + " is not In the list!!");
		}
		System.out.println(studentFound);

	}

	private static void enrollStudent(Scanner scanner2) {
		System.out.println("Enter student name: ");
		String studentName = scanner.next();

		System.out.println("Enter student age: ");
		int age = scanner.nextInt();

		System.out.println("Enter student Id: ");
		String studentID = scanner.next();

		Student newStudent = new Student(studentName, age, studentID);
		studentList.add(newStudent);
		String studentCourse;

		while (true) {
			System.out.println("Enter course to enrol or Done to exit ...... ");
			studentCourse = scanner.next();
			if (studentCourse.equalsIgnoreCase("Done")) {
				break;// Enter done to quit
			}
			newStudent.enrollCourse(studentCourse);
		}
		newStudent.printStudentInfo();
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
