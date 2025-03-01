import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;
public class Appointment implements Serializable{
    private final Doctor doctor;
    private final Patient patient;
    private final Date date;
     String[] args;
    public Appointment(Patient patient, Doctor doctor) {
        this.patient=patient;
        this.doctor=doctor;
        Date date=new Date();
        this.doctor.salary=this.doctor.salary+10;
        this.patient.bill=this.patient.bill+10;
        this.date=date;
    }
    public void prescription(Appointment appointment) throws IOException {
        int k=0;
            for (int i=0;i<this.patient.appointments.size();i++){
                if(this.patient.appointments.get(i).doctor==this.doctor){
                    k++;
                    System.out.println("Number "+k+" prescription "+this.patient.prescription.get(i));
                }
            }
        System.out.println("What's your problem?");
        System.out.println("1.heart problem");
        System.out.println("2.head problem");
        System.out.println("3.chest problem");
        System.out.println("4.breathing problem");
        System.out.print("Choose an option above : ");
        Scanner scanner=new Scanner(System.in);
        String r = scanner.nextLine();
        if (r.isBlank()) {
            throw new NullPointerException();
        }
        int x = Integer.parseInt(r);
        System.out.println();
        switch (x) {
            case 1 -> {
                appointment.patient.prescription.add("on "+appointment.date+" you visited dr "+appointment.doctor.name+" "+appointment.doctor.lastname+" for heart problem");
                this.doctor.appointments.add(this);
                this.patient.appointments.add(this);
                this.doctor.setAppointmentMax(doctor.getAppointmentMax()+1);
                System.out.println("visited successfully!");
                System.out.println("1.Patient Menu");
                System.out.println("2.Hospital Menu");
                System.out.print("Choose an option above : ");
                String q = scanner.nextLine();
                if (q.isBlank()) {
                    throw new NullPointerException();
                }
                int a = Integer.parseInt(q);
                System.out.println();
                switch (a) {
                    case 1 -> appointment.patient.patientLogInMenu(appointment.patient);
                    case 2 -> Hospital.main(args);
                    default -> System.out.println("Invalid Input!");
                }
            }
            case 2 -> {
                appointment.patient.prescription.add("on "+appointment.date+" you visited dr "+appointment.doctor.name+" "+appointment.doctor.lastname+" for head problem");
                this.doctor.appointments.add(this);
                this.patient.appointments.add(this);
                this.doctor.setAppointmentMax(doctor.getAppointmentMax()+1);
                System.out.println("visited successfully!");
                System.out.println("1.Patient Menu");
                System.out.println("2.Hospital Menu");
                System.out.print("Choose an option above : ");
                String q = scanner.nextLine();
                if (q.isBlank()) {
                    throw new NullPointerException();
                }
                int a = Integer.parseInt(q);
                System.out.println();
                switch (a) {
                    case 1 -> appointment.patient.patientLogInMenu(appointment.patient);
                    case 2 -> Hospital.main(args);
                    default -> System.out.println("Invalid Input!");
                }
            }
            case 3 -> {
                appointment.patient.prescription.add("on "+appointment.date+this.patient.name+" "+this.patient.lastname+" visited dr "+appointment.doctor.name+" "+appointment.doctor.lastname+" for chest problem");
                this.doctor.appointments.add(this);
                this.patient.appointments.add(this);
                this.doctor.setAppointmentMax(doctor.getAppointmentMax()+1);
                System.out.println("visited successfully!");
                System.out.println("1.Patient Menu");
                System.out.println("2.Hospital Menu");
                System.out.print("Choose an option above : ");
                String q = scanner.nextLine();
                if (q.isBlank()) {
                    throw new NullPointerException();
                }
                int a = Integer.parseInt(q);
                System.out.println();
                switch (a) {
                    case 1 -> appointment.patient.patientLogInMenu(appointment.patient);
                    case 2 -> Hospital.main(args);
                    default -> System.out.println("Invalid Input!");
                }
            }
            case 4 -> {
                appointment.patient.prescription.add("on "+appointment.date+" you visited dr "+appointment.doctor.name+" "+appointment.doctor.lastname+" for breathing problem");
                this.doctor.appointments.add(this);
                this.patient.appointments.add(this);
                this.doctor.setAppointmentMax(doctor.getAppointmentMax()+1);
                System.out.println("visited successfully!");
                System.out.println("1.Patient Menu");
                System.out.println("2.Hospital Menu");
                System.out.print("Choose an option above : ");
                String q = scanner.nextLine();
                if (q.isBlank()) {
                    throw new NullPointerException();
                }
                int a = Integer.parseInt(q);
                System.out.println();
                switch (a) {
                    case 1 -> appointment.patient.patientLogInMenu(appointment.patient);
                    case 2 -> Hospital.main(args);
                    default -> System.out.println("Invalid Input!");
                }
            }
            default -> System.out.println("Invalid Input!");
        }
    }
    public String toString(){
        return "Patient : "+this.patient.getAllInfo()+" , Doctor : "+ this.doctor.getAllInfo()+" , Date : " +this.date;
    }
}
