import java.io.Serializable;
import java.util.Scanner;

public abstract class People implements Serializable {
    protected String name, lastname, address, email, gender, password, userName;
    protected int age, contact, id;

    public People(String name, String lastname, int age, int contact, String gender, String address, String email, String userName, String password) {

        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.contact = contact;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.userName = userName;
        Staff.un.add(userName);
        this.password = password;
        this.id = Hospital.id;
        Hospital.id++;
        Admin.people.add(this);
    }

    abstract String getAllInfo();

    abstract void getAllAppointments();

}
