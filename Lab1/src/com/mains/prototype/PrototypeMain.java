package com.mains.prototype;

import com.exceptions.DuplicateModelNameException;
import com.exceptions.NoSuchModelNameException;
import com.model.Auto;
import com.model.Moto;
import com.model.interfaces.Transportable;

import java.util.Arrays;

public class PrototypeMain {
    public static void main(String[] args) throws DuplicateModelNameException, CloneNotSupportedException, NoSuchModelNameException {
        Transportable auto = new Moto("marka", 2);
        Transportable autoClone = (Transportable) auto.clone();

        write("Original: " + Arrays.toString(auto.getModelsNameArray()));
        write("Copy: " + Arrays.toString(autoClone.getModelsNameArray()));

        write("----------------------------------------");

        auto.setNewModelName("model_2", "model_222");
        autoClone.setNewModelName("model_1", "model_111");

        write("Original: " + Arrays.toString(auto.getModelsNameArray()));
        write("Copy: " + Arrays.toString(autoClone.getModelsNameArray()));
    }

    private static void write(String str) {
        System.out.println(str);
    }
}
