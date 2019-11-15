package com.company;

import java.io.*;
import java.util.ArrayList;


public class CopyDirFRFW {

    public static void main(String[] args) throws IOException {


        File origen = new File("/home/dam2a/Escriptori/" );
        File destino = new File("/home/dam2a/Documents/");


        for (File file : origen.listFiles()) {
            new CopyFilesFRFW_Dir().copiar(new File(file.getAbsolutePath()),new File(destino.getAbsolutePath() + "/" + file.getName()));
        }



    }

}

class CopyFilesFRFW_Dir {


    public void copiar(File file, File file2) throws IOException {


        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file2);

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

            bufferedReader.close();
            bufferedWriter.close();
            fileWriter.close();
            fileReader.close();


    }
}