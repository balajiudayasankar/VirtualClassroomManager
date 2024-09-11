import controller.ClassroomController;
import view.ConsoleView;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The VirtualClassroomManager class is the entry point for the application.
 * It uses the ClassroomController and ConsoleView classes to manage the virtual classroom system.
 */
public class VirtualClassroomManager {
    // Logger instance to record application events and issues
    private static final Logger logger = Logger.getLogger(VirtualClassroomManager.class.getName());

    /**
     * Main method that runs the Virtual Classroom Manager application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Instantiate the controller and view objects
        ClassroomController controller = new ClassroomController();
        ConsoleView view = new ConsoleView();

        // Display the title of the application
        view.showTitle("Virtual Classroom Manager");

        // Display the help menu
        displayHelp(view);

        // Flag to control the main application loop
        boolean running = true;

        // Main application loop
        while (running) {
            // Get user input from the console
            String userInput = view.getUserInput();
            // Split the input into command and arguments
            String[] commandParts = userInput.split(" ", 2);
            // Extract the command from the input
            String command = commandParts.length > 0 ? commandParts[0] : "";

            // Process the command entered by the user
            switch (command) {
                case "add_classroom":
                    view.showHeader("Add Classroom"); // Display header for the command
                    if (commandParts.length > 1) {
                        // Add the new classroom using the provided name
                        controller.addClassroom(commandParts[1]);
                    } else {
                        // Display error message if classroom name is missing
                        view.showMessage("Error: Missing classroom name.");
                        logger.warning("Missing classroom name in 'add_classroom' command.");
                    }
                    view.showFooter(); // Display footer after processing
                    break;

                case "add_student":
                    view.showHeader("Add Student"); // Display header for the command
                    if (commandParts.length > 1) {
                        // Split the student details into ID, name, and class name
                        String[] studentParts = commandParts[1].split(" ", 3);
                        if (studentParts.length == 3) {
                            // Add the student to the specified class
                            controller.addStudent(studentParts[0], studentParts[1], studentParts[2]);
                        } else {
                            // Display error message if student details are invalid
                            view.showMessage("Error: Invalid student details. Format: [student ID] [student name] [class name]");
                            logger.warning("Invalid student details in 'add_student' command.");
                        }
                    } else {
                        // Display error message if student details are missing
                        view.showMessage("Error: Missing student details.");
                        logger.warning("Missing student details in 'add_student' command.");
                    }
                    view.showFooter(); // Display footer after processing
                    break;

                case "schedule_assignment":
                    view.showHeader("Schedule Assignment"); // Display header for the command
                    if (commandParts.length > 1) {
                        // Split the assignment details into class name and details
                        String[] assignmentParts = commandParts[1].split(" ", 2);
                        if (assignmentParts.length == 2) {
                            // Schedule the assignment for the specified class
                            controller.scheduleAssignment(assignmentParts[0], assignmentParts[1]);
                        } else {
                            // Display error message if assignment details are invalid
                            view.showMessage("Error: Invalid assignment details. Format: [class name] [assignment details]");
                            logger.warning("Invalid assignment details in 'schedule_assignment' command.");
                        }
                    } else {
                        // Display error message if assignment details are missing
                        view.showMessage("Error: Missing assignment details.");
                        logger.warning("Missing assignment details in 'schedule_assignment' command.");
                    }
                    view.showFooter(); // Display footer after processing
                    break;

                case "submit_assignment":
                    view.showHeader("Submit Assignment"); // Display header for the command
                    if (commandParts.length > 1) {
                        // Split the submission details into student ID, class name, and assignment details
                        String[] submissionParts = commandParts[1].split(" ", 3);
                        if (submissionParts.length == 3) {
                            // Submit the assignment for the specified student
                            controller.submitAssignment(submissionParts[0], submissionParts[1], submissionParts[2]);
                        } else {
                            // Display error message if submission details are invalid
                            view.showMessage("Error: Invalid submission details. Format: [student ID] [class name] [assignment details]");
                            logger.warning("Invalid submission details in 'submit_assignment' command.");
                        }
                    } else {
                        // Display error message if submission details are missing
                        view.showMessage("Error: Missing submission details.");
                        logger.warning("Missing submission details in 'submit_assignment' command.");
                    }
                    view.showFooter(); // Display footer after processing
                    break;

                case "list_classrooms":
                    view.showHeader("List Classrooms"); // Display header for the command
                    // List all available classrooms
                    controller.listClassrooms();
                    view.showFooter(); // Display footer after processing
                    break;

                case "view_classroom":
                    view.showHeader("View Classroom Details"); // Display header for the command
                    if (commandParts.length > 1) {
                        // View the details of the specified classroom
                        controller.viewClassroomDetails(commandParts[1]);
                    } else {
                        // Display error message if classroom name is missing
                        view.showMessage("Error: Missing classroom name.");
                        logger.warning("Missing classroom name in 'view_classroom' command.");
                    }
                    view.showFooter(); // Display footer after processing
                    break;

                case "help":
                    view.showHeader("Help"); // Display header for the command
                    // Display the help menu
                    displayHelp(view);
                    view.showFooter(); // Display footer after processing
                    break;

                case "exit":
                    view.showHeader("Exit"); // Display header for the command
                    // Display exit message and terminate the application
                    view.showMessage("Exiting the application...");
                    view.showFooter(); // Display footer after processing
                    logger.info("Application exited.");
                    System.exit(0); // Exit the application
                    running = false; // Set running to false to exit the loop
                    break;

                default:
                    view.showHeader("Invalid Command"); // Display header for the command
                    // Display error message for invalid command
                    view.showMessage("Invalid command. Type 'help' to see the list of commands.");
                    view.showFooter(); // Display footer after processing
                    logger.warning("Invalid command: " + command);
                    break;
            }
        }
    }

    /**
     * Displays the help menu with available commands.
     *
     * @param view The ConsoleView object used to display messages.
     */
    private static void displayHelp(ConsoleView view) {
        view.showMessage("Available Commands:"); // Show header for the help menu
        view.showMessage("1. add_classroom [class name] - Adds a new classroom."); // List command descriptions
        view.showMessage("2. add_student [student ID] [student name] [class name] - Enrolls a student in a classroom.");
        view.showMessage("3. schedule_assignment [class name] [assignment details] - Schedules an assignment for a class.");
        view.showMessage("4. submit_assignment [student ID] [class name] [assignment details] - Submits an assignment for a student.");
        view.showMessage("5. list_classrooms - Lists all classrooms.");
        view.showMessage("6. view_classroom [class name] - Views the details of a specific classroom.");
        view.showMessage("7. help - Displays the help menu.");
        view.showMessage("8. exit - Exits the application.");
    }
}
