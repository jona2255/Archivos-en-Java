package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NumsToFile1 {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here


        File fileExample = new File("/home/dam2a/Escriptori/Num11001200.txt");

        PrintWriter pwInput = new PrintWriter(fileExample);

        for (int i = 1100; i <= 1200; i++) {

            pwInput.println(i);

        }

        pwInput.close();

    }
}
