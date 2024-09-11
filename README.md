# VirtualClassroomManager

**Mini-Project**
Virtual Classroom Manager is a terminal-based application designed to facilitate classroom management. It allows users to add classrooms, enroll students, schedule and submit assignments, and view classroom details. This project demonstrates fundamental concepts of object-oriented programming and data management in Java. It is in MVC design pattern

## Table of Contents

**Features:**

- **Add Classroom:** Create new classrooms.
- **Add Student:** Enroll students in a classroom.
- **Schedule Assignment:** Schedule assignments for a class.
- **Submit Assignment:** Submit assignments for students.
- **List Classrooms:** View a list of all classrooms.
- **View Classroom Details:** View details of a specific classroom.
- **Help:** Displays a list of available commands.
- **Exit:** Close the application.

**Commands:**

- add_classroom [class name] - Adds a new classroom.
- add_student [student ID] [student name] [class name] - Enrolls a student in a classroom.
- schedule_assignment [class name] [assignment details] - Schedules an assignment.
- submit_assignment [student ID] [class name] [assignment details] - Submits an assignment.
- list_classrooms - Lists all classrooms.
- view_classroom [class name] - Views details of a specific classroom.
- help - Displays the list of available commands.
- exit - Exits the application.

## Compilation

To compile the Java files, you need to have Java Development Kit (JDK) installed. You can download the JDK from the official Oracle website or use a package manager for your operating system.

Once JDK is installed, follow these steps to compile the files:

Open a terminal or command prompt

Navigate to the directory containing the Java files:
- cd /path/to/src

Compile the Java files using the javac command:
- javac *.java

**Ensure that (*) is been placed before .java**

Run the Java files using java command:
- java VirtualClassroomManager

Make sure to replace /path/to/src with the actual path to your src directory.
