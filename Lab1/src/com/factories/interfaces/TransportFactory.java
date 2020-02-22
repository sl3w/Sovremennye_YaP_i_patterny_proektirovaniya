package com.factories.interfaces;

import com.exceptions.DuplicateModelNameException;
import com.model.interfaces.Transportable;

public interface TransportFactory {
    Transportable createInstance(String marka, int modelsCount) throws DuplicateModelNameException;
}
