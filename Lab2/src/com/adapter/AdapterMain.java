package com.adapter;

import com.Transport;
import com.exceptions.DuplicateModelNameException;
import com.model.Auto;
import com.model.interfaces.Transportable;

import java.io.IOException;

public class AdapterMain {
    public static void main(String[] args) throws DuplicateModelNameException, IOException {
        Transportable tr = Transport.createInstance("car", 5);

//method 1
        IAdapter iAdapter = new Adapter(tr.getModelsNameArray());
        iAdapter.print();

//method 2
        IAdapter iAdapter2 = new Adapter(tr.getModelsNameArray());
        System.out.println(iAdapter2.getOutPutStream());
    }
}
