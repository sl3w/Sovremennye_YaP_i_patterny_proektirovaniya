package sample.lab4_2.model;

import sample.lab4_2.exceptions.DuplicateModelNameException;
import sample.lab4_2.exceptions.ModelPriceOutOfBoundsException;
import sample.lab4_2.exceptions.NoSuchModelNameException;
import sample.lab4_2.model.interfaces.Transportable;

import java.io.Serializable;
import java.util.Arrays;

public class Auto implements Transportable, Cloneable, Serializable {
    private String marka;
    private Model[] models;

    {
        models = new Model[0];
    }

    public Auto(String marka) {
        this.marka = marka;
    }

    public Auto(String marka, int modelsCount) throws DuplicateModelNameException {
        this.marka = marka;
        for (int i = 1; i <= modelsCount; i++) {
            addNewModel("model_" + i, i * 100);
        }
    }

    @Override
    public String getMarka() {
        return marka;
    }

    @Override
    public void setMarka(String marka) {
        this.marka = marka;
    }

    private void checkForDuplicate(String name) throws DuplicateModelNameException {
        for (int i = 0; i < models.length; i++) {
            if (models[i].getModelName().equals(name)) {
                throw new DuplicateModelNameException();
            }
        }
    }

    @Override
    public void setNewModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        if (!oldName.equals(newName)) {
            checkForDuplicate(newName);

            for (int i = 0; i < models.length; i++) {
                if (models[i].getModelName().equals(oldName)) {
                    models[i].setModelName(newName);
                    return;
                }
            }
            throw new NoSuchModelNameException();
        }
    }

    @Override
    public String[] getModelsNameArray() {
        String[] modelsName = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            modelsName[i] = models[i].getModelName();
        }
        return modelsName;
    }

    @Override
    public void setPriceByModelName(String modelName, double newPrice) throws NoSuchModelNameException {
        if (newPrice < 0)
            throw new ModelPriceOutOfBoundsException();
        for (int i = 0; i < models.length; i++) {
            if (models[i].getModelName().equals(modelName)) {
                models[i].setPrice(newPrice);
                return;
            }
        }
        throw new NoSuchModelNameException();
    }

    @Override
    public double[] getPricesArray() {
        double[] modelsPrices = new double[models.length];
        for (int i = 0; i < models.length; i++) {
            modelsPrices[i] = models[i].getPrice();
        }
        return modelsPrices;
    }

    @Override
    public void addNewModel(String name, double price) throws DuplicateModelNameException {
        if (price < 0)
            throw new ModelPriceOutOfBoundsException();
        checkForDuplicate(name);
        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = new Model(name, price);
    }

    @Override
    public void deleteModel(String delName) throws NoSuchModelNameException {
        int i;
        for (i = 0; i < models.length; i++) {
            if (models[i].getModelName().equals(delName)) {
                break;
            }
        }

        if (i == models.length)
            throw new NoSuchModelNameException();

        Model[] newModels = new Model[models.length - 1];
        if (i != models.length - 1) {
            System.arraycopy(models, 0, newModels, 0, i);
            System.arraycopy(models, i + 1, newModels, i, models.length - i - 1);
            models = newModels;
        } else {
            models = Arrays.copyOf(models, models.length - 1);
        }
    }

    @Override
    public int getModelsCount() {
        return models.length;
    }

    @Override
    public String toString() {
        return "Auto{" + "\r\n" +
                "marka='" + marka + '\'' +
                ", \r\nmodels=" + Arrays.toString(models) +
                "\r\n}";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Auto autoClone = (Auto) super.clone();
        autoClone.models = models.clone();
        for (int i = 0; i < models.length; i++) {
            autoClone.models[i] = (Model) models[i].clone();
        }
        return autoClone;
    }

    private class Model implements Cloneable, Serializable {
        private String modelName;
        private double price;

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

        private Model() {
        }

        public Model(String modelName, double price) {
            this.modelName = modelName;
            this.price = price;
        }

        @Override
        public String toString() {
            return "\r\nModel{" +
                    "modelName='" + modelName + '\'' +
                    ", price=" + price +
                    '}';
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
