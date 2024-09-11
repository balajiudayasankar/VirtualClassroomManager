package view;

import java.util.Scanner;

/**
 * The ConsoleView class handles user interaction via the console.
 * It provides methods to get user input and display messages and formatted text in the console.
 */
public class ConsoleView {
    // Scanner object for reading user input from the console
    private Scanner scanner;

    /**
     * Constructs a ConsoleView object and initializes the scanner.
     */
    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user for input and returns the input string.
     *
     * @return The input string entered by the user.
     */
    public String getUserInput() {
        // Prompt the user with a "> " symbol and read the input
        System.out.print("\n> ");
        return scanner.nextLine();
    }

    /**
     * Displays a message in the console.
     *
     * @param message The message to be displayed.
     */
    public void showMessage(String message) {
        // Print the message to the console
        System.out.println(message);
    }

    /**
     * Displays a title in the console with a border for emphasis.
     *
     * @param title The title to be displayed.
     */
    public void showTitle(String title) {
        // Define a border for the title
        String border = "========================================";
        // Print the title with a border above and below
        System.out.println("\n" + border);
        System.out.println("        " + title.toUpperCase());
        System.out.println(border + "\n");
    }

    /**
     * Displays a header in the console with a delimiter for emphasis.
     *
     * @param header The header to be displayed.
     */
    public void showHeader(String header) {
        // Print the header with a delimiter above and below
        System.out.println("\n--- " + header + " ---\n");
    }

    /**
     * Displays a footer in the console with a border for separation.
     */
    public void showFooter() {
        // Print a footer with a border for separation
        System.out.println("\n========================================\n");
    }
}
