package com.factories;

import com.exceptions.DuplicateModelNameException;
import com.factories.interfaces.TransportFactory;
import com.model.Moto;
import com.model.interfaces.Vehiclable;

public class MotoFactory implements TransportFactory {
    @Override
    public Vehiclable createInstance(String marka, int modelsCount) throws DuplicateModelNameException {
        return new Moto(marka, modelsCount);
    }
}
