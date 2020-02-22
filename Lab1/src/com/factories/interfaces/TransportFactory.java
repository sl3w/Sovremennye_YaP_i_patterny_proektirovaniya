package com.factories.interfaces;

import com.exceptions.DuplicateModelNameException;
import com.model.interfaces.Vehiclable;

public interface TransportFactory {
    Vehiclable createInstance(String marka, int modelsCount) throws DuplicateModelNameException;
}
