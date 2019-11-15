package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileToCSV {
    public static void main(String[] args) throws IOException {
        ArrayList<User> userslist = new ArrayList<>();
        ObjectFileToCSV objectFileToCSV = new ObjectFileToCSV();
        objectFileToCSV.readUser(userslist);
    }

    public static void readUser(ArrayList<User> list) throws IOException {

        FileInputStream fstream = new FileInputStream("/home/dam2a/Escriptori/user.bin");
        FileWriter fileOutputStream = new FileWriter("/home/dam2a/Escriptori/19.csv");
        BufferedWriter objectOutputStream = new BufferedWriter(fileOutputStream);
        try {
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                User user;
                try {
                    user = (User) ostream.readObject();
                    list.add(user);
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
        } catch (EOFException e) {
            fstream.close();
        }

        for (int i = 0; i < list.size(); i++) {
            objectOutputStream.write(list.get(i).getUsername() + "," + list.get(i).getFirstname() + "," + list.get(i).getLastname() + "," + list.get(i).getEmail() + "," + list.get(i).getPassword());
            objectOutputStream.newLine();
        }
        objectOutputStream.close();
    }

}
class User implements Serializable {
    private String username, firstname,lastname, email, password;
    private static final long serialVersionUID = 12;

    public User(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public Users(Object o) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "username= " + username +
                ", firstname= " + firstname +
                ", lastname= " + lastname +
                ", email= " + email +
                ", password= " + password;
    }
}