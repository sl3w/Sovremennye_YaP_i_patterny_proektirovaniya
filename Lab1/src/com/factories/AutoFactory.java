package com.factories;

import com.exceptions.DuplicateModelNameException;
import com.factories.interfaces.TransportFactory;
import com.model.Auto;
import com.model.interfaces.Vehiclable;

public class AutoFactory implements TransportFactory {
    @Override
    public Vehiclable createInstance(String marka, int modelsCount) throws DuplicateModelNameException {
        return new Auto(marka, modelsCount);
    }
}
