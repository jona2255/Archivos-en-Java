package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVToObjectFile {
    public static void main(String[] args) throws IOException {
        ArrayList<User> userslist = new ArrayList<>();
        loadUser(userslist);
        writeUser(userslist);
    }
    public static List loadUser(ArrayList list) throws IOException {
        FileReader fr = new FileReader("user.csv");
        BufferedReader br = new BufferedReader(fr);
        boolean exit = false;
        while (!exit){
            String line = br.readLine();
            if (line == null){
                exit=true;
            }else {
                String[]strings = line.split(",");
                for (int i = 0; i <strings.length ; i++) {
                    list.add(strings[i]);
                }
            }
        }
        return list;
    }
    public static void writeUser(ArrayList list) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.bin"));

        for (int i = 0; i < list.size(); i++) {
            User user = new User((String) list.get(i),(String) list.get(i+=1),(String) list.get(i+=1),(String) list.get(i+=1),(String) list.get(i+=1));
            objectOutputStream.writeObject(user);
        }
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.bin"));
        try {
            while (true){
                User userRead = (User) objectInputStream.readObject();
                System.out.println(userRead);
            }
        }catch (EOFException e ){
            objectInputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public User(Object o) { }

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