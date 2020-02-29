package com.adapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamPrinter {
    private OutputStream outputStream;

    public StreamPrinter(String[] arr) throws IOException {
        outputStream = new ByteArrayOutputStream();
        for (int i = 0; i < arr.length; i++) {
            outputStream.write((arr[i] + "\r\n").getBytes());
        }
    }

    //method 1
    public void printStream() {
        System.out.println(outputStream.toString());
    }

    //method 2
    public OutputStream getOutputStream() {
        return outputStream;
    }
}
