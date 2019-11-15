package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CharsToFile1 {

        public static void main(String[] args) throws FileNotFoundException {
	// write your code here



            File fileExample = new File("/home/dam2a/Escriptori/alphabeta.txt");

            PrintWriter pwInput = new PrintWriter(fileExample);



            for (char i = 'a'; i <= 'z'; i++) {

                pwInput.println(i);

            }

            pwInput.close();



        }
}
