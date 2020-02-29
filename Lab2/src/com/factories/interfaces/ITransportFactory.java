package com.factories.interfaces;

import com.exceptions.DuplicateModelNameException;
import com.model.interfaces.Transportable;

public interface ITransportFactory {
    Transportable createInstance(String marka, int modelsCount) throws DuplicateModelNameException;
}
