package com.adapter;

import java.io.IOException;
import java.io.OutputStream;

public class Adapter extends StreamPrinter implements IAdapter {

    public Adapter(String[] arr) throws IOException {
        super(arr);
    }

    //method 1
    @Override
    public void print() {
        printStream();
    }

    //method 2
    @Override
    public OutputStream getOutPutStream() {
        return getOutputStream();
    }
}
