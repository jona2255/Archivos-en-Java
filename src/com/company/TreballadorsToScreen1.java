package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreballadorsToScreen1 {

    public static void main(String[] args) throws FileNotFoundException {

        File fleExample = new File("/home/dam2a/Escriptori/treballadors.txt");

        Scanner opnScanner = new Scanner(fleExample);

        int i = 1;

        while(opnScanner.hasNext()) {
            String[] dato = opnScanner.nextLine().split(",");


            System.out.println("Trabajador " + i);
            System.out.println();

            System.out.println("Nombre del trabajador:    " + dato[0]);
            System.out.println("Apellidos del trabajador:     " + dato[1]);
            System.out.println("Salario del trabajador: " + dato[2]);
            System.out.println("Esta casado el trabajador?: " + dato[3]);
            System.out.println();

            i++;
        }
        opnScanner.close();
    }
}
