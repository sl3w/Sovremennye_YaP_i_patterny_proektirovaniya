package com.factories;

import com.exceptions.DuplicateModelNameException;
import com.factories.interfaces.ITransportFactory;
import com.model.Moto;
import com.model.interfaces.Transportable;

public class MotoFactory implements ITransportFactory {
    private static MotoFactory motoFactory;

    private MotoFactory() {
    }

    @Override
    public Transportable createInstance(String marka, int modelsCount) throws DuplicateModelNameException {
        return new Moto(marka, modelsCount);
    }

    public static MotoFactory getFactory() {
        if (motoFactory == null)
            motoFactory = new MotoFactory();
        return motoFactory;
    }
}
