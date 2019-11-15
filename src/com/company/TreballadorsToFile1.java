package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TreballadorsToFile1 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        File fileExample = new File("/home/dam2a/Escriptori/treballadors.txt");

        PrintWriter pwInput = new PrintWriter(fileExample);

        boolean continuar = true;

        while (continuar != false){

            System.out.println("Nombre del trabajador");

            String nombre = in.nextLine();
            pwInput.print(nombre + ",");


            System.out.println("Apellidos del trabajador");

            String Apellidos = in.nextLine();
            pwInput.print(Apellidos + ",");


            System.out.println("Salario del trabajador");

            int Salario = in.nextInt();
            pwInput.print(Salario + ",");

            in.nextLine();

            System.out.println("Esta casado el trabajador");

            String casado = in.nextLine();
            pwInput.println(casado);

            System.out.println("¿Quieres Continuar?");

            String cont = in.nextLine();

            if (cont.equals("No") || cont.equals("no")){

                continuar = false;
            }


        }

        pwInput.close();


    }
}
