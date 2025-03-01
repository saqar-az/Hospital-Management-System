import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends File {
    public String[] args;
    public static ArrayList<People> people = new ArrayList<>();
    public static ArrayList<Staff> staff = new ArrayList<>();
    private String username = "Admin", password = "54321";

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void adminMenu() throws IOException {
        System.out.println("Admin Menu");
        System.out.println("1.View All Doctors");
        System.out.println("2.View All Patients");
        System.out.println("3.View All Nurses");
        System.out.println("4.View All Secretaries");
        System.out.println("5.Edit profile");
        System.out.println("6.Save to file");
        System.out.println("7.Hospital Menu");
        System.out.print("Choose an option above : ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isBlank()) {
            throw new NullPointerException();
        }
        int x = Integer.parseInt(s);
        System.out.println();
        switch (x) {
            case 1 -> {
                System.out.println("Doctors");
                int j = 0;
                for (People person : people) {
                    if (person instanceof Doctor doctor) {
                        System.out.println(j + 1 + " " + doctor.getAllInfo());
                        j++;
                    }
                }
                if (j == 0) {
                    System.out.println("Empty!");
                    System.out.println("1.Admin Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String a = scanner.nextLine();
                    if (a.isBlank()) {
                        throw new NullPointerException();
                    }
                    int z = Integer.parseInt(a);
                    System.out.println();
                    switch (z) {
                        case 1 -> adminMenu();
                        case 2 -> Hospital.main(args);
                        default -> System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("1.Delete");
                    System.out.println("2.See All Appointments");
                    System.out.println("3.Admin Menu");
                    System.out.print("Choose an option above : ");
                    String a = scanner.nextLine();
                    if (a.isBlank()) {
                        throw new NullPointerException();
                    }
                    int z = Integer.parseInt(a);
                    System.out.println();
                    switch (z) {
                        case 1 -> {
                            System.out.print("Enter the doctor's no : ");
                            String f = scanner.nextLine();
                            if (f.isBlank()) {
                                throw new NullPointerException();
                            }
                            int p = Integer.parseInt(f);
                            int k = 0;
                            for (People value : people) {
                                if (value instanceof Doctor doctor) {
                                    if (k + 1 == p) {
                                        System.out.println(doctor.name + " " + doctor.lastname + " Removed successfully!");
                                        people.remove(k);
                                        System.out.println("1.Admin Menu");
                                        System.out.println("2.Hospital Menu");
                                        System.out.print("Choose an option above : ");
                                        String b = scanner.nextLine();
                                        if (b.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int g = Integer.parseInt(b);
                                        System.out.println();
                                        switch (g) {
                                            case 1 -> adminMenu();
                                            case 2 -> Hospital.main(args);
                                            default -> System.out.println("Invalid input!");
                                        }
                                    }
                                    k++;
                                }
                            }
                        }
                        case 2 -> {
                            System.out.print("Enter the doctor's no : ");
                            String g = scanner.nextLine();
                            if (g.isBlank()) {
                                throw new NullPointerException();
                            }
                            int p = Integer.parseInt(g);
                            int k = 0;
                            for (People value : people) {
                                if (value instanceof Doctor doctor) {
                                    if (k + 1 == p) {
                                        doctor.getAllAppointments();
                                        System.out.println("1.Admin Menu");
                                        System.out.println("2.Hospital Menu");
                                        System.out.print("Choose an option above : ");
                                        String l = scanner.nextLine();
                                        if (l.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int i = Integer.parseInt(l);
                                        System.out.println();
                                        switch (i) {
                                            case 1 -> adminMenu();
                                            case 2 -> Hospital.main(args);
                                            default -> System.out.println("Invalid input!");
                                        }
                                    }
                                    k++;
                                }
                            }
                        }
                        case 3 -> adminMenu();
                        default -> System.out.println("Invalid input!");
                    }
                }
            }
            case 2 -> {
                System.out.println("Patients");
                int j = 0;
                for (People person : people) {
                    if (person instanceof Patient patient) {
                        System.out.println(j + 1 + " " + patient.getAllInfo());
                        j++;
                    }

                }
                if (j == 0) {
                    System.out.println("Empty!");
                    System.out.println("1.Admin Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String a = scanner.nextLine();
                    if (a.isBlank()) {
                        throw new NullPointerException();
                    }
                    int z = Integer.parseInt(a);
                    System.out.println();
                    switch (z) {
                        case 1 -> adminMenu();
                        case 2 -> Hospital.main(args);
                        default -> System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("1.Delete");
                    System.out.println("2.See All Prescription");
                    System.out.println("3.Admin Menu");
                    System.out.print("Choose an option above : ");
                    String d = scanner.nextLine();
                    if (d.isBlank()) {
                        throw new NullPointerException();
                    }
                    int c = Integer.parseInt(d);
                    System.out.println();
                    switch (c) {
                        case 1 -> {
                            System.out.print("Enter the patients no : ");
                            String a = scanner.nextLine();
                            if (a.isBlank()) {
                                throw new NullPointerException();
                            }
                            int p = Integer.parseInt(a);
                            int k = 0;
                            for (People value : people) {
                                if (value instanceof Patient patient) {
                                    if (k + 1 == p) {
                                        System.out.println(patient.name + " " + patient.lastname + " Removed successfully!");
                                        people.remove(k);
                                        System.out.println("1.Admin Menu");
                                        System.out.println("2.Hospital Menu");
                                        System.out.print("Choose an option above : ");
                                        String b = scanner.nextLine();
                                        if (b.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int z = Integer.parseInt(b);
                                        System.out.println();
                                        switch (z) {
                                            case 1 -> adminMenu();
                                            case 2 -> Hospital.main(args);
                                            default -> System.out.println("Invalid input!");
                                        }
                                    }
                                    k++;
                                }
                            }
                        }
                        case 2 -> {
                            System.out.print("Enter the patient's no : ");
                            String a = scanner.nextLine();
                            if (a.isBlank()) {
                                throw new NullPointerException();
                            }
                            int p = Integer.parseInt(a);
                            int k = 0;
                            for (People value : people) {
                                if (value instanceof Patient patient) {
                                    if (k + 1 == p) {
                                        patient.getAllPrescription();
                                        System.out.println("1.Admin Menu");
                                        System.out.println("2.Hospital Menu");
                                        System.out.print("Choose an option above : ");
                                        String o = scanner.nextLine();
                                        if (o.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int z = Integer.parseInt(o);
                                        System.out.println();
                                        switch (z) {
                                            case 1 -> adminMenu();
                                            case 2 -> Hospital.main(args);
                                            default -> System.out.println("Invalid input!");
                                        }
                                        break;
                                    }
                                    k++;
                                }
                            }
                        }
                        case 3 -> adminMenu();
                        default -> System.out.println("Invalid input!");
                    }
                }
            }
            case 3 -> {
                System.out.println("Nurses");
                int j = 0;
                for (Staff value : staff) {
                    if (value instanceof Nurse nurse) {
                        System.out.println(j + 1 + " " + nurse);
                        j++;
                    }
                }
                if (j == 0) {
                    System.out.println("Empty!");
                    System.out.println("1.Admin Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String a = scanner.nextLine();
                    if (a.isBlank()) {
                        throw new NullPointerException();
                    }
                    int z = Integer.parseInt(a);
                    System.out.println();
                    switch (z) {
                        case 1 -> adminMenu();
                        case 2 -> Hospital.main(args);
                        default -> System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("1.Delete");
                    System.out.println("2.Admin Menu");
                    System.out.print("Choose an option above : ");
                    String n = scanner.nextLine();
                    if (n.isBlank()) {
                        throw new NullPointerException();
                    }
                    int m = Integer.parseInt(n);
                    System.out.println();
                    switch (m) {
                        case 1 -> {
                            System.out.println("Enter the nurses no : ");
                            String a = scanner.nextLine();
                            if (a.isBlank()) {
                                throw new NullPointerException();
                            }
                            int p = Integer.parseInt(a);
                            int k = 0;
                            for (int l = 0; l < staff.size(); l++) {
                                if (staff.get(l) instanceof Nurse) {
                                    if (k + 1 == p) {
                                        System.out.println(staff.get(l) + " Removed successfully!");
                                        staff.remove(l);
                                        System.out.println("1.Admin Menu");
                                        System.out.println("2.Hospital Menu");
                                        System.out.print("Choose an option above : ");
                                        String q = scanner.nextLine();
                                        if (q.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int z = Integer.parseInt(q);
                                        System.out.println();
                                        switch (z) {
                                            case 1 -> adminMenu();
                                            case 2 -> Hospital.main(args);
                                            default -> System.out.println("Invalid input!");
                                        }
                                    }
                                    k++;
                                }
                            }
                        }
                        case 2 -> adminMenu();
                        default -> System.out.println("Invalid input");
                    }
                }
            }
            case 4 -> {
                System.out.println("Secretaries");
                int j = 0;
                for (Staff value : staff) {
                    if (value instanceof Secretary secretary) {
                        System.out.println(j + 1 + " " + secretary);
                        j++;
                    }
                }
                if (j == 0) {
                    System.out.println("Empty!");
                    System.out.println("1.Admin Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String a = scanner.nextLine();
                    if (a.isBlank()) {
                        throw new NullPointerException();
                    }
                    int z = Integer.parseInt(a);
                    System.out.println();
                    switch (z) {
                        case 1 -> adminMenu();
                        case 2 -> Hospital.main(args);
                        default -> System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("1.Delete");
                    System.out.println("2.Admin Menu");
                    System.out.print("Choose an option above : ");
                    String i = scanner.nextLine();
                    if (i.isBlank()) {
                        throw new NullPointerException();
                    }
                    int o = Integer.parseInt(i);
                    System.out.println();
                    switch (o) {
                        case 1 -> {
                            System.out.println("Enter the secretary no : ");
                            String a = scanner.nextLine();
                            if (a.isBlank()) {
                                throw new NullPointerException();
                            }
                            int p = Integer.parseInt(a);
                            int k = 0;
                            for (int l = 0; l < staff.size(); l++) {
                                if (staff.get(l) instanceof Secretary) {
                                    if (k + 1 == p) {
                                        System.out.println(staff.get(l) + " Removed successfully!");
                                        staff.remove(l);
                                        System.out.println("1.Admin Menu");
                                        System.out.println("2.Hospital Menu");
                                        System.out.print("Choose an option above : ");
                                        String u = scanner.nextLine();
                                        if (u.isBlank()) {
                                            throw new NullPointerException();
                                        }
                                        int z = Integer.parseInt(u);
                                        System.out.println();
                                        switch (z) {
                                            case 1 -> adminMenu();
                                            case 2 -> Hospital.main(args);
                                            default -> System.out.println("Invalid input!");
                                        }
                                    }
                                    k++;
                                }
                            }
                        }
                        case 2 -> adminMenu();
                        default -> System.out.println("Invalid input");
                    }
                }
            }
            case 5 -> {
                System.out.println("Username : " + username);
                System.out.println("Password : " + password);
                System.out.println("1.Change username");
                System.out.println("2.Change password");
                System.out.println("3.Admin Menu");
                System.out.println("Choose an option above");
                String q = scanner.nextLine();
                if (q.isBlank()) {
                    throw new NullPointerException();
                }
                int f = Integer.parseInt(q);
                System.out.println();
                switch (f) {
                    case 1 -> changeUserName();
                    case 2 -> changePassword();
                    case 3 -> adminMenu();
                    default -> System.out.println("Invalid Input!");
                }
            }
            case 6 -> {
                System.out.println("1.Save doctors");
                System.out.println("2.Save patients");
                System.out.println("3.Save nurses");
                System.out.println("4.Save secretaries");
                System.out.print("Choose an option above : ");
                String w = scanner.nextLine();
                if (w.isBlank()) {
                    throw new NullPointerException();
                }
                int b = Integer.parseInt(w);
                System.out.println();
                switch (b) {
                    case 1 -> {
                        saveDoc();
                        System.out.println("1.Admin menu");
                        System.out.println("2.Hospital menu");
                        System.out.print("Choose an option above : ");
                        String r = scanner.nextLine();
                        if (r.isBlank()) {
                            throw new NullPointerException();
                        }
                        int v = Integer.parseInt(r);
                        System.out.println();
                        switch (v) {
                            case 1 -> adminMenu();
                            case 2 -> Hospital.main(args);
                            default -> System.out.println("Invalid Input!");
                        }
                    }
                    case 2 -> {
                        savePat();
                        System.out.println("1.Admin menu");
                        System.out.println("2.Hospital menu");
                        System.out.print("Choose an option above : ");
                        String r = scanner.nextLine();
                        if (r.isBlank()) {
                            throw new NullPointerException();
                        }
                        int v = Integer.parseInt(r);
                        System.out.println();
                        switch (v) {
                            case 1 -> adminMenu();
                            case 2 -> Hospital.main(args);
                            default -> System.out.println("Invalid Input!");
                        }
                    }
                    case 3 -> {
                        saveNur();
                        System.out.println("1.Admin menu");
                        System.out.println("2.Hospital menu");
                        System.out.print("Choose an option above : ");
                        String r = scanner.nextLine();
                        if (r.isBlank()) {
                            throw new NullPointerException();
                        }
                        int v = Integer.parseInt(r);
                        System.out.println();
                        switch (v) {
                            case 1 -> adminMenu();
                            case 2 -> Hospital.main(args);
                            default -> System.out.println("Invalid Input!");
                        }
                    }
                    case 4 -> {
                        saveSec();
                        System.out.println("1.Admin menu");
                        System.out.println("2.Hospital menu");
                        System.out.print("Choose an option above : ");
                        String r = scanner.nextLine();
                        if (r.isBlank()) {
                            throw new NullPointerException();
                        }
                        int v = Integer.parseInt(r);
                        System.out.println();
                        switch (v) {
                            case 1 -> adminMenu();
                            case 2 -> Hospital.main(args);
                            default -> System.out.println("Invalid Input!");
                        }
                    }
                    default -> System.out.println("Invalid Input!");
                }
                System.out.println("1.Admin menu");
                System.out.println("2.Hospital menu");
                System.out.print("Choose an option above : ");
                String r = scanner.nextLine();
                if (r.isBlank()) {
                    throw new NullPointerException();
                }
                int v = Integer.parseInt(r);
                System.out.println();
                switch (v) {
                    case 1 -> adminMenu();
                    case 2 -> Hospital.main(args);
                    default -> System.out.println("Invalid Input!");
                }
            }
            case 7 -> Hospital.main(args);
            default -> System.out.println("Invalid Input!");
        }
    }

    public void changeUserName() throws IOException {
        System.out.print("Enter your chosen user name : ");
        Scanner scanner = new Scanner(System.in);
        this.username = scanner.nextLine();
        System.out.println("User name changed successfully!");
        System.out.println("1.Admin menu");
        System.out.println("2.Hospital menu");
        System.out.print("Choose an option above : ");
        String r = scanner.nextLine();
        if (r.isBlank()) {
            throw new NullPointerException();
        }
        int v = Integer.parseInt(r);
        System.out.println();
        switch (v) {
            case 1 -> adminMenu();
            case 2 -> Hospital.main(args);
            default -> System.out.println("Invalid Input!");
        }
    }

    public void changePassword() throws IOException {
        System.out.print("Enter your chosen password : ");
        Scanner scanner = new Scanner(System.in);
        this.password = scanner.nextLine();
        System.out.println("Password changed successfully!");
        System.out.println("1.Admin menu");
        System.out.println("2.Hospital menu");
        System.out.print("Choose an option above : ");
        String r = scanner.nextLine();
        if (r.isBlank()) {
            throw new NullPointerException();
        }
        int v = Integer.parseInt(r);
        System.out.println();
        switch (v) {
            case 1 -> adminMenu();
            case 2 -> Hospital.main(args);
            default -> System.out.println("Invalid Input!");
        }
    }
}
