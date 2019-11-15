package com.company;

import java.io.*;

public class FileTypes {

    public static void main(String[] args) throws IOException {

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("/home/dam2a/Escriptori/FileTypes.txt"));
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("/home/dam2a/Escriptori/FileTypes.txt"));

        dataOutputStream.writeChar('Y');
        dataOutputStream.writeFloat(7.5f);
        dataOutputStream.writeInt(22);
        dataOutputStream.writeUTF("string");

        dataOutputStream.close();

        while (dataInputStream.available() > 0){

            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readFloat());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());
        }
        dataInputStream.close();
    }
}
