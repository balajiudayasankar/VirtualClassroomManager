package model;

/**
 * The Assignment class represents an assignment for a specific class.
 */
public class Assignment {
    // The name of the class to which this assignment belongs
    private String className;
    // The details of the assignment
    private String details;

    /**
     * Constructs an Assignment object with the specified class name and details.
     *
     * @param className The name of the class to which this assignment belongs.
     * @param details   The details of the assignment.
     */
    public Assignment(String className, String details) {
        // Initializing the className field with the provided class name
        this.className = className;
        // Initializing the details field with the provided assignment details
        this.details = details;
    }

    /**
     * Returns the name of the class to which this assignment belongs.
     *
     * @return The name of the class.
     */
    public String getClassName() {
        // Returning the class name associated with this assignment
        return className;
    }

    /**
     * Returns the details of the assignment.
     *
     * @return The details of the assignment.
     */
    public String getDetails() {
        // Returning the details of the assignment
        return details;
    }
}
