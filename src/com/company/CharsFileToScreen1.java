package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharsFileToScreen1 {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here

        File fleExample = new File("/home/dam2a/Escriptori/alphabeta.txt");
        Scanner opnScanner = new Scanner(fleExample);

        while(opnScanner.hasNext()) {

            System.out.print(opnScanner.nextLine().toUpperCase());
            System.out.print(" ");
        }
        opnScanner.close();
    }
}
