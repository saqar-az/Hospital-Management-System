import java.io.*;
import java.io.IOException;

public class File {
    protected static String pathD = "files\\Doc.txt"; //path to your txt file for doctors info;
    protected static String pathN = "files\\Nurse.txt"; //path to your txt file for nurses info;
    protected static String pathP = "files\\Pa.txt"; //path to your txt file for patients info;
    protected static String pathS = "files\\Sec.txt"; //path to your txt file for secretaries info;

    public static void saveDoc() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathD);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < Admin.people.size(); i++) {
                if (Admin.people.get(i) instanceof Doctor doctor) {
                    out.writeObject(doctor);
                }
            }
            out.close();
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readDoc() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pathD))) {
            while (true) {
                Doctor doctor = (Doctor) in.readObject();
                Admin.people.add(doctor);
                Staff.un.add(doctor.userName);
            }
        } catch (EOFException eof) {
            System.out.println("Reached end of file");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (Admin.people.size() != 0) {
                for (int i = 0; i < Admin.people.size(); i++) {
                    if (Admin.people.get(i) instanceof Doctor doctor) {
                        Hospital.id = doctor.id + 1;
                    }
                }

            }
        }
    }

    public static void savePat() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathP);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < Admin.people.size(); i++) {
                if (Admin.people.get(i) instanceof Patient patient) {
                    out.writeObject(patient);
                }
            }
            out.close();
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readPat() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pathP))) {
            while (true) {
                Patient patient = (Patient) in.readObject();
                Admin.people.add(patient);
            }
        } catch (EOFException eof) {
            System.out.println("Reached end of file");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (Admin.people.size() != 0) {
                for (int i = 0; i < Admin.people.size(); i++) {
                    if (Admin.people.get(i) instanceof Patient patient) {
                        Hospital.id = patient.id + 1;
                        Staff.un.add(patient.userName);
                    }
                }

            }
        }
    }

    public static void saveNur() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathN);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < Admin.staff.size(); i++) {
                if (Admin.staff.get(i) instanceof Nurse nurse) {
                    out.writeObject(nurse);
                }
            }
            out.close();
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readNur() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pathN))) {
            while (true) {
                Nurse nurse = (Nurse) in.readObject();
                Admin.staff.add(nurse);
            }
        } catch (EOFException eof) {
            System.out.println("Reached end of file");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (Admin.staff.size() != 0) {
                for (int i = 0; i < Admin.staff.size(); i++) {
                    if (Admin.staff.get(i) instanceof Nurse nurse) {
                        Hospital.id = nurse.id + 1;
                    }
                }

            }
        }
    }

    public static void saveSec() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathS);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < Admin.staff.size(); i++) {
                if (Admin.staff.get(i) instanceof Secretary secretary) {
                    out.writeObject(secretary);
                }
            }
            out.close();
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readSec() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pathS))) {
            while (true) {
                Secretary secretary = (Secretary) in.readObject();
                Admin.staff.add(secretary);
            }
        } catch (EOFException eof) {
            System.out.println("Reached end of file");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (Admin.staff.size() != 0) {
                for (int i = 0; i < Admin.staff.size(); i++) {
                    if (Admin.staff.get(i) instanceof Secretary secretary) {
                        Hospital.id = secretary.id + 1;
                    }
                }

            }
        }
    }
}
