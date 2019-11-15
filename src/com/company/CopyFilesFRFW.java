package com.company;

import java.io.*;

public class CopyFilesFRFW {

    public static void main(String[] args) throws IOException {


        File files = new File("/home/dam2a/Escriptori/alphabeta.txt");
        File files2 = new File("/home/dam2a/Escriptori/alphabeta3.txt");

        FileReader fileReader = new FileReader(files);
        FileWriter fileWriter = new FileWriter(files2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        boolean fin = false;
        while(fin != true) {


            String caracter = bufferedReader.readLine();

            if (caracter == null){

                fin = true;

            } else {

                bufferedWriter.write(caracter);
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.close();
        bufferedReader.close();
        fileWriter.close();
        fileReader.close();


    }
}
