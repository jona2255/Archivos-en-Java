package com.company;

import java.io.*;
import java.util.ArrayList;

public class RecordsTextToCSV {

    public static void main(String[] args) throws IOException {


        File leer = new File("/home/dam2a/Escriptori/personas.txt" );
        File escribir = new File("/home/dam2a/Escriptori/personas.csv" );

        FileWriter fileWriter = new FileWriter(escribir);
        FileReader fileReader = new FileReader(leer);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        ArrayList<String> list = llegeixFitxer(bufferedReader);

        String[] persona1 = new String[3];
        String[] persona2 = new String[3];
        String[] persona3 = new String[3];


        mostraPerPantalla(list,persona1,persona2,persona3);

        escriuSortidaCSV(escribir,bufferedWriter,persona1,persona2,persona3);

        bufferedReader.close();
        bufferedWriter.close();
        fileReader.close();
        fileWriter.close();

    }

    static ArrayList<String> llegeixFitxer(BufferedReader bufferedReader) throws IOException {

        boolean fin = false;

        ArrayList<String> list = new ArrayList<>();


        while(fin != true) {

            String caracter = bufferedReader.readLine();

            if (caracter == null){

                fin = true;

            } else if (!caracter.equals("****")) {

                list.add(caracter);
            }

            }

        return list;
    }

    static void mostraPerPantalla(ArrayList<String> list, String[] persona1, String[] persona2, String[] persona3){



        for (int i = 0; i < persona1.length; i++) {
            persona1[i] = list.get(i);
        }
        for (int i = 0; i < persona2.length; i++) {
            persona2[i] = list.get(i+3);
        }
        for (int i = 0; i < persona3.length; i++) {
            persona3[i] = list.get(i+6);
        }


        for (int i = 0; i < persona1.length; i++) {
            System.out.println(persona1[i]);        }
        System.out.println();
        for (int i = 0; i < persona2.length; i++) {
            System.out.println(persona2[i]);        }
        System.out.println();
        for (int i = 0; i < persona3.length; i++) {
            System.out.println(persona3[i]);        }
        System.out.println();

    }

    static void escriuSortidaCSV(File escribir, BufferedWriter bufferedWriter, String[] persona1, String[] persona2, String[] persona3) throws IOException {

        bufferedWriter.write("nom,cognoms,edat");
        bufferedWriter.newLine();

        bufferedWriter.write(persona1[0] + "," + persona1[1] + "," + persona1[2]);
        bufferedWriter.newLine();

        bufferedWriter.write(persona2[0] + "," + persona2[1] + "," + persona2[2]);
        bufferedWriter.newLine();

        bufferedWriter.write(persona3[0] + "," + persona3[1] + "," + persona3[2]);
        bufferedWriter.newLine();

    }
}
