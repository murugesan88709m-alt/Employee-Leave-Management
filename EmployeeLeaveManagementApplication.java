
package com.example.leave;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeLeaveManagementApplication implements CommandLineRunner {

    ArrayList<EmployeeLeave> leaves = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeLeaveManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE LEAVE MANAGEMENT =====");
            System.out.println("1. Apply Leave");
            System.out.println("2. View All Leave Requests");
            System.out.println("3. Search Leave by Employee ID");
            System.out.println("4. Delete Leave Request");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    applyLeave();
                    break;
                case 2:
                    viewLeaves();
                    break;
                case 3:
                    searchLeave();
                    break;
                case 4:
                    deleteLeave();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    void applyLeave() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (EmployeeLeave leave : leaves) {
            if (leave.getEmployeeId() == id) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        if (name.isBlank()) {
            System.out.println("Employee name is required!");
            return;
        }

        System.out.print("Enter Leave Type: ");
        String type = sc.nextLine();

        if (type.isBlank()) {
            System.out.println("Leave type is mandatory!");
            return;
        }

        System.out.print("Enter Number of Leave Days: ");
        int days = sc.nextInt();
        sc.nextLine();

        if (days < 1) {
            System.out.println("Leave days should be minimum 1!");
            return;
        }

        System.out.print("Enter Reason: ");
        String reason = sc.nextLine();

        EmployeeLeave leave =
                new EmployeeLeave(id, name, type, days, reason);

        leaves.add(leave);

        System.out.println("Leave applied successfully!");
    }

    void viewLeaves() {
        if (leaves.isEmpty()) {
            System.out.println("No leave requests found.");
            return;
        }

        for (EmployeeLeave leave : leaves) {
            System.out.println(leave);
            System.out.println("-------------------------");
        }
    }

    void searchLeave() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (EmployeeLeave leave : leaves) {
            if (leave.getEmployeeId() == id) {
                System.out.println(leave);
                return;
            }
        }

        System.out.println("Leave request not found!");
    }

    void deleteLeave() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean removed = leaves.removeIf(
                leave -> leave.getEmployeeId() == id
        );

        if (removed) {
            System.out.println("Leave request deleted successfully!");
        } else {
            System.out.println("Leave request not found!");
        }
    }
}