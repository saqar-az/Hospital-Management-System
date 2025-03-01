import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Doctor extends People implements Staff {
    private int appointmentMax = 0;
    public double salary;
    public ArrayList<Appointment> appointments = new ArrayList<>();
    public String[] args;

    public Doctor(String name, String lastname, int age, int contact, String gender, String address, String email, String userName, String password) {
        super(name, lastname, age, contact, gender, address, email, userName, password);
    }

    public void doctorMenu(Doctor doctor) throws IOException {
        if (Admin.people.contains(this)) {
            System.out.println("1.Appointments");
            System.out.println("2.salary");
            System.out.println("3.Profile");
            System.out.println("4.Delete account");
            System.out.println("5.Hospital Menu");
            System.out.print("Choose an option above : ");
            Scanner scanner = new Scanner(System.in);
            String q = scanner.nextLine();
            if (q.isBlank()) {
                throw new NullPointerException();
            }
            int a = Integer.parseInt(q);
            System.out.println();
            switch (a) {
                case 1 -> {
                    int j = 0;
                    for (int i = 0; i < doctor.appointments.size(); i++) {
                        System.out.println(i + 1 + " " + doctor.appointments.get(i).toString());
                        j++;
                    }
                    if (j == 0) {
                        System.out.println("Empty!");
                    }
                    System.out.println("1.Doctor Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String w = scanner.nextLine();
                    if (w.isBlank()) {
                        throw new NullPointerException();
                    }
                    int x = Integer.parseInt(w);
                    System.out.println();
                    switch (x) {
                        case 1 -> doctorMenu(this);
                        case 2 -> Hospital.main(args);
                        default -> System.out.println("Invalid Input!");
                    }
                }
                case 2 -> {
                    System.out.println("Salary : " + doctor.getSalary());
                    System.out.println("1.Doctor Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String z = scanner.nextLine();
                    if (z.isBlank()) {
                        throw new NullPointerException();
                    }
                    int x = Integer.parseInt(z);
                    System.out.println();
                    switch (x) {
                        case 1 -> doctorMenu(this);
                        case 2 -> Hospital.main(args);
                        default -> System.out.println("Invalid Input!");
                    }
                }
                case 3 -> {
                    System.out.println(doctor.getAllInfo());
                    System.out.println("1.Doctor Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String z = scanner.nextLine();
                    if (z.isBlank()) {
                        throw new NullPointerException();
                    }
                    int x = Integer.parseInt(z);
                    System.out.println();
                    switch (x) {
                        case 1 -> doctorMenu(this);
                        case 2 -> Hospital.main(args);
                        default -> System.out.println("Invalid Input!");
                    }
                }
                case 4 -> deleteAccount();
                case 5 -> Hospital.main(args);
                default -> System.out.println("Invalid Input!");
            }
        } else {
            System.out.println("Don't have an account!");
        }

    }

    public static void doctorSignUpMenu() throws Exception {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        Matcher matcher = pattern.matcher(name);
        if (name.isBlank()) {
            throw new NullPointerException();
        }
        if (!matcher.find()) {
            throw new Exception();
        }
        System.out.print("Enter last name : ");
        String lastname = scanner.nextLine();
        Matcher matcher1 = pattern.matcher(lastname);
        if (lastname.isBlank()) {
            throw new NullPointerException();
        }
        if (!matcher1.find()) {
            throw new Exception();
        }
        System.out.print("Enter user name : ");
        String user = scanner.nextLine();
        Matcher matcher2 = pattern.matcher(user);
        if (user.isBlank()) {
            throw new NullPointerException();
        }
        if (!matcher2.find()) {
            throw new Exception();
        }
        boolean let = false;
        while (!let) {
            if (!Staff.un.contains(user)) {
                let = true;
            } else {
                System.out.print("This user name has already been taken.Enter another user name : ");
                user = scanner.nextLine();
            }
            if(user.isBlank()){
                throw new NullPointerException();
            }
            Matcher matcher6 = pattern.matcher(user);
            if (!matcher6.find()){
                throw  new Exception();
            }
        }
        System.out.print("Enter password : ");
        String pass = scanner.nextLine();
        if (pass.isBlank()) {
            throw new NullPointerException();
        }
        System.out.print("Enter age : ");
        String a = scanner.nextLine();
        if (a.isBlank()) {
            throw new NullPointerException();
        }
        int age = Integer.parseInt(a);
        if (age < 1) {
            throw new RuntimeException();
        }
        System.out.print("Enter contact number : ");
        String b = scanner.nextLine();
        if (b.isBlank()) {
            throw new NullPointerException();
        }
        int contact = Integer.parseInt(b);
        if (contact < 0) {
            throw new RuntimeException();
        }
        System.out.print("Enter gender : ");
        String gender = scanner.nextLine();
        Matcher matcher3 = pattern.matcher(gender);
        if (gender.isBlank()) {
            throw new NullPointerException();
        }
        if (!matcher3.find()) {
            throw new Exception();
        }
        System.out.print("Enter address : ");
        String address = scanner.nextLine();
        Matcher matcher4 = pattern.matcher(address);
        if (name.isBlank()) {
            throw new NullPointerException();
        }
        if (!matcher4.find()) {
            throw new Exception();
        }
        System.out.print("Enter email : ");
        String email = scanner.nextLine();
        Matcher matcher5 = pattern.matcher(email);
        if (name.isBlank()) {
            throw new NullPointerException();
        }
        if (!matcher5.find()) {
            throw new Exception();
        }
        if (!Staff.un.contains(user)) {
            Doctor doctor = new Doctor(name, lastname, age, contact, gender, address, email, user, pass);
            System.out.println("Thanks " + name + " for Joining");
            doctor.doctorMenu(doctor);
        } else {
            for (int i = 0; i < Admin.people.size(); i++) {
                if (Admin.people.get(i) instanceof Doctor doctor) {
                    if (Objects.equals(doctor.userName, user) && Objects.equals(doctor.password, pass)) {
                        System.out.println("Dear " + name + " You already have an account!");
                        doctor.doctorMenu(doctor);
                    }
                }
            }
        }
    }

    @Override
    public String getAllInfo() {
        return "Name : " + this.name + " , Last Name : " + this.lastname + " , Age : " + this.age + " , Contact : " + this.contact + " , Gender : " + this.gender + " , Address : " + this.address + " , Email : " + this.email + " , ID : " + super.id + " , User Name : " + this.userName + " , Password : " + this.password;
    }

    @Override
    public void getAllAppointments() {
        int k = 0;
        for (Appointment appointment : this.appointments) {
            System.out.println(appointment);
            k++;
        }
        if (k == 0) {
            System.out.println("Empty!");
        }
    }

    public String getSalary() {
        return "$" + this.salary;
    }

    @Override
    public void deleteAccount() throws IOException {
        System.out.println("Dear " + this.name + " Are you sure about deleting your account?");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Choose an option above");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                Admin.people.remove(this);
                System.out.println("done");
                Hospital.main(args);
            }
            case 2 -> {
                System.out.println("1.Doctor Menu");
                System.out.println("2.Hospital Menu");
                System.out.print("Choose an option above : ");
                String q = scanner.nextLine();
                if (q.isBlank()) {
                    throw new NullPointerException();
                }
                int k = Integer.parseInt(q);
                System.out.println();
                switch (k) {
                    case 1 -> doctorMenu(this);
                    case 2 -> Hospital.main(args);
                    default -> System.out.println("Invalid Input!");
                }
            }
            default -> System.out.println("Invalid input!");
        }
    }

    public int getAppointmentMax() {
        return appointmentMax;
    }

    public void setAppointmentMax(int appointmentMax) {
        this.appointmentMax = appointmentMax;
    }

}
