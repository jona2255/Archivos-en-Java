package com.company;

import java.io.*;

public class CopyFilesBin {

    public static void main(String[] args) throws IOException {


        FileInputStream original = new FileInputStream("/home/dam2a/Escriptori/imagen.jpg");
        FileOutputStream destino = new FileOutputStream("/home/dam2a/Escriptori/imagencopia.jpg");

        DataInputStream dataInputStream = new DataInputStream(original);
        DataOutputStream dataOutputStream = new DataOutputStream(destino);



        dataOutputStream.write(dataInputStream.readAllBytes());


        dataOutputStream.close();
        dataInputStream.close();

        original.close();
        destino.close();
    }
}
