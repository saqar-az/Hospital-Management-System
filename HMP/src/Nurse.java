import java.util.Scanner;

public class Nurse implements Staff {
    private final String fullName, email;
    private final int number;
    public int id;
    public String[] args;

    Nurse(String fullName, int number, String email) {
        this.fullName = fullName;
        this.number = number;
        this.email = email;
        Admin.staff.add(this);
        this.id = Hospital.id;
        Hospital.id++;
    }

    @Override
    public void deleteAccount() {
        System.out.println("Dear " + this.fullName + " Are you sure about deleting your account?");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Choose an option above");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        if (a.isBlank()) {
            throw new NullPointerException();
        }
        int x = Integer.parseInt(a);
        if (x == 1) {
            Admin.staff.remove(this);
            System.out.println("Removed successfully!");
            System.out.println("1.Hospital Menu");
            System.out.println("1.Exit");
            System.out.print("Choose an option above : ");
            String s = scanner.nextLine();
            if (s.isBlank()) {
                throw new NullPointerException();
            }
            int e = Integer.parseInt(s);
            System.out.println();
            switch (e) {
                case 1 -> Hospital.main(args);
                case 2 -> System.exit(0);
                default -> System.out.println("Invalid input!");
            }
        } else {
            System.out.println("Invalid input!");
            System.out.println("1.Hospital Menu");
            System.out.println("1.Exit");
            System.out.print("Choose an option above : ");
            String s = scanner.nextLine();
            if (s.isBlank()) {
                throw new NullPointerException();
            }
            int e = Integer.parseInt(s);
            System.out.println();
            switch (e) {
                case 1 -> Hospital.main(args);
                case 2 -> System.exit(0);
                default -> System.out.println("Invalid input!");
            }
        }
    }

    public String toString() {
        return "Full Name : " + this.fullName + " , Number : " + this.number + " , Email : " + this.email + " , ID : " + this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }
}


