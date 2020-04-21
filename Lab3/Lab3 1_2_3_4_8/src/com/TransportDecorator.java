package com;

import com.exception.DuplicateModelNameException;
import com.exception.NoSuchModelNameException;
import com.interfaces.Vehicle;
import com.Visitor_3_8.Visitor;

public class TransportDecorator implements Vehicle {

    private Vehicle vehicle;

    public TransportDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public synchronized String getNameModel() {
        return vehicle.getNameModel();
    }

    @Override
    public synchronized void setNameModel(String carModel) {
        vehicle.setNameModel(carModel);
    }

    @Override
    public synchronized void setNewNameModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        vehicle.setNewNameModel(oldName, newName);
    }

    @Override
    public synchronized String[] getNameModelArray() {
        return vehicle.getNameModelArray();
    }

    @Override
    public synchronized double[] getCostModelArray() {
        return vehicle.getCostModelArray();
    }

    @Override
    public synchronized double getCostModelByNameModel(String nameModel) throws NoSuchModelNameException {
        return vehicle.getCostModelByNameModel(nameModel);
    }

    @Override
    public synchronized void setCostModelByNameModel(String nameModel, double newCostModel) throws NoSuchModelNameException {
        vehicle.setCostModelByNameModel(nameModel,  newCostModel);
    }

    @Override
    public synchronized void addModel(String nameModel, double costModel) throws DuplicateModelNameException {
        vehicle.addModel(nameModel, costModel);
    }

    @Override
    public synchronized void removeModel(String nameModel, double costModel) throws NoSuchModelNameException {
        vehicle.removeModel(nameModel, costModel);
    }

    @Override
    public synchronized int getLength() {
        return  vehicle.getLength();
    }

    @Override
    public synchronized Vehicle сlone() throws CloneNotSupportedException {
        return  vehicle.сlone();
    }

    @Override
    public synchronized void accept(Visitor visitor) {
        vehicle.accept(visitor);
    }
}
