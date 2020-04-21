package com.interfaces;

import com.exception.DuplicateModelNameException;
import com.exception.NoSuchModelNameException;
import com.Visitor_3_8.Visitor;

public interface Vehicle  extends Cloneable{
    public String getNameModel() ;

    public void setNameModel(String carModel) ;

    //метод для модификации значения названия модели
    public void setNewNameModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException;

    //метод, возвращающий массив названий всех моделей
    public String[] getNameModelArray() ;

    //метод, возвращающий массив значений цен моделей
    public double[] getCostModelArray();

    //метод для получения значения цены модели по её названию
    public double getCostModelByNameModel(String nameModel) throws NoSuchModelNameException ;

    //метод для модификации значения цены модели по её названию
    public void setCostModelByNameModel(String nameModel, double newCostModel) throws NoSuchModelNameException ;

    //метод добавления названия модели и её цены (путем создания нового массива Моделей), использовать метод Arrays.copyOf()
    public void addModel(String nameModel, double costModel) throws DuplicateModelNameException ;

    //метод удаления модели с заданным именем и её цены, использовать методы System.arraycopy, Arrays.copyOf(),
    public void removeModel(String nameModel, double costModel) throws NoSuchModelNameException ;

    //метод для получения размера массива Моделей.
    public int getLength();

    public Vehicle сlone() throws CloneNotSupportedException;

    void accept(Visitor visitor);
}
