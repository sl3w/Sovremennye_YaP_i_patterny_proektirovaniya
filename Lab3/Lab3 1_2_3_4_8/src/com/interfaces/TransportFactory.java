package com.interfaces;

import com.exception.DuplicateModelNameException;

public interface TransportFactory {
    public Vehicle createInstance(String nameModel, int length) throws DuplicateModelNameException;
}
