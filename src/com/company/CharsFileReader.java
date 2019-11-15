package com.company;

import java.io.*;

public class CharsFileReader {

    public static void main(String[] args) throws IOException {


        File fileExample = new File("/home/dam2a/Escriptori/alphabeta2.txt");

        FileWriter fileWriter = new FileWriter(fileExample);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (char i = 'a'; i <= 'z'; i++) {

            bufferedWriter.write(i);
            bufferedWriter.newLine();

        }

        bufferedWriter.close();
        fileWriter.close();
    }
}
