package com;

import com.exception.DuplicateModelNameException;
import com.interfaces.TransportFactory;
import com.interfaces.Vehicle;

public class MotoFactory implements TransportFactory {
    public Vehicle createInstance(String nameModel, int length) throws DuplicateModelNameException {
        return new Motorcycle(nameModel, length);
    }
}
