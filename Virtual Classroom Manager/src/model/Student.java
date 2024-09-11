package model;

/**
 * The Student class represents a student with an ID, a name, and a class name.
 */
public class Student {
    // The ID of the student
    private String id;
    // The name of the student
    private String name;
    // The name of the class the student is enrolled in
    private String className;

    /**
     * Constructs a Student object with the specified ID, name, and class name.
     *
     * @param id The ID of the student.
     * @param name The name of the student.
     * @param className The name of the class the student is enrolled in.
     */
    public Student(String id, String name, String className) {
        // Initialize the ID of the student with the provided value
        this.id = id;
        // Initialize the name of the student with the provided value
        this.name = name;
        // Initialize the class name the student is enrolled in with the provided value
        this.className = className;
    }

    /**
     * Returns the ID of the student.
     *
     * @return The ID of the student.
     */
    public String getId() {
        // Return the ID of the student
        return id;
    }

    /**
     * Returns the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        // Return the name of the student
        return name;
    }

    /**
     * Returns the name of the class the student is enrolled in.
     *
     * @return The name of the class.
     */
    public String getClassName() {
        // Return the name of the class the student is enrolled in
        return className;
    }
}
