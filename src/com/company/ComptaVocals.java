package com.company;

import java.io.*;

public class ComptaVocals {

    public static void main(String[] args) throws IOException {

        File leer = new File("/home/dam2a/Escriptori/treballadors.txt" );
        File escribir = new File("/home/dam2a/Escriptori/comptavocals.csv" );

        FileWriter fileWriter = new FileWriter(escribir);
        FileReader fileReader = new FileReader(leer);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        bufferedWriter.write("a,e,i,o,u");
        bufferedWriter.newLine();

        boolean fin = false;

        int a = 0,e = 0,i = 0,o = 0,u = 0;

        while(fin != true) {


            String caracter = bufferedReader.readLine();

            if (caracter == null){

                fin = true;

            } else {

                for (int j = 0; j < caracter.length(); j++) {

                    switch (caracter.charAt(j)){

                        case 'a':
                        case 'A':
                            a++;
                            break;
                        case 'e':
                        case 'E':
                            e++;
                            break;
                        case 'i':
                        case 'I':
                            i++;
                            break;
                        case 'o':
                        case 'O':
                            o++;
                            break;
                        case 'u':
                        case 'U':
                            u++;
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        bufferedWriter.write(a + "," + e + "," + i + "," + o + "," + u);


        bufferedReader.close();
        bufferedWriter.close();
        fileReader.close();
        fileWriter.close();

    }
}
