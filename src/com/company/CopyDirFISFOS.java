package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDirFISFOS {

    public static void main(String[] args) throws IOException {

        File dirOrigen = new File("/home/dam2a/Escriptori/");
        File dirDestino = new File("/home/dam2a/Documents/bin/");

        String[] listaArchivos = dirOrigen.list();

        for (String archivo:
                listaArchivos) {

            FileInputStream original = new FileInputStream(dirOrigen + "/" + archivo);
            FileOutputStream destino = new FileOutputStream(dirDestino + "/" + archivo);

            byte [] array = new byte[1024];

            int leidos = original.read(array);

            while (leidos > -1) {
                destino.write(array,0,leidos);
                leidos=original.read(array);
            }

            original.close();
            destino.close();
            }






    }
}
