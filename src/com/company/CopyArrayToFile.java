package com.company;

import java.io.*;
import java.util.Scanner;

public class CopyArrayToFile {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        File file = new File("/home/dam2a/Escriptori/copia.txt");

        String[] palabras = new String[5];

        for (int i = 0; i < palabras.length; i++) {

            palabras[i] = in.nextLine();
        }

        guardar(palabras, file);
        mostrar(file);

    }

    static void mostrar(File file) throws IOException {

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        boolean fin = false;

        while(fin != true) {


            String caracter = bufferedReader.readLine();

            if (caracter == null){

                fin = true;

            } else {

                System.out.println(caracter);
            }
        }

        bufferedReader.close();
        fileReader.close();


    }

    static void guardar(String[] palabras, File file) throws IOException {


        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (String words:
             palabras) {

            bufferedWriter.write(words);
            bufferedWriter.newLine();

        }

        bufferedWriter.close();
        fileWriter.close();

    }
}
