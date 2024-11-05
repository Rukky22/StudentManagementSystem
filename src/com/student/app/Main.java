package com.student.app;

public class Main {

	public static void main(String[] args) {
		System.out.println("******************* Student Management System *******************");
		System.out.println("******************* Welcome *******************");

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

		Student s3 = new Student("Akpos Godstime", 30, "s-133");
		s3.enrollCourse("Java for developers 101");
		s3.enrollCourse("Devops processes");
		s3.enrollCourse("Data sciences");
		s3.enrollCourse("Data sciences");

		System.out.println(s3);
		;

	}

}
