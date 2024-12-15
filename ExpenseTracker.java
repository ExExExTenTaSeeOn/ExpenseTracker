import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;
    private String category;
    private Date date;

    public Expense(String description, double amount, String category, Date date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }

    // toString method to display expense details
    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount + ", Category: " + category + ", Date: " + date;
    }
}

public class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private Scanner scanner;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addExpense() {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        expenses.add(new Expense(description, amount, category, new Date()));
        System.out.println("Expense added successfully!");
    }

    public void editExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to edit.");
            return;
        }
        System.out.println("Select expense number to edit:");
        displayExpenses();
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < expenses.size()) {
            System.out.print("Enter new description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new category: ");
            String category = scanner.nextLine();
            expenses.set(index, new Expense(description, amount, category, new Date()));
            System.out.println("Expense edited successfully!");
        } else {
            System.out.println("Invalid expense number!");
        }
    }

    public void deleteExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to delete.");
            return;
        }
        System.out.println("Select expense number to delete:");
        displayExpenses();
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Invalid expense number!");
        }
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
            return;
        }
        System.out.println("All Expenses:");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
    }

    public void displayExpenses() {
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
    }

    public void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Edit Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = tracker.scanner.nextInt();
            tracker.scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tracker.addExpense();
                    break;
                case 2:
                    tracker.editExpense();
                    break;
                case 3:
                    tracker.deleteExpense();
                    break;
                case 4:
                    tracker.viewExpenses();
                    break;
                case 5:
                    tracker.closeScanner();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}