package com.company;

import java.io.*;
import java.util.ArrayList;

public class ShowTreballadors {
    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("/home/dam2a/Escriptori/random.bin", "r");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/home/dam2a/Escriptori/usersEj21.bin"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/home/dam2a/Escriptori/usersEj21.bin"));

        crearUsers(objectOutputStream);
        showTreballadorsYdepartamentos(objectInputStream,randomAccessFile);
    }

    private static void crearUsers(ObjectOutputStream objectOutputStream) throws IOException {
        String[] nombres = {"Jona", "Don Patricio Mami", "David", "Danis", "Jiayu"};

        for (int i = 0; i < 5 ; i++) {
            User user = new User(nombres[i],(i + 1) * 10);
            objectOutputStream.writeObject(user);
        }

        objectOutputStream.close();
    }

    private static void showTreballadorsYdepartamentos(ObjectInputStream objectInputStream, RandomAccessFile randomAccessFile) throws IOException {

        try {
            Object aux = objectInputStream.readObject();

            while (aux != null) {
                User user = (User) aux;
                String departamento = buscarDepartamento(randomAccessFile, user.getIdDepartamento());

                //System.out.println(departamento);

                System.out.println(user.getNombre() + " trabaja en el departamento " + departamento);
                aux = objectInputStream.readObject();
            }
        }
        catch (EOFException e){
            //System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        objectInputStream.close();
    }

    private static String buscarDepartamento(RandomAccessFile randomAccessFile, int idDepartament) throws IOException {
        int id = randomAccessFile.readInt();

        while(id != idDepartament){

            randomAccessFile.seek(10);

//            for (int i = 0; i <10 ; i++) {
//                randomAccessFile.readChar();
//            }

            id = randomAccessFile.readInt();

            System.out.println(id);
        }

        String departament = "";

        for (int i = 0; i < 10 ; i++) {

            departament += randomAccessFile.readChar();
        }

        return departament;
    }




    }

    class User implements Serializable {

        String nombre;
        private int IdDepartamento;

        public User(String nombre, int idDepartamento) {
            this.nombre = nombre;
            IdDepartamento = idDepartamento;
        }

        public String getNombre() {
            return nombre;
        }

        public int getIdDepartamento() {
            return IdDepartamento;
        }

        @Override
        public String toString() {
            return "User{" +
                    "nombre='" + nombre + '\'' +
                    ", IdDepartamento=" + IdDepartamento +
                    '}';
        }
}

