package com.model;

import com.exceptions.DuplicateModelNameException;
import com.exceptions.ModelPriceOutOfBoundsException;
import com.exceptions.NoSuchModelNameException;
import com.model.interfaces.Vehiclable;

import java.util.Arrays;

public class Moto implements Vehiclable {
    private String marka;
    private Model modelsHead = new Model();
    private int size = 0;

    public Moto(String marka) {
        this.marka = marka;
    }

    public Moto(String marka, int modelsCount) throws DuplicateModelNameException {
        this.marka = marka;
        for (int i = 1; i <= modelsCount; i++) {
            addNewModel("model" + i, i * 100);
        }
    }

    {
        modelsHead.prev = modelsHead;
        modelsHead.next = modelsHead;
    }

    @Override
    public String getMarka() {
        return marka;
    }

    @Override
    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Model getModelsHead() {
        return modelsHead;
    }

    public void setModelsHead(Model head) {
        this.modelsHead = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private boolean checkForDuplicate(String name) throws DuplicateModelNameException {
        Model p = modelsHead.next;
        while (p != modelsHead) {
            if (p.getModelName().equals(name)) {
                throw new DuplicateModelNameException();
            }
            p = p.next;
        }
        return true;
    }

    @Override
    public void setNewModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        if (!oldName.equals(newName)) {
            checkForDuplicate(newName);
            Model p = modelsHead.next;
            while (p != modelsHead) {
                if (p.getModelName().equals(oldName)) {
                    p.setModelName(newName);
                    return;
                }
                p = p.next;
            }
            throw new NoSuchModelNameException();
        }
    }

    @Override
    public String[] getModelsNameArray() {
        String[] modelsName = new String[size];
        Model p = modelsHead.next;
        int i = 0;
        while (p != modelsHead) {
            modelsName[i++] = p.getModelName();
            p = p.next;
        }
        return modelsName;
    }

    @Override
    public void setPriceByModelName(String modelName, double newPrice) throws NoSuchModelNameException {
        if (newPrice < 0)
            throw new ModelPriceOutOfBoundsException();
        Model p = modelsHead.next;
        while (p != modelsHead) {
            if (p.getModelName().equals(modelName)) {
                p.setPrice(newPrice);
                return;
            }
            p = p.next;
        }
        throw new NoSuchModelNameException();
    }

    @Override
    public double[] getPricesArray() {
        double[] modelsPrices = new double[size];
        Model p = modelsHead.next;
        int i = 0;
        while (p != modelsHead) {
            modelsPrices[i++] = p.getPrice();
            p = p.next;
        }
        return modelsPrices;
    }

    @Override
    public void addNewModel(String name, double price) throws DuplicateModelNameException {
        if (price < 0)
            throw new ModelPriceOutOfBoundsException();
        checkForDuplicate(name);
        Model p = modelsHead;
        while (p.next != modelsHead) {
            p = p.next;
        }

        Model newModel = new Model(name, price);

        newModel.next = p.next;
        newModel.prev = p;
        p.next.prev = newModel;
        p.next = newModel;

        size++;
    }

    @Override
    public void deleteModel(String delName) throws NoSuchModelNameException {
        Model p = modelsHead.next;
        while (p != modelsHead) {
            if (p.getModelName().equals(delName)) {
                p.prev.next = p.next;
                p = null;
                size--;
                return;
            }
            p = p.next;
        }
        throw new NoSuchModelNameException();
    }

    @Override
    public int getModelsCount() {
        return size;
    }

    @Override
    public String toString() {
        return "Moto{" + "\r\n" +
                "marka='" + marka + '\'' +
                ", \r\nmodelsHead=" + modelsHead +
                "\r\n}";
    }

    private class Model {
        String modelName = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public Model() {
        }

        public Model(String modelName, double price) {
            this.modelName = modelName;
            this.price = price;
        }

        public Model(String modelName, double price, Model prev, Model next) {
            this.modelName = modelName;
            this.price = price;
            this.prev = prev;
            this.next = next;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Model getPrev() {
            return prev;
        }

        public void setPrev(Model prev) {
            this.prev = prev;
        }

        public Model getNext() {
            return next;
        }

        public void setNext(Model next) {
            this.next = next;
        }

        @Override
        public String toString() {
            Model p = modelsHead.getNext();
            String str = "";
            while (p != modelsHead) {
                str += "\r\nModel{" +
                        "modelName='" + p.getModelName() + '\'' +
                        ", price=" + p.getPrice() +
                        '}';
                p = p.getNext();
            }
            return str;
        }
    }
}
