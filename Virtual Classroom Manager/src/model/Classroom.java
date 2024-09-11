package model;

import java.util.HashSet;
import java.util.Set;

/**
 * The Classroom class represents a classroom with students and assignments.
 */
public class Classroom {
    private String name;
    private Set<Student> students;
    private Set<Assignment> scheduledAssignments;
    private Set<Assignment> submittedAssignments;

    /**
     * Constructs a Classroom object with the specified name.
     *
     * @param name The name of the classroom.
     */
    public Classroom(String name) {
        this.name = name;
        this.students = new HashSet<>();
        this.scheduledAssignments = new HashSet<>();
        this.submittedAssignments = new HashSet<>();
    }

    /**
     * Adds a student to the classroom.
     * Checks for unique student IDs before adding.
     *
     * @param student The student to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Checks if a student with the given ID is already in the classroom.
     *
     * @param studentId The ID of the student.
     * @return true if the student ID is already present, false otherwise.
     */
    public boolean hasStudent(String studentId) {
        return students.stream().anyMatch(student -> student.getId().equals(studentId));
    }

    /**
     * Schedules an assignment for the classroom.
     *
     * @param assignment The assignment to be scheduled.
     */
    public void scheduleAssignment(Assignment assignment) {
        scheduledAssignments.add(assignment);
    }

    /**
     * Submits an assignment for a student in the classroom.
     *
     * @param assignment The assignment to be submitted.
     */
    public void submitAssignment(Assignment assignment) {
        submittedAssignments.add(assignment);
    }

    /**
     * Returns the set of students in the classroom.
     *
     * @return The set of students.
     */
    public Set<Student> getStudents() {
        return students;
    }

    /**
     * Returns the set of scheduled assignments for the classroom.
     *
     * @return The set of scheduled assignments.
     */
    public Set<Assignment> getScheduledAssignments() {
        return scheduledAssignments;
    }

    /**
     * Returns the set of submitted assignments for the classroom.
     *
     * @return The set of submitted assignments.
     */
    public Set<Assignment> getSubmittedAssignments() {
        return submittedAssignments;
    }
}
