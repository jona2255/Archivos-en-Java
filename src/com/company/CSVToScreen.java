package com.company;

import java.io.*;

public class CSVToScreen {

    public static void main(String[] args) throws IOException {

        File file = new File("/home/dam2a/Escriptori/personas2.csv" );

        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String cabecera = bufferedReader.readLine();

        String[] cab = cabecera.split(",");

        int numPersona = 1;

        boolean fin = false;

        while(fin != true) {

            String persona = bufferedReader.readLine();


            if (persona == null){

                fin = true;

            } else {
                System.out.println("Persona " + numPersona);
                numPersona++;

                String[] campo = persona.split(",");


                for (int i = 0; i < cab.length; i++) {

                    System.out.println(cab[i] + ": " + campo[i]);

                }

                System.out.println("*******");

            }

        }

        bufferedReader.close();
        fileReader.close();
    }
}
