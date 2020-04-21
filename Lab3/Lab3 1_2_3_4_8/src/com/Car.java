package com;

import com.Command_3_2.Command;
import com.exception.DuplicateModelNameException;
import com.exception.ModelPriceOutOfBoundsException;
import com.exception.NoSuchModelNameException;
import com.interfaces.Vehicle;
import com.Visitor_3_8.Visitor;
import java.util.Iterator;

import java.io.*;
import java.util.Arrays;

public class Car implements Vehicle, Serializable {
    private String carModel;
    private Model[] arrayModel;

    //Конструктор класса должен принимать в качестве параметров значение Марки автомобиля и размер массива Моделей.
    public Car(String carModel, int lenthArrayModel) {
        this.carModel = carModel;
        this.arrayModel = new Model[lenthArrayModel];
        for (int i = 0; i < this.arrayModel.length; i++) {
            this.arrayModel[i] = new Model("Model_" + (i + 1), 100 * (i + 1));
        }
    }

    public String getNameModel() {
        return carModel;
    }

    public void setNameModel(String carModel) {
        this.carModel = carModel;
    }

    //метод для модификации значения названия модели
    public void setNewNameModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        boolean flag = false;
        for (int i = 0; i < arrayModel.length; i++) {
            if (arrayModel[i].getNameModel().equals(newName)) {
                throw new DuplicateModelNameException("Модели с имени " + newName + " тут");
            }
        }
        for (int i = 0; i < arrayModel.length; i++) {
            if (arrayModel[i].getNameModel().equals(oldName)) {
                arrayModel[i].setNameModel(newName);
                flag = true;
            }
        }
        if (!flag) throw new NoSuchModelNameException("Модели с имени " + oldName + " тут нет");
    }

    //метод, возвращающий массив названий всех моделей
    public String[] getNameModelArray() {
        String[] returnArray = new String[arrayModel.length];
        for (int i = 0; i < arrayModel.length; i++) {
            returnArray[i] = arrayModel[i].getNameModel();
        }
        return returnArray;
    }

    //метод, возвращающий массив значений цен моделей
    public double[] getCostModelArray() {
        double[] returnArray = new double[arrayModel.length];
        for (int i = 0; i < arrayModel.length; i++) {
            returnArray[i] = arrayModel[i].getCostModel();
        }
        return returnArray;
    }

    //метод для получения значения цены модели по её названию
    public double getCostModelByNameModel(String nameModel) throws NoSuchModelNameException {
        for (int i = 0; i < arrayModel.length; i++) {
            if (arrayModel[i].getNameModel().equals(nameModel)) {
                return arrayModel[i].getCostModel();
            }
        }
        throw new NoSuchModelNameException("Модели с имени " + nameModel + " тут нет");
    }

    //метод для модификации значения цены модели по её названию
    public void setCostModelByNameModel(String nameModel, double newCostModel) throws NoSuchModelNameException {
        boolean flag = false;
        for (int i = 0; i < arrayModel.length; i++) {
            if (arrayModel[i].getNameModel().equals(nameModel)) {
                arrayModel[i].setCostModel(newCostModel);
                flag = true;
            }
        }
        if (!flag) throw new NoSuchModelNameException("Модели с имени " + nameModel + " тут нет");
    }

    //метод добавления названия модели и её цены (путем создания нового массива Моделей), использовать метод Arrays.copyOf()
    public void addModel(String nameModel, double costModel) throws DuplicateModelNameException {
        for (int i = 0; i < arrayModel.length; i++) {
            if (arrayModel[i].getNameModel().equals(nameModel)) {
                throw new DuplicateModelNameException("Модели с имени " + nameModel + " уже тут");
            }
        }
        int newLength = arrayModel.length + 1;
        this.arrayModel = Arrays.copyOf(arrayModel, newLength);
        this.arrayModel[newLength - 1] = new Model(nameModel, costModel);

//        Model[] newArrayModel = Arrays.copyOf(arrayModel, newLength);
//        newArrayModel[newLength - 1] = new Model(nameModel, costModel);
//        this.arrayModel = newArrayModel;
    }

    //метод удаления модели с заданным именем и её цены, использовать методы System.arraycopy, Arrays.copyOf(),
    public void removeModel(String nameModel, double costModel) throws NoSuchModelNameException {
        int positionModel = -1;
        for (int i = 0; i < arrayModel.length; i++) {
            if (arrayModel[i].getNameModel().equals(nameModel) && arrayModel[i].getCostModel() == costModel) {
                positionModel = i;
                break;
            }
        }
        if (positionModel == -1) throw new NoSuchModelNameException("Модели с имени " + nameModel + " тут нет");

        System.arraycopy(arrayModel, positionModel + 1, arrayModel, positionModel, arrayModel.length - positionModel - 1);
        arrayModel = Arrays.copyOf(arrayModel, arrayModel.length - 1);


//        if (positionModel == arrayModel.length - 1) {
//            this.arrayModel = Arrays.copyOf(arrayModel,arrayModel.length - 1);
//            return;
//        } else {
//            Model[] newArrayModel = new Model[arrayModel.length - 1];
//            System.arraycopy(arrayModel, 0, newArrayModel , 0, positionModel);
//            System.arraycopy(arrayModel, positionModel + 1, newArrayModel , positionModel, arrayModel.length - positionModel - 1);
//            this.arrayModel = newArrayModel;
//            return;
//        }
    }

    //метод для получения размера массива Моделей.
    public int getLength() {
        return this.arrayModel.length;
    }

    static class Model implements Cloneable, Serializable {
        private String nameModel;
        private double costModel;

        public Model(String nameModel, double costModel) {
            this.nameModel = nameModel;
            if (costModel < 0) throw new ModelPriceOutOfBoundsException("Цена отрицательная wtf?");
            this.costModel = costModel;
        }

        public String getNameModel() {
            return nameModel;
        }

        public void setNameModel(String nameModel) {
            this.nameModel = nameModel;
        }

        public double getCostModel() {
            return costModel;
        }

        public void setCostModel(double costModel) {
            if (costModel < 0) throw new ModelPriceOutOfBoundsException("Цена отрицательная wtf?");
            this.costModel = costModel;
        }

        @Override
        public String toString() {
            return "Model {" +
                    "nameModel='" + nameModel + '\'' +
                    ", costModel=" + costModel +
                    '}';
        }

        @Override
        protected Model clone() throws CloneNotSupportedException {
            return (Model) super.clone();
        }
    }

    @Override
    public String toString() {
        return "com.Car{" +
                "\ncarModel='" + carModel + '\'' +
                ",arrayModel=\n" + Arrays.toString(arrayModel) +
                '}';
    }

    @Override
    public Vehicle сlone() throws CloneNotSupportedException {
        Car clone = (Car) super.clone();
        clone.arrayModel = arrayModel.clone();
        for (int i = 0; i < clone.arrayModel.length; i++) {
            clone.arrayModel[i] = this.arrayModel[i].clone();
        }
        return clone;
    }

    private Command command;

    public void setPrintCommand(Command command) {
        this.command = command;
    }

    public void print(FileWriter fileWriter) {
        if (command != null) {
            command.execute(fileWriter, this);
        }
    }

    //итератор
    public Iterator iterator() {
        return new AutoIterator();
    }

    public class AutoIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < arrayModel.length;
        }

        @Override
        public Object next() {
            return arrayModel[index++];
        }
    }
    // \итератор

    //мементо
    public void createMemento(Memento memento) {
        memento.setAuto(this);
    }

    public void setMemento(Memento memento) {
        Car carMemento = memento.getAuto();
        this.carModel = carMemento.getNameModel();
        this.arrayModel = carMemento.arrayModel;
    }

    public static class Memento implements Serializable {
        private ByteArrayOutputStream bArrayOutputStream;

        public void setAuto(Car car) {
            bArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(bArrayOutputStream);
                out.writeObject(car);
                out.flush();
                bArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Car getAuto() {
            try {
                ByteArrayInputStream in = new ByteArrayInputStream(this.bArrayOutputStream.toByteArray());
                ObjectInputStream is = new ObjectInputStream(in);
                Car car = (Car) is.readObject();
                return car;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    // \мементо

    // визитор
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
