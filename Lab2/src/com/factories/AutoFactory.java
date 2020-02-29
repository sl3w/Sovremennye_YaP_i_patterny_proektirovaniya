package com.factories;

import com.exceptions.DuplicateModelNameException;
import com.factories.interfaces.ITransportFactory;
import com.model.Auto;
import com.model.interfaces.Transportable;

public class AutoFactory implements ITransportFactory {
    private static AutoFactory autoFactory;

    private AutoFactory() {
    }

    @Override
    public Transportable createInstance(String marka, int modelsCount) throws DuplicateModelNameException {
        return new Auto(marka, modelsCount);
    }

    public static AutoFactory getFactory() {
        if (autoFactory == null) {
            autoFactory = new AutoFactory();
        }
        return autoFactory;
    }
}
