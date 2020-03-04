package sample.lab4_2.model.interfaces;

import sample.lab4_2.exceptions.DuplicateModelNameException;
import sample.lab4_2.exceptions.NoSuchModelNameException;

public interface Transportable {
    String getMarka();
    void setMarka(String marka);
    void setNewModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException;
    String[] getModelsNameArray();
    void setPriceByModelName(String modelName, double newPrice) throws NoSuchModelNameException;
    double[] getPricesArray();
    void addNewModel(String name, double price) throws DuplicateModelNameException;
    void deleteModel(String delName) throws NoSuchModelNameException;
    int getModelsCount();
    String toString();
    Object clone() throws CloneNotSupportedException;
}
