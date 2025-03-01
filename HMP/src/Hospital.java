import java.util.Scanner;

public class Hospital {
    public static int id = 0;
    public static boolean once = false,flag=false;

    public static void main(String[] args) {
        while (!flag){
            try {
                while (!once) {
                    File.readDoc();
                    File.readPat();
                    File.readNur();
                    File.readSec();
                    //Nurse nurse1 = new Nurse("Sara Cooper", 911143218, "sara.cooper@gmail.com");
                    //Nurse nurse2 = new Nurse("James Lee", 912345678, "james@gmail.com");
                    //Nurse nurse3 = new Nurse("Young Lee", 911976898, "younglee@gmail.com");
                    //Secretary secretary1 = new Secretary("Gee Peep", 902156545, "peepgee@gmail.com");
                    //Secretary secretary2 = new Secretary("Qatar Root", 902156505, "Qatar@gmail.com");
                    once = true;
                }

                System.out.println("Welcome to our Hospital");
                System.out.println("1.Patient");
                System.out.println("2.Staff");
                System.out.println("3.Admin");
                System.out.println("4.Exit");
                System.out.print("Choose an option above : ");
                Scanner scanner = new Scanner(System.in);
                String q = scanner.nextLine();
                if (q.isBlank()) {
                    throw new NullPointerException();
                }
                int answer = Integer.parseInt(q);
                System.out.println();
                switch (answer) {
                    case 1 -> {
                        System.out.println("1.Log in");
                        System.out.println("2.Make an account");
                        System.out.println("3.Hospital Menu");
                        System.out.print("Choose an option above : ");
                        String g = scanner.nextLine();
                        if (g.isBlank()) {
                            throw new NullPointerException();
                        }
                        int c = Integer.parseInt(g);
                        System.out.println();
                        switch (c) {
                            case 1 -> {
                                System.out.print("Enter user name : ");
                                String userName = scanner.nextLine();
                                System.out.print("Enter password : ");
                                String password = scanner.nextLine();
                                int k = 0;
                                for (int i = 0; i < Admin.people.size(); i++) {
                                    if (Admin.people.get(i) instanceof Patient patient) {
                                        if (patient.userName.equals(userName) && patient.password.equals(password)) {
                                            k++;
                                            patient.patientLogInMenu(patient);
                                        }
                                    }
                                }
                                if (k == 0) {
                                    System.out.println("You don't have an account!");
                                    System.out.println("1.Hospital Menu");
                                    System.out.println("2.Exit");
                                    System.out.print("Choose an option above : ");
                                    String f = scanner.nextLine();
                                    if (f.isBlank()) {
                                        throw new NullPointerException();
                                    }
                                    int x = Integer.parseInt(f);
                                    System.out.println();
                                    switch (x) {
                                        case 1 -> Hospital.main(args);
                                        case 2 -> {
                                            System.exit(0);
                                            flag=true;
                                        }
                                        default -> System.out.println("Invalid Input!");
                                    }
                                }
                            }
                            case 2 -> Patient.patientSignUpMenu();
                            case 3 -> Hospital.main(args);
                            default -> System.out.println("Invalid input!");
                        }
                    }
                    case 2 -> {
                        System.out.println("Staff Menu");
                        System.out.println("1.Doctor");
                        System.out.println("2.Nurse");
                        System.out.println("3.Secretary");
                        System.out.print("Choose an option above : ");
                        String d = scanner.nextLine();
                        if (d.isBlank()) {
                            throw new NullPointerException();
                        }
                        int w = Integer.parseInt(d);
                        System.out.println();
                        switch (w) {
                            case 1 -> {
                                System.out.println("1.Log in");
                                System.out.println("2.Make an account");
                                System.out.println("3.Hospital Menu");
                                System.out.println();
                                System.out.print("Choose an option above : ");
                                String h = scanner.nextLine();
                                if (h.isBlank()) {
                                    throw new NullPointerException();
                                }
                                int y = Integer.parseInt(h);
                                System.out.println();
                                switch (y) {
                                    case 1 -> {
                                        System.out.print("Enter user name : ");
                                        String userName = scanner.nextLine();
                                        System.out.print("Enter password : ");
                                        String password = scanner.nextLine();
                                        int k = 0;
                                        for (int i = 0; i < Admin.people.size(); i++) {
                                            if (Admin.people.get(i) instanceof Doctor doctor) {
                                                if (doctor.userName.equals(userName) && doctor.password.equals(password)) {
                                                    k++;
                                                    doctor.doctorMenu(doctor);
                                                }
                                            }
                                        }
                                        if (k == 0) {
                                            System.out.println("You don't have an account!");
                                            System.out.println("1.Hospital Menu");
                                            System.out.println("2.Exit");
                                            System.out.print("Choose an option above : ");
                                            String r = scanner.nextLine();
                                            if (r.isBlank()) {
                                                throw new NullPointerException();
                                            }
                                            int x = Integer.parseInt(r);
                                            System.out.println();
                                            switch (x) {
                                                case 1 -> Hospital.main(args);
                                                case 2 -> {
                                                    System.exit(0);
                                                    flag=true;
                                                }
                                                default -> System.out.println("Invalid Input!");
                                            }
                                        }
                                    }
                                    case 2 -> Doctor.doctorSignUpMenu();
                                    case 3 -> Hospital.main(args);
                                    default -> System.out.println("Invalid input!");
                                }
                            }
                            case 2 -> {
                                System.out.println("1.Log In");
                                System.out.println("2.Hospital Menu");
                                System.out.print("Choose an option above : ");
                                String f = scanner.nextLine();
                                if (f.isBlank()) {
                                    throw new NullPointerException();
                                }
                                int b = Integer.parseInt(f);
                                System.out.println();
                                switch (b) {
                                    case 1 -> {
                                        System.out.print("Enter Full Name : ");
                                        String name = scanner.nextLine();
                                        if (name.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        System.out.print("Enter Number : ");
                                        String s = scanner.nextLine();
                                        if (s.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int number = Integer.parseInt(s);
                                        System.out.print("Enter Email : ");
                                        String email = scanner.nextLine();
                                        if (email.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int k = 0;
                                        for (int i = 0; i < Admin.staff.size(); i++) {
                                            if (Admin.staff.get(i) instanceof Nurse nurse) {
                                                if (nurse.getFullName().equals(name) && nurse.getEmail().equals(email) && nurse.getNumber() == number) {
                                                    k++;
                                                    System.out.println("1.Profile");
                                                    System.out.println("2.Delete account");
                                                    System.out.println("3.Hospital Menu");
                                                    System.out.print("Choose an option above : ");
                                                    String h = scanner.nextLine();
                                                    if (h.isBlank()) {
                                                        throw new NullPointerException();
                                                    }
                                                    int y = Integer.parseInt(h);
                                                    System.out.println();
                                                    switch (y) {
                                                        case 1 -> {
                                                            System.out.println(nurse);
                                                            System.out.println("1.Hospital Menu");
                                                            System.out.println("2.Exit");
                                                            System.out.print("Choose an option above : ");
                                                            String j = scanner.nextLine();
                                                            if (j.isBlank()) {
                                                                throw new NullPointerException();
                                                            }
                                                            int p = Integer.parseInt(j);
                                                            System.out.println();
                                                            switch (p) {
                                                                case 1 -> Hospital.main(args);
                                                                case 2 -> {
                                                                    System.exit(0);
                                                                    flag=true;
                                                                }
                                                                default -> System.out.println("Invalid input");
                                                            }
                                                        }
                                                        case 2 -> nurse.deleteAccount();
                                                        case 3->Hospital.main(args);
                                                        default -> System.out.println("Invalid input");
                                                    }
                                                }
                                            }
                                        }
                                        if (k == 0) {
                                            System.out.println("You don't have an account");
                                            System.out.println("1.Hospital Menu");
                                            System.out.println("2.Exit");
                                            System.out.print("Choose an option above : ");
                                            String j = scanner.nextLine();
                                            if (j.isBlank()) {
                                                throw new NullPointerException();
                                            }
                                            int p = Integer.parseInt(j);
                                            System.out.println();
                                            switch (p) {
                                                case 1 -> Hospital.main(args);
                                                case 2 -> {
                                                    System.exit(0);
                                                    flag=true;
                                                }
                                                default -> System.out.println("Invalid input");
                                            }
                                        }
                                    }
                                    case 2 -> Hospital.main(args);
                                    default -> System.out.println("Invalid input!");
                                }
                            }
                            case 3 -> {
                                System.out.println("1.Log In");
                                System.out.println("2.Hospital Menu");
                                System.out.print("Choose an option above : ");
                                String h = scanner.nextLine();
                                if (h.isBlank()) {
                                    throw new NullPointerException();
                                }
                                int t = Integer.parseInt(h);
                                System.out.println();
                                switch (t) {
                                    case 1 -> {
                                        System.out.print("Enter Full Name : ");
                                        String name = scanner.nextLine();
                                        if (name.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        System.out.print("Enter Number : ");
                                        String f = scanner.nextLine();
                                        if (f.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int number = Integer.parseInt(f);
                                        System.out.print("Enter Email : ");
                                        String email = scanner.nextLine();
                                        if (email.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int k = 0;
                                        for (int i = 0; i < Admin.staff.size(); i++) {
                                            if (Admin.staff.get(i) instanceof Secretary secretary) {
                                                if (secretary.getFullName().equals(name) && secretary.getEmail().equals(email) && secretary.getNumber() == number) {
                                                    k++;
                                                    System.out.println("1.Profile");
                                                    System.out.println("2.Delete account");
                                                    System.out.println("3.Hospital Menu");
                                                    System.out.print("Choose an option above : ");
                                                    String s = scanner.nextLine();
                                                    if (s.isBlank()) {
                                                        throw new NullPointerException();
                                                    }
                                                    int b = Integer.parseInt(s);
                                                    System.out.println();
                                                    switch (b) {
                                                        case 1 -> {
                                                            System.out.println(secretary);
                                                            System.out.println("1.Hospital Menu");
                                                            System.out.println("2.Exit");
                                                            System.out.print("Choose an option above : ");
                                                            String j = scanner.nextLine();
                                                            if (j.isBlank()) {
                                                                throw new NullPointerException();
                                                            }
                                                            int p = Integer.parseInt(j);
                                                            System.out.println();
                                                            switch (p) {
                                                                case 1 -> Hospital.main(args);
                                                                case 2 -> {
                                                                    System.exit(0);
                                                                    flag=true;
                                                                }
                                                                default -> System.out.println("Invalid input");
                                                            }
                                                        }
                                                        case 2 -> secretary.deleteAccount();
                                                        case 3->Hospital.main(args);
                                                        default -> System.out.println("Invalid input");
                                                    }
                                                }
                                            }
                                        }
                                        if (k == 0) {
                                            System.out.println("You don't have an account");
                                            System.out.println("1.Hospital Menu");
                                            System.out.println("2.Exit");
                                            System.out.print("Choose an option above : ");
                                            String p = scanner.nextLine();
                                            if (p.isBlank()) {
                                                throw new NullPointerException();
                                            }
                                            int j = Integer.parseInt(p);
                                            System.out.println();
                                            switch (j) {
                                                case 1 -> Hospital.main(args);
                                                case 2 -> {
                                                    System.exit(0);
                                                    flag=true;
                                                }
                                                default -> System.out.println("Invalid input");
                                            }
                                        }
                                    }
                                    case 2 -> Hospital.main(args);
                                    default -> System.out.println("Invalid input!");
                                }
                            }
                            default -> System.out.println("Invalid input");
                        }
                    }
                    case 3 -> {
                        Admin admin = new Admin();
                        System.out.print("Enter username : ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password : ");
                        String password = scanner.nextLine();
                        boolean let = false;
                        while (!let) {
                            if (admin.getPassword().equals(password) && admin.getUsername().equalsIgnoreCase(username)) {
                                admin.adminMenu();
                                let = true;
                            } else {
                                System.out.println("Wrong password or user name!");
                                System.out.println("1.Try again");
                                System.out.println("2.Hospital Menu");
                                System.out.print("Choose an option above : ");
                                String s = scanner.nextLine();
                                if (s.isBlank()) {
                                    throw new NullPointerException();
                                }
                                int z = Integer.parseInt(s);
                                System.out.println();
                                switch (z) {
                                    case 1 -> {
                                        System.out.print("Enter username : ");
                                        String a = scanner.nextLine();
                                        System.out.print("Enter password : ");
                                        String y = scanner.nextLine();
                                        if (admin.getPassword().equals(y) && admin.getUsername().equalsIgnoreCase(a)) {
                                            admin.adminMenu();
                                        } else {
                                            System.out.println("Wrong password or user name!");
                                            Hospital.main(args);
                                        }
                                    }
                                    case 2 -> {
                                        Hospital.main(args);
                                        let = true;
                                    }
                                    default -> System.out.println("Invalid input!");
                                }
                            }
                        }
                    }
                    case 4 -> {
                        System.exit(0);
                        flag=true;
                    }
                    default -> System.out.println("Invalid input!");
                }
            } catch (NullPointerException e) {
                System.out.println("you're not supposed to leave this part empty!");
            } catch (NumberFormatException e) {
                System.out.println("you're supposed to enter a number!");
            } catch (RuntimeException e) {
                System.out.println("you're supposed to enter a valid number");
            } catch (Exception e) {
                System.out.println("you're supposed to fill this part with words not numbers");
            }
        }
    }
}
