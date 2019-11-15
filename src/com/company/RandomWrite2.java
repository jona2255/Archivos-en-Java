package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class RandomWrite2 {
    public static void main(String[] args) throws IOException {


        RandomAccessFile file = new RandomAccessFile("/home/dam2a/Escriptori/random.bin", "rw");

        ArrayList<String> list = new ArrayList<>();

        list.add("departmen1");
        list.add("departmen2");
        list.add("departmen3");
        list.add("departmen4");
        list.add("departmen5");
        StringBuffer stringBuffer = null;

        for (int i = 0; i < list.size(); i++) {

            file.writeInt((i + 1) *10);
            stringBuffer = new StringBuffer(list.get(i));
            stringBuffer.setLength(10);
            file.writeChars(stringBuffer.toString());

        }

        file.close();

    }
}
