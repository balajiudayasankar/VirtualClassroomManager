package controller;

import model.Assignment;
import model.Classroom;
import model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The ClassroomController class manages a collection of classrooms, allowing operations
 * such as adding classrooms, enrolling students, scheduling assignments, submitting assignments,
 * listing classrooms, and viewing classroom details.
 */
public class ClassroomController {
    // Logger instance to record application events and issues
    private static final Logger logger = Logger.getLogger(ClassroomController.class.getName());
    
    // Map to store classrooms by their name
    private Map<String, Classroom> classrooms;

    /**
     * Constructs a ClassroomController object.
     * Initializes the classrooms map and logs the initialization.
     */
    public ClassroomController() {
        this.classrooms = new HashMap<>();
        logger.info("ClassroomController initialized.");
    }

    /**
     * Adds a new classroom to the collection.
     * Logs the result of the operation.
     *
     * @param className The name of the classroom to be added.
     */
    public void addClassroom(String className) {
        // Validate the class name
        if (!isValidClassName(className)) {
            // Show an error message and log a warning if the class name is invalid
            logger.warning("Invalid class name: " + className);
            System.out.println("Error: Class name must be a non-empty alphanumeric value.");
            return;
        }

        if (!classrooms.containsKey(className)) {
            // Create and add a new classroom if it doesn't already exist
            classrooms.put(className, new Classroom(className));
            logger.info("Classroom " + className + " has been created.");
        } else {
            // Log a warning if the classroom already exists
            logger.warning("Classroom " + className + " already exists.");
            System.out.println("Error: Classroom " + className + " already exists.");
        }
    }

    /**
     * Validates the class name to ensure it is a non-empty alphanumeric value.
     *
     * @param className The class name to be validated.
     * @return true if the class name is non-empty and alphanumeric, false otherwise.
     */
    private boolean isValidClassName(String className) {
        return className != null && !className.trim().isEmpty() && className.matches("[a-zA-Z0-9]+");
    }

    /**
     * Enrolls a student in a classroom.
     * Logs the result of the operation.
     *
     * @param studentId   The ID of the student.
     * @param studentName The name of the student.
     * @param className   The name of the classroom.
     */
    public void addStudent(String studentId, String studentName, String className) {
        // Validate the student ID
        if (!isValidStudentId(studentId)) {
            // Show an error message and log a warning if the student ID is invalid
            logger.warning("Invalid student ID: " + studentId);
            System.out.println("Error: Student ID must be a non-empty alphanumeric value.");
            return;
        }

        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            // Check if the student ID is unique
            if (classroom.hasStudent(studentId)) {
                logger.warning("Student ID " + studentId + " already exists in " + className + ".");
                System.out.println("Error: Student ID " + studentId + " is already enrolled in " + className + ".");
                return;
            }
            // Add the student to the classroom if it exists and ID is unique
            classroom.addStudent(new Student(studentId, studentName, className));
            logger.info("Student " + studentName + " (" + studentId + ") has been enrolled in " + className + ".");
        } else {
            // Log a warning if the classroom does not exist
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Error: Classroom " + className + " does not exist.");
        }
    }

    /**
     * Validates the student ID to ensure it is a non-empty alphanumeric value.
     *
     * @param studentId The student ID to be validated.
     * @return true if the student ID is non-empty and alphanumeric, false otherwise.
     */
    private boolean isValidStudentId(String studentId) {
        return studentId != null && !studentId.trim().isEmpty() && studentId.matches("[a-zA-Z0-9]+");
    }

    /**
     * Schedules an assignment for a classroom.
     * Logs the result of the operation.
     *
     * @param className         The name of the classroom.
     * @param assignmentDetails The details of the assignment.
     */
    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            // Schedule the assignment if the classroom exists
            classroom.scheduleAssignment(new Assignment(className, assignmentDetails));
            logger.info("Assignment for " + className + " has been scheduled.");
        } else {
            // Log a warning if the classroom does not exist
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Error: Classroom " + className + " does not exist.");
        }
    }

    /**
     * Submits an assignment for a student in a classroom.
     * Logs the result of the operation.
     *
     * @param studentId         The ID of the student.
     * @param className         The name of the classroom.
     * @param assignmentDetails The details of the assignment.
     */
    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        // Validate the student ID
        if (!isValidStudentId(studentId)) {
            // Show an error message and log a warning if the student ID is invalid
            logger.warning("Invalid student ID: " + studentId);
            System.out.println("Error: Student ID must be a non-empty alphanumeric value.");
            return;
        }

        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            // Check if the student is enrolled in the classroom
            boolean studentExists = classroom.getStudents().stream()
                .anyMatch(student -> student.getId().equals(studentId));
            if (studentExists) {
                // Check if the assignment is scheduled
                boolean assignmentScheduled = classroom.getScheduledAssignments().stream()
                    .anyMatch(assignment -> assignment.getDetails().equals(assignmentDetails));
                if (assignmentScheduled) {
                    // Submit the assignment if the student is enrolled and the assignment is scheduled
                    classroom.submitAssignment(new Assignment(className, assignmentDetails));
                    logger.info("Assignment submitted by Student " + studentId + " in " + className + ".");
                } else {
                    // Log a warning if the assignment is not scheduled
                    logger.warning("Assignment not scheduled for " + className + ".");
                    System.out.println("Error: Assignment not scheduled for " + className + ".");
                }
            } else {
                // Log a warning if the student is not enrolled
                logger.warning("Student " + studentId + " is not enrolled in " + className + ".");
                System.out.println("Error: Student " + studentId + " is not enrolled in " + className + ".");
            }
        } else {
            // Log a warning if the classroom does not exist
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Error: Classroom " + className + " does not exist.");
        }
    }

    /**
     * Lists all classrooms.
     * Logs the result of the operation.
     */
    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            // Log if there are no classrooms available
            logger.info("No classrooms available.");
            System.out.println("No classrooms available.");
        } else {
            // Log the names of all available classrooms
            logger.info("Classrooms:");
            System.out.println("Classrooms:");
            classrooms.keySet().forEach(className -> {
                logger.info("- " + className);
                System.out.println("- " + className);
            });
        }
    }

    /**
     * Views the details of a specific classroom.
     * Logs the details of the classroom, students, and assignments.
     *
     * @param className The name of the classroom.
     */
    public void viewClassroomDetails(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            // Log the details of the classroom, including students and assignments
            logger.info("Classroom: " + className);
            System.out.println("Classroom: " + className);
            logger.info("Students:");
            System.out.println("Students:");
            classroom.getStudents().forEach(student -> {
                logger.info("- " + student.getName() + " (" + student.getId() + ")");
                System.out.println("- " + student.getName() + " (" + student.getId() + ")");
            });
            logger.info("Assignments:");
            System.out.println("Assignments:");
            classroom.getScheduledAssignments().forEach(assignment -> {
                logger.info("- " + assignment.getDetails());
                System.out.println("- " + assignment.getDetails());
            });
        } else {
            // Log a warning if the classroom does not exist
            logger.warning("Classroom " + className + " does not exist.");
            System.out.println("Error: Classroom " + className + " does not exist.");
        }
    }
}
