package com;

import com.exception.DuplicateModelNameException;
import com.exception.ModelPriceOutOfBoundsException;
import com.exception.NoSuchModelNameException;
import com.interfaces.Vehicle;
import com.Visitor_3_8.Visitor;

import java.io.Serializable;

public class Motorcycle implements Vehicle, Serializable {
    public Motorcycle(String motoModel, int lengthModel) throws DuplicateModelNameException {
        this.motoModel = motoModel;
        for (int i = 0; i < lengthModel; i++) {
            addModel("Model_" + (i + 1), 100 * (i + 1));
        }
    }

    private String motoModel;

    public String getNameModel() {
        return motoModel;
    }

    public void setNameModel(String motoModel) {
        this.motoModel = motoModel;
    }

    private int size = 0;

    public int getLength() {
        return size;
    }


    private class Model {
        String nameModel = null;
        double cost = Double.NaN;
        Model prev = null;
        Model next = null;

    }

    private Model head = new Model();

    {
        head.prev = head;
        head.next = head;
    }

    //метод для получения значения цены модели по её названию
    public double getCostModelByNameModel(String nameModel) throws NoSuchModelNameException {
        Model current = head.next;
        int i = 0;

        while (current != head) {
            if (current.nameModel.equals(nameModel)) {
                return current.cost;
            }
            current = current.next;
            i++;
        }
        throw new NoSuchModelNameException("Модели с имени " + nameModel + " тут нет");
    }

    //метод для модификации значения цены модели по её названию
    public void setCostModelByNameModel(String nameModel, double newCostModel) throws NoSuchModelNameException {
        if (newCostModel < 0) throw new ModelPriceOutOfBoundsException("Цена отрицательная wtf?");
        Model current = head.next;
        boolean flag = false;
        while (current != head) {
            if (current.nameModel.equals(nameModel)) {
                current.cost = newCostModel;
                flag = true;
                return;
            }
            current = current.next;
        }
        if (!flag) throw new NoSuchModelNameException("Модели с имени " + nameModel + " тут нет");
    }

    //метод для модификации значения названия модели
    public void setNewNameModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        Model current = head.next;
        while (current != head) {
            if (current.nameModel.equals(newName)) {
                throw new DuplicateModelNameException("Модель с именем" + newName + " тут есть");
            }
            current = current.next;
        }
        current = head.next;
        boolean flag = false;
        while (current != head) {
            if (current.nameModel.equals(oldName)) {
                current.nameModel = newName;
                flag = true;
                return;
            }
            current = current.next;
        }
        if (!flag) throw new NoSuchModelNameException("Модели с имени " + oldName + " тут нет");
    }

    //метод, возвращающий массив названий всех моделей
    public String[] getNameModelArray() {
        String[] returnArray = new String[this.size];
        Model current = head.next;
        int i = 0;
        while (current != head) {
            returnArray[i] = current.nameModel;
            current = current.next;
            i++;
        }
        return returnArray;
    }

    //метод, возвращающий массив значений цен моделей
    public double[] getCostModelArray() {
        double[] returnArray = new double[this.size];
        Model current = head.next;
        int i = 0;
        while (current != head) {
            returnArray[i] = current.cost;
            current = current.next;
            i++;
        }
        return returnArray;
    }

    //метод добавления названия модели и её цены
    public void addModel(String nameModel, double costModel) throws DuplicateModelNameException {
        if (costModel < 0) throw new ModelPriceOutOfBoundsException("Цена отрицательная wtf?");

        Model current = head.next;
        while (current != head) {
            if (current.nameModel.equals(nameModel)) {
                throw new DuplicateModelNameException("Модели с имени " + nameModel + " уже тут");
            }
            current = current.next;
        }
        Model node = new Model();
        node.nameModel = nameModel;
        node.cost = costModel;

        head.prev.next = node;
        node.next = head;
        node.prev = head.prev;
        head.prev = node;

        size++;
    }

    //метод удаления модели с заданным именем и её цены
    public void removeModel(String nameModel, double costModel) throws NoSuchModelNameException {
        if (costModel < 0) throw new ModelPriceOutOfBoundsException("Цена отрицательная wtf?");
        if (size == 0) return;
        Model current = head.next;
        Model removeNode = null;
        // поиск удаляемого узла

        while (current != head) {
            if (current.nameModel.equals(nameModel) && current.cost == costModel) {
                removeNode = current;
                break;
            }
            current = current.next;
        }

        if (removeNode != null) {
            // если удаляется единственный элемент списка
            if (size == 1) {
                head.next = head;
                head.prev = head;
            } else {
                removeNode.prev.next = removeNode.next;
                removeNode.next.prev = removeNode.prev;
            }
            size--;
        } else throw new NoSuchModelNameException("Модели с имени " + nameModel + " тут нет");
    }


    @Override
    public String toString() {
        String temp = "com.Motorcycle{\n" +
                "motoModel='" + motoModel + '\'' +
                ",\nsize=" + size +
                ",\nModels={\n";
        Model current = head.next;
        if (size > 0) {
            do {
                temp += "{name = " + current.nameModel + ", cost = " + current.cost + "}\n";
                current = current.next;
            }
            while (current != head);
        }

        return temp + '}';
    }

    @Override
    public Vehicle сlone() {
        Motorcycle clone = null;
        try {
            clone = new Motorcycle(motoModel, 0);
        } catch (DuplicateModelNameException e) {
            e.printStackTrace();
        }
        Model p = head.next;
        while (p.next != head) {
            try {
                clone.addModel(p.nameModel, p.cost);
            } catch (DuplicateModelNameException e) {
                e.printStackTrace();
            }
            p = p.next;
        }
        return clone;
    }

    // визитор
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
