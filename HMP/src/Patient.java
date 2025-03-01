import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patient extends People implements Staff {
    private final String bloodType;
    public double bill;
    public ArrayList<Appointment> appointments=new ArrayList<>();
    public ArrayList<String> prescription=new ArrayList<>();
    public String[] args;
    public Patient(String name, String lastname, int age, int contact, String gender, String address, String email,String userName,String password,String bloodType){
        super(name, lastname, age, contact, gender, address, email,userName,password);
        this.bloodType=bloodType;
    }
    public void patientLogInMenu(Patient patient) throws IOException {
        if(Admin.people.contains(this)){
            System.out.println("1.Book an Appointment");
            System.out.println("2.Bill");
            System.out.println("3.Profile");
            System.out.println("4.Delete account");
            System.out.println("5.Hospital Menu");
            System.out.print("Choose an option above : ");
            Scanner scanner=new Scanner(System.in);
            String q = scanner.nextLine();
            if (q.isBlank()) {
                throw new NullPointerException();
            }
            int a = Integer.parseInt(q);
            System.out.println();
            switch (a) {
                case 1 -> patient.bookAppointment();
                case 2 -> {
                    System.out.println("Bill : "+patient.getBill());
                    System.out.println("1.Patient Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String l = scanner.nextLine();
                    if (l.isBlank()) {
                        throw new NullPointerException();
                    }
                    int k = Integer.parseInt(l);
                    System.out.println();
                    switch (k) {
                        case 1 -> patientLogInMenu(this);
                        case 2 -> Hospital.main(args);
                        default ->
                                System.out.println("Invalid Input!");
                    }
                }
                case 3 -> {
                    System.out.println(patient.getAllInfo());
                    System.out.println("1.Patent Menu");
                    System.out.println("2.Hospital Menu");
                    System.out.print("Choose an option above : ");
                    String e = scanner.nextLine();
                    if (e.isBlank()) {
                        throw new NullPointerException();
                    }
                    int k = Integer.parseInt(e);
                    System.out.println();
                    switch (k) {
                        case 1 -> patientLogInMenu(this);
                        case 2 -> Hospital.main(args);
                        default ->
                                System.out.println("Invalid Input!");
                    }
                }
                case 4->deleteAccount();
                case 5 -> Hospital.main(args);
                default ->
                        System.out.println("Invalid Input!");
            }
        }else {
            System.out.println("Don't have an account!");
        }

    }
   public static void patientSignUpMenu() throws Exception {
       Pattern pattern=Pattern.compile("^[a-zA-Z]+$");
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Enter name : ");
            String name = scanner1.nextLine();
       Matcher matcher= pattern.matcher(name);
       if(name.isBlank()){
                throw new NullPointerException();
            }
       if(!matcher.find()){
           throw  new Exception();
       }
            System.out.print("Enter last name : ");
            String lastname = scanner1.nextLine();
       Matcher matcher1= pattern.matcher(lastname);
       if(lastname.isBlank()){
           throw new NullPointerException();
       }
       if (!matcher1.find()){
           throw  new Exception();
       }
            System.out.print("Enter user name : ");
            String username = scanner1.nextLine();
       Matcher matcher2= pattern.matcher(username);
       if(username.isBlank()){
           throw new NullPointerException();
       }
       if (!matcher2.find()){
           throw  new Exception();
       }
       boolean let = false;
       while (!let) {
           if (!Staff.un.contains(username)) {
               let = true;
           } else {
               System.out.print("This user name has already been taken.Enter another user name : ");
               username = scanner1.nextLine();
           }
           if(username.isBlank()){
               throw new NullPointerException();
           }
           Matcher matcher6= pattern.matcher(username);
           if (!matcher6.find()){
               throw  new Exception();
           }
       }
            System.out.print("Enter password : ");
            String pass = scanner1.nextLine();
       if(pass.isBlank()){
           throw new NullPointerException();
       }
            System.out.print("Enter age : ");
       String a=scanner1.nextLine();
       if(a.isBlank()){
           throw new NullPointerException();
       }
       int age= Integer.parseInt(a);
       if(age<1){
                throw new RuntimeException();
            }
            System.out.print("Enter contact number : ");
       String b = scanner1.nextLine();
       if(b.isBlank()){
           throw new NullPointerException();
       }
       int contact= Integer.parseInt(b);
       if (contact < 0) {
           throw new RuntimeException();
       }
            System.out.print("Enter gender : ");
            String gender = scanner1.nextLine();
       Matcher matcher3= pattern.matcher(gender);
       if(gender.isBlank()){
           throw new NullPointerException();
       }
       if(!matcher3.find()){
           throw new Exception();
       }
            System.out.print("Enter address : ");
            String address = scanner1.nextLine();
       Matcher matcher4= pattern.matcher(address);
       if(address.isBlank()){
           throw new NullPointerException();
       }
       if(!matcher4.find()){
           throw new Exception();
       }
            System.out.print("Enter email : ");
            String email = scanner1.nextLine();
       Matcher matcher5= pattern.matcher(email);
       if(email.isBlank()){
           throw new NullPointerException();
       }
       if(!matcher5.find()){
           throw new Exception();
       }
            System.out.print("Enter blood type : ");
            String bloodType = scanner1.nextLine();
       Matcher matcher6= pattern.matcher(bloodType);
       if(bloodType.isBlank()){
           throw new NullPointerException();
       }
       if(!matcher6.find()){
           throw new Exception();
       }
            if (!Staff.un.contains(username)) {
                Patient patient = new Patient(name, lastname, age, contact, gender, address, email, username, pass, bloodType);
                System.out.println("Thanks "+name+" for Joining");
                patient.patientLogInMenu(patient);
                } else {
                for(int i=0;i<Admin.people.size();i++){
                    if(Admin.people.get(i) instanceof Patient patient){
                        if(Objects.equals(patient.userName, username) && Objects.equals(patient.password, pass)){
                            System.out.println("Dear " + name + " You already have an account!");
                            patient.patientLogInMenu(patient);
                        }
                    }
                }
            }
    }
    @Override
    public String getAllInfo() {
        return "Name : "+this.name+" , Last Name : "+this.lastname+" , Age : "+this.age+" , Contact : "+this.contact+" , Gender : "+this.gender+" , Address : "+this.address+" , Email : "+this.email+" , ID : "+super.id+" , User Name : "+this.userName+" , Password : "+this.password+" Blood Type : "+this.bloodType;
    }
    public String getBill(){
        return "$"+this.bill;
    }
    @Override
    public void deleteAccount() throws IOException{
        System.out.println("Dear "+this.name +" Are you sure about deleting your account?");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Choose an option above : ");
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        switch (x) {
            case 1 -> {
                Admin.people.remove(this);
                System.out.println("done");
                Hospital.main(args);
            }
            case 2 -> {
                System.out.println("1.patient Menu");
                System.out.println("2.Hospital Menu");
                System.out.print("Choose an option above : ");
                String q = scanner.nextLine();
                if (q.isBlank()) {
                    throw new NullPointerException();
                }
                int k = Integer.parseInt(q);
                System.out.println();
                switch (k) {
                    case 1 -> patientLogInMenu(this);
                    case 2 -> Hospital.main(args);
                    default -> System.out.println("Invalid Input!");
                }
            }
            default -> System.out.println("Invalid input!");
        }
    }
   public void bookAppointment() throws IOException {
        Scanner scanner=new Scanner(System.in);
        int j=0;
        for(int i=0;i<Admin.people.size();i++){
            if(Admin.people.get(i) instanceof Doctor doctor){
                System.out.println(j+1+" "+doctor.getAllInfo());
                j++;
            }
        }
        if(j==0){
            System.out.println("No doctors!");
            System.out.println("1.Patent Menu");
            System.out.println("2.Hospital Menu");
            System.out.print("Choose an option above : ");
            String a = scanner.nextLine();
            if (a.isBlank()) {
                throw new NullPointerException();
            }
            int g = Integer.parseInt(a);
            System.out.println();
            switch (g) {
                case 1 -> patientLogInMenu(this);
                case 2 -> Hospital.main(args);
                default -> System.out.println("Invalid Input!");
            }
        }else {
            System.out.print("Choose a doctor to visit : ");
            String s=scanner.nextLine();
            if(s.isBlank()){
                throw new NullPointerException();
            }
            int answer= Integer.parseInt(s);
            int k=0;
            for(int i=0;i<Admin.people.size();i++){
                if(Admin.people.get(i) instanceof Doctor doctor){
                    if(k+1==answer){
                        if(doctor.getAppointmentMax()<5){
                            Appointment appointment =new Appointment(this,doctor);
                            appointment.prescription(appointment);
                            doctor.setAppointmentMax(doctor.getAppointmentMax()+1);
                            System.out.println("1.Patent Menu");
                            System.out.println("2.Hospital Menu");
                            System.out.print("Choose an option above : ");
                            String b = scanner.nextLine();
                            if (b.isBlank()) {
                                throw new NullPointerException();
                            }
                            int g = Integer.parseInt(b);
                            System.out.println();
                            switch (g) {
                                case 1 -> patientLogInMenu(this);
                                case 2 -> Hospital.main(args);
                                default -> System.out.println("Invalid Input!");
                            }
                        }else {
                            System.out.println("Sorry doctor "+doctor.name+" "+doctor.lastname+" isn't available at the time");
                            System.out.println("1.Patient Menu");
                            System.out.println("2.Hospital Menu");
                            System.out.print("Choose an option above : ");
                            String z=scanner.nextLine();
                            if(z.isBlank()){
                                throw new NullPointerException();
                            }
                            int g= Integer.parseInt(z);
                            System.out.println();
                            switch (g) {
                                case 1 -> patientLogInMenu(this);
                                case 2 -> Hospital.main(args);
                                default -> System.out.println("Invalid Input!");
                            }
                        }
                    }
                }k++;
            }
        }

        }
    @Override
   public void getAllAppointments(){
        int k=0;
        for (Appointment appointment : this.appointments) {
            System.out.println(appointment);
            k++;
        }
        if(k==0){
            System.out.println("Empty!");
        }
    }
   public void getAllPrescription(){
        int k=0;
        for (String s : this.prescription) {
            System.out.println(s);
            k++;
        }
        if(k==0){
            System.out.println("Empty!");
        }
    }
}