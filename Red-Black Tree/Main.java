import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            println("\nChoose an action:");
            println("1. Insert a value");
            println("2. In-order traversal");
            println("3. Search for a value");
            println("4. Print tree height");
            println("5. Check if the tree is a valid Red-Black Tree");
            println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {
                    print("Enter a value to insert: ");
                    int valueToInsert = scanner.nextInt();
                    redBlackTree.insert(valueToInsert);
                }

                case 2 -> {
                    print("In-order traversal: ");
                    Utility.inOrderTraversal(redBlackTree, redBlackTree.getRoot());
                    println("");
                }

                case 3 -> {
                    print("Enter a value to search: ");
                    int valueToSearch = scanner.nextInt();
                    Node searchResult = redBlackTree.search(valueToSearch);
                    if (searchResult != null) {
                        println("Value " + valueToSearch + " found in the tree.");
                    } else {
                        println("Value " + valueToSearch + " not found in the tree.");
                    }
                }

                case 4 -> {
                    print("Tree height: ");
                    int height = Utility.calculateHeight(redBlackTree, redBlackTree.getRoot());
                    println(height);
                }

                case 5 -> {
                    boolean isValid = Utility.isValidRedBlackTree(redBlackTree);
                    println("Is the tree a valid Red-Black Tree? " + isValid);
                }

                case 6 -> {
                    exit = true;
                    println("Exiting the program.");
                }

                default -> println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    public static void println(Object message) {
        System.out.println(message);
    }

    public static void print(Object message) {
        System.out.print(message);
    }
}
