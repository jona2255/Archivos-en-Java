package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectStreamExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        ArrayList<Persona> arraylist = new ArrayList();

        Scanner sc = new Scanner(System.in);

        System.out.println("Quieres crear una persona?\n1 = Si\n2 = No");
        int crear = sc.nextInt();
        while (crear != 2) {


            sc.nextLine();

            System.out.println("Introduce el nombre");

            String nombre = sc.nextLine();

            Persona persona = new Persona(nombre);

            arraylist.add(persona);
            System.out.println("Quieres crear una persona?\n1 = Si\n2 = No");

            crear = sc.nextInt();
        }
        Persona.introDades(arraylist);
        Persona.mostraDades();


    }

    public static class Persona implements Serializable {

        String nombre;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    '}';
        }

        public static void introDades(ArrayList<Persona> persona) throws IOException {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/home/dam2a/Escriptori/personas17.bin"));

            for (int i = 0; i < persona.size(); i++) {
                Persona persona2 = new Persona(persona.get(i).getNombre());
                objectOutputStream.writeObject(persona2);
            }

            objectOutputStream.close();

        }

        public static void mostraDades() throws IOException, ClassNotFoundException {

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/home/dam2a/Escriptori/personas17.bin"));

            boolean exit = false;
            while (!exit) {
                try {
                    Persona person = (Persona) objectInputStream.readObject();
                    if (person instanceof Persona) {
                            System.out.println(person);
                    }

                } catch (EOFException e){
                    exit = true;
                    objectInputStream.close();
                }
            }
        }
    }
}