package com.decorator;

import com.exceptions.DuplicateModelNameException;
import com.exceptions.NoSuchModelNameException;
import com.model.interfaces.Transportable;

public class Decorator implements Transportable {
    Transportable transport;

    public Decorator(Transportable transport) {
        this.transport = transport;
    }

    @Override
    public synchronized String getMarka() {
        return transport.getMarka();
    }

    @Override
    public synchronized void setMarka(String marka) {
        transport.setMarka(marka);
    }

    @Override
    public synchronized void setNewModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        transport.setNewModelName(oldName, newName);
    }

    @Override
    public synchronized String[] getModelsNameArray() {
        return transport.getModelsNameArray();
    }

    @Override
    public synchronized void setPriceByModelName(String modelName, double newPrice) throws NoSuchModelNameException {
        transport.setPriceByModelName(modelName, newPrice);
    }

    @Override
    public synchronized double[] getPricesArray() {
        return transport.getPricesArray();
    }

    @Override
    public synchronized void addNewModel(String name, double price) throws DuplicateModelNameException {
        transport.addNewModel(name, price);
    }

    @Override
    public synchronized void deleteModel(String delName) throws NoSuchModelNameException {
        transport.deleteModel(delName);
    }

    @Override
    public synchronized int getModelsCount() {
        return transport.getModelsCount();
    }

    @Override
    public synchronized Object clone() throws CloneNotSupportedException {
        return transport.clone();
    }
}
