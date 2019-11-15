package com.company;

import java.io.*;
import java.util.Scanner;

public class FileReaderAlpha {

    public static void main(String[] args) throws IOException {

        File files = new File("/home/dam2a/Escriptori/alphabeta.txt");

        FileReader fileReader = new FileReader(files);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        boolean fun = false;

        while(fun != true) {


            String caracter = bufferedReader.readLine();

            if (caracter == null){

                fun = true;
            } else {

                System.out.print(caracter.toUpperCase() + " ");

            }
        }

        bufferedReader.close();
        fileReader.close();
    }
}
