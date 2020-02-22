package com.factories;

import com.exceptions.DuplicateModelNameException;
import com.factories.interfaces.TransportFactory;
import com.model.Moto;
import com.model.interfaces.Transportable;

public class MotoFactory implements TransportFactory {
    @Override
    public Transportable createInstance(String marka, int modelsCount) throws DuplicateModelNameException {
        return new Moto(marka, modelsCount);
    }
}
